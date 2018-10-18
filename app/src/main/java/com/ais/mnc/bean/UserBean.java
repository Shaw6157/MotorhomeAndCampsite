package com.ais.mnc.bean;

/**
 * Copyright (C) 2018 CYu. All rights reserved.
 *
 * @Package: com.ais.mnc.bean
 * @Description: for registered user bean
 * @author: Shaw
 * @date: 14/10
 */
public class UserBean {
    private String uname;
    private String email;
    private String password;

    public UserBean(String pUname, String pEmail, String pPassword) {
        uname = pUname;
        email = pEmail;
        password = pPassword;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String pUname) {
        uname = pUname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String pEmail) {
        email = pEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pPassword) {
        password = pPassword;
    }
}
