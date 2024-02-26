package org.hbrs.se1.ws23.uebung04.controller;

import org.hbrs.se1.ws23.uebung04.model.persistence.PersistenceStrategyStream;
import org.hbrs.se1.ws23.uebung04.model.Container;

public class Main {
    public static void main(String[] args) {

        Container container = Container.getInstance();
        container.setStrategy(new PersistenceStrategyStream());

        Client client = new Client(container);
        client.consoleUI();
    }
}
