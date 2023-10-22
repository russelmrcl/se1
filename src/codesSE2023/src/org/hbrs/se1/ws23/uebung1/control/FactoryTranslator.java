package org.hbrs.se1.ws23.uebung1.control;

public class FactoryTranslator {
    public static Translator createTranslator() {
        return new GermanTranslator();
    }
}
