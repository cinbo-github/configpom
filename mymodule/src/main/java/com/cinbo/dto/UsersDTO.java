package com.cinbo.dto;

import java.util.Date;

public class UsersDTO {
    private Integer id;

    private String username;

    private String password;

    private Date logindate;
    private String myvalue ;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getLogindate() {
        return logindate;
    }

    public void setLogindate(Date logindate) {
        this.logindate = logindate;
    }
    public String getMyvalue(){
        return myvalue;
    }
    public void setMyvalue(String value){
        this.myvalue = value;
    }
    @Override
    public String toString(){
        return id + username + password + logindate;
    }
}