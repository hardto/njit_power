package edu.njit.Message;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SystemMessage<T,V> extends SimpleSystemMessage implements Serializable {

    private List<Map<T,V>> records;

    public List<Map<T, V>> getRecords() {
        return records;
    }

    public void setRecords(List<Map<T, V>> records) {
        this.records = records;
    }
}
