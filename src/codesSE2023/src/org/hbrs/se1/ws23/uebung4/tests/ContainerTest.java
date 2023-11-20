package org.hbrs.se1.ws23.uebung4.tests;

import org.hbrs.se1.ws23.uebung4.model.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung4.model.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws23.uebung4.model.Container;
import org.hbrs.se1.ws23.uebung4.model.UserStories;
import org.hbrs.se1.ws23.uebung4.model.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container container;
    PersistenceStrategyStream persistenceStrategyStream;

    @BeforeEach
    void setUp() {
        container = Container.getInstance();
        persistenceStrategyStream = new PersistenceStrategyStream();
        persistenceStrategyStream.setLocation("./src/codesSE2023/src/org/hbrs/se1/ws23/uebung4/docs/tests.ser");
    }

    @Test
    void strategyNotSetTest() {
        container.setStrategy(null);
        assertDoesNotThrow(() -> container.addUserStories(new UserStories(1, "lorem", "ipsum",
                1, 2, 3, 4, "projekt")));
        assertEquals(1, container.size());
        assertThrows(PersistenceException.class, () -> container.load());
    }

    @Test
    void strategyMongeDBTest() {
        PersistenceStrategyMongoDB mongoDBStrategy = new PersistenceStrategyMongoDB();
        container.setStrategy(mongoDBStrategy);

        assertDoesNotThrow(() -> container.addUserStories(new UserStories(100, "lorem", "ipsum",
                1, 2, 3, 4, "projekt")));
        assertDoesNotThrow(() -> container.addUserStories(new UserStories(200, "lorem", "ipsum",
                1, 2, 3, 4, "projekt")));
        assertThrows(UnsupportedOperationException.class, () -> container.store());

        assertEquals("UserStories-Objekt geloescht!", container.deleteUserStories(100));
        assertEquals("UserStories-Objekt geloescht!", container.deleteUserStories(200));
    }

    @Test
    void invalidLocationTest() {
        persistenceStrategyStream.setLocation("LoremIpsum/");
        assertThrows(PersistenceException.class, () -> container.load());
    }

    @Test
    void storeAndLoadTest() {
        container.setStrategy(persistenceStrategyStream);

        //Objekt hinzufügen, Liste persistent abspeichern
        assertDoesNotThrow(() -> container.addUserStories(new UserStories(2, "lorem", "ipsum",
                1, 2, 3, 4, "projekt")));
        assertDoesNotThrow(() -> container.addUserStories(new UserStories(3, "lorem", "ipsum",
                1, 2, 3, 4, "projekt")));
        assertDoesNotThrow(() -> container.store());
        assertDoesNotThrow(() -> container.load());
        assertEquals(3, container.size());

        //Objekt aus Container löschen und Liste wieder einladen.
        assertEquals("UserStories-Objekt geloescht!", container.deleteUserStories(3));
        assertDoesNotThrow(() -> container.store());
        assertDoesNotThrow(() -> container.load());
        assertEquals(2, container.size());

        assertDoesNotThrow(() -> container.load());
        assertEquals(2, container.size());
    }
}