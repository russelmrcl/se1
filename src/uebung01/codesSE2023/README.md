## Übung01

---

#### Author: Russel Marcelo / rmarce2s

### 1.

- Wie kann diese Kommunikationsverbindung nun dennoch mit Hilfe einer zusätzlichen Klasse, welche die dazu notwendige Objekt-Erzeugung übernimmt, aufgebaut werden?
  - Man kann eine Factory-Klasse verwenden, die Factory-Klasse übernimmt die Erzeugung und Bereitstellung von GermanTranslator-Objekten


- In welchem Package sollte diese zusätzliche Klasse liegen?
  - Im selben Paket, in dem sich der GermanTranslator befindet, da wir den Import des GermanTranslator einsparen können.


- Welches Entwurfsmuster (engl.: design pattern) könnte für die Problematik der Objekt-Erzeugung verwendet werden?
  - Factory method


- Was ist der software-technische Nutzen bei der Verwendung des Entwurfsmusters?
  - Design Patterns sind bewährte Lösungsansätze für häufig auftretende Probleme in der Softwareentwicklung, die wiederholt auftauchen. Sie bieten standardisierte Lösungen, 
  um den Code effizienter und flexibler zu gestalten.


- Wie muss man den Source Code des Interface ggf. anpassen, um mögliche auftretende Kompilierfehler zu beseitigen?
  - Um mögliche Kompilierfehler zu beheben und das Interface Translator in anderen Paketen verwenden zu können, muss die Sichtbarkeit des Interfaces auf "public" sein. Dies ermöglicht es, das Interface 
  überall im Code verwenden zu können.
---

### 2.

- Was ist der Vorteil einer separaten Test-Klasse?
  - Test-Klassen erleichtern die Strukturierung von Testcode und Anwendungscode, 
  indem sie sie in getrennten Klassen organisieren. Dadurch wird die Übersichtlichkeit der Tests verbessert.
  

- Was ist bei einem Blackbox-Test der Sinn von Äquivalenzklassen?
  - Äquivalenzklassen im Blackbox-Test helfen, Eingabedaten zu gruppieren, um repräsentative Testfälle auszuwählen und 
  die Testabdeckung zu verbessern.


- Warum ist ein Blackbox-Test mit JUnit auf der Klasse Client nicht unmittelbar durchführbar?
  - Ein Blackbox-Test auf der Klasse Client ist schwierig, da wir nicht den genauen Code des Übersetzers kennen und daher keine direkte 
  Kontrolle darüber haben. 
