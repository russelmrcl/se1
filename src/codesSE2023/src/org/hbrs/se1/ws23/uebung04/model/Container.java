package org.hbrs.se1.ws23.uebung04.model;

import org.hbrs.se1.ws23.uebung04.model.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung04.model.persistence.PersistenceStrategy;

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

    public void addUserStories(UserStories newUserStories) throws ContainerException {
        for (UserStories userStories : userStoriesList) {
            if (userStories.getID().equals(newUserStories.getID())) {
                throw new ContainerException("Das UserStories-Objekt mit der ID " + newUserStories.getID() + " ist bereits vorhanden!");
            }
        }
        userStoriesList.add(newUserStories);
    }

    public String deleteUserStories(Integer id) {

        if (userStoriesList.isEmpty()) {
            throw new IllegalArgumentException("Die Liste is leer");
        }
        for (UserStories userStories : userStoriesList) {
            if (userStories.getID().equals(id)) {
                userStoriesList.remove(userStories);
                return "UserStories-Objekt geloescht!";
            }
        }
        throw new IllegalArgumentException("Das UserStories-Objekt mit der ID " + id + " ist nicht vorhanden!");
    }

    public List<UserStories> getCurrentList() {
        return userStoriesList;
    }

    public int size() {
        return userStoriesList.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
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
