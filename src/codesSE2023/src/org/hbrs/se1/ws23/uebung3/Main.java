package org.hbrs.se1.ws23.uebung3;

import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;
import org.hbrs.se1.ws23.uebung3.view.Client;
import org.hbrs.se1.ws23.uebung3.view.MemberView;

public class Main {
    public static void main(String[] args) throws ContainerException {
        Container container = Container.getInstance();
        container.setStrategy(new PersistenceStrategyStream());

        Client client = new Client();
        client.display(container, new MemberView());
    }
}