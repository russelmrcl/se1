package org.hbrs.se1.ws23.uebung4.Model.persistence;

import java.util.List;

/**
 * Interface for defining basic methods for a persistence mechanism
 * Each concrete algorithm (i.e. strategy) must implement this method
 * This interface corresponds to the abstract strategy w.r.t. to the
 * Strategy Design Pattern (GoF).
 *
 * The following protocol applies:
 * 1. openConnection
 * 2. { load | save }  (many times)
 * 3. closeConnection
 *
 * @param <UserStories>
 */
public interface PersistenceStrategy<UserStories> {
    public void openConnection() throws PersistenceException;
    public void closeConnection() throws PersistenceException;
    public void save(List<UserStories> userStoriesList) throws PersistenceException;
    public List<UserStories> load() throws PersistenceException;
}
