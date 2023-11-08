package org.hbrs.se1.ws23.uebung3.persistence;

import org.hbrs.se1.ws23.uebung3.Member;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream implements PersistenceStrategy<Member> {

    private String location = "./src/codesSE2023/src/org/hbrs/se1/ws23/uebung3/docs/objects.ser";
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private boolean connectedOpen = false;
    private ByteArrayOutputStream byteOutputStream;

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void openConnection() throws PersistenceException {
        if (!connectedOpen) {
            try {
                File file = new File(location);
                if (!file.exists() && !location.endsWith("/")) {
                    file.createNewFile();
                    ObjectOutputStream tmp = new ObjectOutputStream(new FileOutputStream(file));
                    tmp.writeObject("");
                    tmp.close();
                }
                byteOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(this.byteOutputStream);
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                connectedOpen = true;
            } catch (IOException ioException) {
                throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Failed to open a connection!");
            }
        }
    }

    @Override
    public void closeConnection() throws PersistenceException {
        if (connectedOpen) {
            try {
                objectInputStream.close();
                objectOutputStream.close();
                byteOutputStream.close();
                connectedOpen = false;
            } catch (IOException e) {
                throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Failed to open a connection!");
            }
        }
    }

    @Override
    public void save(List<Member> memberList) throws PersistenceException {
        if (connectedOpen) {
            try {
                objectOutputStream.writeObject(memberList);
                FileOutputStream fileOutputStream = new FileOutputStream(location);
                fileOutputStream.write(byteOutputStream.toByteArray());
                fileOutputStream.close();
            } catch (IOException ioException) {
                throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Failed to open a connection!");
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Member> load() throws PersistenceException {

        if (!connectedOpen) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Failed to open a connection!");
        }

        try {
            List<Member> memberList = (List<Member>) objectInputStream.readObject();
            //System.out.println(memberList); Test!
            return memberList;
        } catch (Exception exception) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Failed to open a connection!");
        }
    }
}
