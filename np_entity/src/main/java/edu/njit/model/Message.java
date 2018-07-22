package edu.njit.model;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private Integer id;

    private Integer toUserId;

    private Integer fromUserId;

    private String title;

    private Date createTime;

    private String flag;

    private String col1;

    private String col2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1 == null ? null : col1.trim();
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2 == null ? null : col2.trim();
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", toUserId=" + toUserId +
                ", fromUserId=" + fromUserId +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", flag='" + flag + '\'' +
                ", col1='" + col1 + '\'' +
                ", col2='" + col2 + '\'' +
                '}';
    }
}