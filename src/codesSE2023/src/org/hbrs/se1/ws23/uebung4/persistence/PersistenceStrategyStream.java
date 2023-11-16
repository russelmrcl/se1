package org.hbrs.se1.ws23.uebung4.persistence;

import org.hbrs.se1.ws23.uebung4.UserStories;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream implements PersistenceStrategy<UserStories> {

    private String location = "./src/codesSE2023/src/org/hbrs/se1/ws23/uebung4/docs/objects.ser";
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
    public void save(List<UserStories> userStoriesList) throws PersistenceException {
        if (connectedOpen) {
            try {
                objectOutputStream.writeObject(userStoriesList);
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
    public List<UserStories> load() throws PersistenceException {

        if (!connectedOpen) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Failed to open a connection!");
        }

        try {
            List<UserStories> userStoriesList = (List<UserStories>) objectInputStream.readObject();
            return userStoriesList;
        } catch (Exception exception) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Failed to open a connection!");
        }
    }
}
