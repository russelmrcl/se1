package org.hbrs.se1.ws23.uebung9.model;

public abstract class CoreDocument implements Document {

    private String id;

    @Override
    public void setID(String id) {
        this.id = id;
    }

    @Override
    public String getID() {
        return id;
    }
}
