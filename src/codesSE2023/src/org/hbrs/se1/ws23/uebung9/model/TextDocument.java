package org.hbrs.se1.ws23.uebung9.model;

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
            switch (getEncoding()) {
                case UTF8 -> {
                    return getContent().getBytes("UTF-8").length;
                }
                case UTF16 -> {
                    return getContent().getBytes("UTF-16").length;
                }
                case UTF32 -> {
                    return getContent().getBytes("UTF-32").length;
                }
            }
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        return null;
    }
}
