package org.hbrs.se1.ws23.uebung09.model;

import java.io.UnsupportedEncodingException;

public class TextDocument extends CoreDocument {

    private String content;
    private Encoding encoding;

    public TextDocument(String content, Encoding encoding) {
        this.content = content;
        this.encoding = encoding;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Encoding getEncoding() {
        return encoding;
    }

    public void setEncoding(Encoding encoding) {
        this.encoding = encoding;
    }

    @Override
    public Integer getBytes() {
        try {
            return getContent().getBytes(encoding.getEncoding()).length;
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        return null;
    }
}
