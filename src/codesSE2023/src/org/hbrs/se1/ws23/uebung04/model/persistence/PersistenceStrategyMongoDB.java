package org.hbrs.se1.ws23.uebung04.model.persistence;

import java.util.List;

public class PersistenceStrategyMongoDB<UserStories> implements PersistenceStrategy<UserStories> {

    @Override
    public void openConnection() throws PersistenceException {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void closeConnection() throws PersistenceException {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void save(List<UserStories> member) {
        throw new UnsupportedOperationException("Not implemented!");

    }

    @Override
    public List<UserStories> load() {
        throw new UnsupportedOperationException("Not implemented!");
    }
}
