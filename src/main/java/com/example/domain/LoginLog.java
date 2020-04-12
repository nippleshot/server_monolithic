package com.example.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class LoginLog implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int loginLogId;

    @Column
    private int userId;

    @Column
    private String ip;

    @Column
    private Date loginDate;

    @Column
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
