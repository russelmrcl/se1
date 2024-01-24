## Uebung 8

### Author: Russel Marcelo / rmarce2s

---

### Die Antworten zur Übung 8

#### a) UML

- [se1_ub08_uml.pdf](docs/se1_ub08_uml.pdf)

#### b) Beispiel Code

```java
public class ReiseAnbieterAdapter implements DataFormat {
		
    private ReiseAnbieter adaptee = new ReiseAnbieter();

    private SuchErgebnis sucheAusfuehren(SuchAuftrag s) {
        //mapping through a list
        return new SuchErgebnis();
    }
		
    private QueryObject input(SuchAuftrag s) {
        //convert SuchAuftrag to a QueryObject
        return new QueryObject();
    }

    private SuchErgebnis output(QueryResult q) {
        //convert QueryResult to a SuchErgebnis
        return new SuchErgebnis();
    }
}
```

#### UML Sequenz Diagramm

- [se1_ub08_sd.pdf](docs/se1_ub08_sd.pdf)

#### UML Diagramm 2

- [se1_ub08_uml.pdf](docs/se1_ub08_uml2.pdf)

#### UML Package Diagramm

- [se1_ub08_pd.pdf](docs/se1_ub08_pd.pdf)