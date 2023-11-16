package org.hbrs.se1.ws23.uebung4.view;

import org.hbrs.se1.ws23.uebung4.persistence.PersistenceStrategyStream;
import org.hbrs.se1.ws23.uebung4.Container;

public class Main {
    public static void main(String[] args) {
        Container container = Container.getInstance();
        container.setStrategy(new PersistenceStrategyStream());

        Client client = new Client();
        client.consoleUI(container);
    }
}
