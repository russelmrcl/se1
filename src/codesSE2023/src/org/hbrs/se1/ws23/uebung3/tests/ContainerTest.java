package org.hbrs.se1.ws23.uebung3.tests;

import org.hbrs.se1.ws23.uebung3.ConcreteMember;
import org.hbrs.se1.ws23.uebung3.Container;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container container;
    PersistenceStrategyStream persistenceStrategyStream;

    @BeforeEach
    void setUp() {
        container = Container.getInstance();
        persistenceStrategyStream = new PersistenceStrategyStream();
        persistenceStrategyStream.setLocation("./src/codesSE2023/src/org/hbrs/se1/ws23/uebung3/docs/tests.ser");
    }


    @Test
    void strategyNotSetTest() {
        container.setStrategy(null);
        assertDoesNotThrow(() -> container.addMember(new ConcreteMember(1)));
        assertEquals(1, container.size());
        assertThrows(PersistenceException.class, () -> container.load());
    }

    @Test
    void strategyMongeDBTest() {
        PersistenceStrategyMongoDB mongoDBStrategy = new PersistenceStrategyMongoDB();
        container.setStrategy(mongoDBStrategy);

        assertDoesNotThrow(() -> container.addMember(new ConcreteMember(100)));
        assertDoesNotThrow(() -> container.addMember(new ConcreteMember(200)));
        assertThrows(UnsupportedOperationException.class, () -> container.store());

        assertEquals("Member-Objekt geloescht!", container.deleteMember(100));
        assertEquals("Member-Objekt geloescht!", container.deleteMember(200));
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
        assertDoesNotThrow(() -> container.addMember(new ConcreteMember(2)));
        assertDoesNotThrow(() -> container.addMember(new ConcreteMember(3)));
        assertDoesNotThrow(() -> container.store());
        assertDoesNotThrow(() -> container.load());
        assertEquals(3, container.size());

        //Objekt aus Container löschen und Liste wieder einladen.
        assertEquals("Member-Objekt geloescht!", container.deleteMember(3));
        assertDoesNotThrow(() -> container.store());
        assertDoesNotThrow(() -> container.load());
        assertEquals(2, container.size());

        assertDoesNotThrow(() -> container.load());
        assertEquals(2, container.size());
    }
}