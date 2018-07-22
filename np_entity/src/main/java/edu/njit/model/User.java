package edu.njit.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String realName;

    private String idNumber;

    private String account;

    private String password;

    private String stuClass;

    private String dormitory;

    private String grade;

    private String phone;

    private String email;

    private String addr;

    private String politics;

    private Date birth;

    private String nation;

    private String sex;

    private String middleSchool;

    private String nativePlace;

    private String tel;

    private String col1;

    private String col3;

    private String col2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
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

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass == null ? null : stuClass.trim();
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory == null ? null : dormitory.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics == null ? null : politics.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMiddleSchool() {
        return middleSchool;
    }

    public void setMiddleSchool(String middleSchool) {
        this.middleSchool = middleSchool == null ? null : middleSchool.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
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
        return "User{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", dormitory='" + dormitory + '\'' +
                ", grade='" + grade + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", addr='" + addr + '\'' +
                ", politics='" + politics + '\'' +
                ", birth=" + birth +
                ", nation='" + nation + '\'' +
                ", sex='" + sex + '\'' +
                ", middleSchool='" + middleSchool + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", tel='" + tel + '\'' +
                ", col1='" + col1 + '\'' +
                ", col3='" + col3 + '\'' +
                ", col2='" + col2 + '\'' +
                '}';
    }
}