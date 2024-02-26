package org.hbrs.se1.ws23.uebung03;

import org.hbrs.se1.ws23.uebung03.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung03.persistence.PersistenceStrategyStream;

public class Main {
    public static void main(String[] args) throws PersistenceException {
        Container container = Container.getInstance();
        container.setStrategy(new PersistenceStrategyStream());
        container.load();
    }
}
