package org.hbrs.se1.ws23.uebung4;

import org.hbrs.se1.ws23.uebung4.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung4.persistence.PersistenceStrategy;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private static Container instance;
    private PersistenceStrategy<UserStories> persistenceStrategy;
    private static List<UserStories> userStoriesList = new ArrayList<>();

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

    public void addMember(UserStories newMember) throws ContainerException {
        for (UserStories member : userStoriesList) {
            if (member.getID().equals(newMember.getID())) {
                throw new ContainerException("Das UserStories-Objekt mit der ID " + newMember.getID() + " ist bereits vorhanden!");
            }
        }
        userStoriesList.add(newMember);
    }

    public String deleteMember(Integer id) {

        if (userStoriesList.isEmpty()) {
            throw new IllegalArgumentException("Die Liste is leer");
        }
        for (UserStories member : userStoriesList) {
            if (member.getID().equals(id)) {
                userStoriesList.remove(member);
                return "UserStories-Objekt geloescht!";
            }
        }
        throw new IllegalArgumentException("Das UserStories-Objekt mit der ID " + id + " ist nicht vorhanden!");
    }

    public List<UserStories> getCurrentList() {
        return userStoriesList;
    }

    public void dump() {
        for (UserStories member : userStoriesList) {
            System.out.println(member.toString());
        }
    }

    public int size() {
        return userStoriesList.size();
    }


    public void store() throws PersistenceException {
        if (persistenceStrategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Strategy is not set!");
        }
        persistenceStrategy.openConnection();
        persistenceStrategy.save(userStoriesList);
        persistenceStrategy.closeConnection();
    }

    public void load() throws PersistenceException {
        if (persistenceStrategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Strategy is not set!");
        }
        persistenceStrategy.openConnection();
        userStoriesList = persistenceStrategy.load();
        persistenceStrategy.closeConnection();
    }
}
