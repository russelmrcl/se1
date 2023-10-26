package org.hbrs.se1.ws23.uebung2.test;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung2.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container container;
    Member memberOne;
    Member memberTwo;

    @BeforeEach
    void setUp() {
       container = new Container();
       memberOne = new ConcreteMember(1);
       memberTwo = new ConcreteMember(2);
    }

    @Test
    void addMemberTest() {
        assertEquals(0, container.size());
        assertDoesNotThrow(() -> container.addMember(memberOne));
        assertEquals(1, container.size());

        assertThrows(Exception.class, () -> container.addMember(memberOne));
        assertThrows(Exception.class, () -> container.addMember(null)) ;
        assertNotEquals(3, container.size());
        assertEquals(1, container.size());
    }


    @Test
    void deleteMemberTest() {
        assertDoesNotThrow(() -> container.addMember(memberTwo));
        assertEquals("Member-Objekt gelöscht!", container.deleteMember(1));
        assertEquals(1, container.size());
        assertThrows(Exception.class, () -> container.deleteMember(3));
        assertEquals("Member-Objekt gelöscht!", container.deleteMember(2));
        assertThrows(Exception.class, () -> container.deleteMember(2));
    }

    @Test
    void throwsContaineExceptionTest() {
        assertThrows(ContainerException.class, () -> {
            container.addMember(memberOne);
            container.addMember(memberOne);
        });
    }
}