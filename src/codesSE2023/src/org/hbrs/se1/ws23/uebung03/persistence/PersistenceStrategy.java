package org.hbrs.se1.ws23.uebung03.persistence;

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
 * @param <Member>
 */
public interface PersistenceStrategy<Member> {
    public void openConnection() throws PersistenceException;
    public void closeConnection() throws PersistenceException;
    public void save(List<Member> member) throws PersistenceException;
    public List<Member> load() throws PersistenceException;
}
