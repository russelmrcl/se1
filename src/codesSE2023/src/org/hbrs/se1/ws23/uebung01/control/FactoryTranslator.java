package org.hbrs.se1.ws23.uebung01.control;

public class FactoryTranslator {
    public static Translator createTranslator() {
        return new GermanTranslator();
    }
}
