package org.hbrs.se1.ws23.uebung9.tests;

import org.hbrs.se1.ws23.uebung9.model.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TestClient {

    ComplexDocument rootDocument;
    TextDocument textDoc1;
    TextDocument textDoc2;
    TextDocument textDoc3;
    GraphicDocument graphicDoc1;

    @BeforeEach
    void setUp() {
        rootDocument = new ComplexDocument();
        rootDocument.setID("Root");

        textDoc1 = new TextDocument("Hello World", Encoding.UTF8);
        textDoc1.setID("Text1");

        textDoc2 = new TextDocument("Hello World", Encoding.UTF16);
        textDoc2.setID("Text2");

        textDoc3 = new TextDocument("Hello World", Encoding.UTF32);
        textDoc3.setID("Text3");

        graphicDoc1 = new GraphicDocument("localhost:8080");
        graphicDoc1.setID("Graphic1");

        rootDocument.addDocument(textDoc1);
        rootDocument.addDocument(textDoc2);
        rootDocument.addDocument(textDoc3);
        rootDocument.addDocument(graphicDoc1);
    }

    @Test
    void getBytesTest() {
        assertEquals(1279, rootDocument.getBytes());
    }

    @Test
    void getIDTest() {
        assertEquals("Text1", textDoc1.getID());
        assertEquals("Text2", textDoc2.getID());
        assertEquals("Text3", textDoc3.getID());
        assertEquals("Graphic1", graphicDoc1.getID());
    }

}