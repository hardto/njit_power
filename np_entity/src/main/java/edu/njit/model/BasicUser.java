package edu.njit.model;

import java.io.Serializable;
import java.util.Date;

public class BasicUser implements Serializable {
    private Integer id;

    private String account;

    private String password;

    private Integer userId;

    private String flag;

    private Date createTime;

    private String col1;

    private String col3;

    private String col2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1 == null ? null : col1.trim();
    }

    public String getCol3() {
        return col3;
    }

    public void setCol3(String col3) {
        this.col3 = col3 == null ? null : col3.trim();
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2 == null ? null : col2.trim();
    }

    @Override
    public String toString() {
        return "BasicUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                ", flag='" + flag + '\'' +
                ", createTime=" + createTime +
                ", col1='" + col1 + '\'' +
                ", col3='" + col3 + '\'' +
                ", col2='" + col2 + '\'' +
                '}';
    }
}