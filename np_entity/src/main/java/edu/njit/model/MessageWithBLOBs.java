package edu.njit.model;

import java.io.Serializable;

public class MessageWithBLOBs extends Message implements Serializable {
    private String content;

    private String col3;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCol3() {
        return col3;
    }

    public void setCol3(String col3) {
        this.col3 = col3 == null ? null : col3.trim();
    }

    @Override
    public String toString() {
        return "MessageWithBLOBs{" +
                "content='" + content + '\'' +
                ", col3='" + col3 + '\'' +
                '}';
    }
}