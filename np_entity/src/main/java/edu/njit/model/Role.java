package edu.njit.model;

import java.io.Serializable;

public class Role implements Serializable {
    private Integer id;

    private String role;

    private String col1;

    private String col2;

    private String col3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
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

    public String getCol3() {
        return col3;
    }

    public void setCol3(String col3) {
        this.col3 = col3 == null ? null : col3.trim();
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", col1='" + col1 + '\'' +
                ", col2='" + col2 + '\'' +
                ", col3='" + col3 + '\'' +
                '}';
    }
}