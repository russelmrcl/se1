package org.hbrs.se1.ws23.uebung01.control;

import java.util.HashMap;
import java.util.Map;

public class GermanTranslator implements Translator {

	public String date = "Okt/2023"; // Default-Wert
	private static Map<Integer, String> numberToString = new HashMap();

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		// [ihr Source Code aus Übung 1-2]

		numberToString.put(1, "eins");
		numberToString.put(2, "zwei");
		numberToString.put(3, "drei");
		numberToString.put(4, "vier");
		numberToString.put(5, "fünf");
		numberToString.put(6, "sechs");
		numberToString.put(7, "sieben");
		numberToString.put(8, "acht");
		numberToString.put(9, "neun");
		numberToString.put(10, "zehn");

		return numberToString.getOrDefault(number, "Übersetzung der Zahl " + number + " nicht möglich " + this.version);
	}

	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2022"))
	 * Das Datum sollte system-intern durch eine Control-Klasse gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}
}
