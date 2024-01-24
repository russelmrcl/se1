package org.hbrs.se1.ws23.uebung9.model;

import java.util.ArrayList;
import java.util.List;

public class ComplexDocument implements Document {

    private String id;
    private static  List<Document> documents = new ArrayList<>();

    public void addDocument(Document document) {
        documents.add(document);
    }

    public void removeDocument(Document document) {
        documents.remove(document);
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public void setID(String id) {
        this.id = id;
    }

    @Override
    public Integer getBytes() {
        Integer totalBytes = 0;
        for (Document document : documents) {
            totalBytes += document.getBytes();
        }
        return totalBytes;
    }
}
