package org.hbrs.se1.ws23.uebung09.model;

public class GraphicDocument extends CoreDocument {

    private String url;

    @Override
    public Integer getBytes() {
        return 1200;
    }

    public GraphicDocument(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
