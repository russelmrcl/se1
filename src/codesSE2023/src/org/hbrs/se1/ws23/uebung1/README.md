## Übung01

### Author: Russel Marcelo / rmarce2s

---

### Die Antworten zur Aufgabe 1

- *Wie kann eine zusätzliche Klasse zur Objekt-Erzeugung verwendet <br />
werden, um die Kommunikationsverbindung
herzustellen?*
  <br />
  <br />
Man kann eine Factory-Klasse verwenden, die Factory-Klasse übernimmt <br /> die Erzeugung und Bereitstellung von 
`GermanTranslator` - Objekten (Factory Method)
```java
public class FactoryTranslator {
    public static Translator createTranslator() {
        return new GermanTranslator();
    }
}
```
---
- *In welchem Package sollte diese Klasse platziert werden?*
  <br />
  <br />
Im gleichen Paket wie der `GermanTranslator`, um den Import zu sparen.
---
- *Welches Entwurfsmuster (engl.: design pattern) könnte <br /> für die Problematik der 
Objekt-Erzeugung verwendet werden?*
  <br />
  <br />
**Factory Method**
---
- *Was ist der software-technische Nutzen bei der Verwendung des Entwurfsmusters?*
  <br />
  <br />
Entwurfsmusters (Design Patterns) sind bewährte Lösungsstrategien für wiederkehrende Softwareprobleme
--- 
- *Wie muss man den Source Code des Interface ggf. anpassen, um mögliche auftretende Kompilierfehler
zu beseitigen?*
  <br />
  <br />
Um Kompilierfehler zu vermeiden, sollte das `Translator` - Interface als public deklariert werden, da der `Client` das 
Interface initialisiert und der `Translator` in einem anderen Paket liegt, welches als `default (package-private)` 
markiert ist.
---
- *Was ist der Vorteil einer separaten Test-Klasse?*
  <br />
  <br />
Test-Klassen erleichtern die Strukturierung von Testcode und Anwendungscode, indem sie sie in 
getrennten Klassen organisieren. Dadurch wird die Übersichtlichkeit der Tests verbessert.
---
- *Was ist bei einem Blackbox-Test der Sinn von Äquivalenzklassen?*
  <br />
  <br />
Äquivalenzklassen im Blackbox-Test helfen, Eingabedaten zu gruppieren, um repräsentative Testfälle auszuwählen und
die Testabdeckung zu verbessern.
---
- *Warum ist ein Blackbox-Test mit JUnit auf der Klasse Client nicht unmittelbar durchführbar?*
  <br />
  <br />
JUnit bietet keine Möglichkeit Systemausgaben zu testen (`System.out.println(...)`). Da die einzige Methode `display` im Client einen `void`
Rückgabetyp hat, ist es nicht möglich den Inhalt zu testen.
---
### UML-Diagramm

[se1_ub01_uml.pdf](docs/se1_ub01_uml.pdf)
