package org.hbrs.se1.ws23.uebung3;

import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private static Container instance;
    private PersistenceStrategy<Member> persistenceStrategy;
    private static List<Member> memberList = new ArrayList<>();

    private Container() {}

    //Thread-safe
    public static synchronized Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public void setStrategy(PersistenceStrategy persistenceStrategy) {
        this.persistenceStrategy = persistenceStrategy;
    }

    public void addMember(Member newMember) throws ContainerException {
        for (Member member : memberList) {
            if (member.getID().equals(newMember.getID())) {
                throw new ContainerException("Das Member-Objekt mit der ID " + newMember.getID() + " ist bereits vorhanden!");
            }
        }
        memberList.add(newMember);
    }

    public String deleteMember(Integer id) {

        if (memberList.isEmpty()) {
            throw new IllegalArgumentException("Die Liste is leer");
        }
        for (Member member : memberList) {
            if (member.getID().equals(id)) {
                memberList.remove(member);
                return "Member-Objekt geloescht!";
            }
        }
        throw new IllegalArgumentException("Das Member-Objekt mit der ID " + id + " ist nicht vorhanden!");
    }

    public List<Member> getCurrentList() {
        return memberList;
    }

    public void dump() {
        for (Member member : memberList) {
            System.out.println(member.toString());
        }
    }

    public int size() {
        return memberList.size();
    }


    public void store() throws PersistenceException {
        if (persistenceStrategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Strategy is not set!");
        }
        persistenceStrategy.openConnection();
        persistenceStrategy.save(memberList);
        persistenceStrategy.closeConnection();
    }

    public void load() throws PersistenceException {
        if (persistenceStrategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Strategy is not set!");
        }
        persistenceStrategy.openConnection();
        memberList = persistenceStrategy.load();
        persistenceStrategy.closeConnection();
    }
}
