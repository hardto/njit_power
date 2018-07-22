package edu.njit.Message;

import java.io.Serializable;
import java.util.List;

public class SystemMessage<T> extends SimpleSystemMessage implements Serializable {

    private List<T> records;

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
