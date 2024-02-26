package org.hbrs.se1.ws23.uebung01.tests;

import org.hbrs.se1.ws23.uebung01.control.GermanTranslator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    GermanTranslator translator;

    @BeforeEach
    void setUp() {
         translator = new GermanTranslator();
    }

    @Test
    void zahlGueltigPositiveTest() {
        //Aequivalenzklasse 1
        //positiv Testfall (gueltige zahlen)

        //Grenzwert
        assertEquals("zehn", translator.translateNumber(10));
        assertEquals("eins", translator.translateNumber(1));
        //0 > zahl <= 10
        assertEquals("sieben", translator.translateNumber(7));
    }

    @Test
    void zahlGroesserNegativeTest() {
        //Aequivalenzklasse 2
        //negativ Testfall (ungueltige zahlen)

        //10 > zahl
        assertEquals("Übersetzung der Zahl 11 nicht möglich 1.0", translator.translateNumber(11));
    }

    @Test
    void zahlKleinerNegativeTest() {
        //Aequivalenzklasse 3
        //negativ Testfall (ungueltige zahlen)

        //zahl < 0
        assertEquals("Übersetzung der Zahl -1 nicht möglich 1.0", translator.translateNumber(-1));
    }







}