package com.square.Inventory.Management.System.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LogInDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String userEmail;

    private Date logInAt;

    private Date logOutAt;

    private String logInStatus;

    private String deviceIP;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getLogInAt() {
        return logInAt;
    }

    public void setLogInTime(Date logInTime) {
        this.logInAt = logInAt;
    }

    public Date getLogOutAt() {
        return logOutAt;
    }

    public void setLogOutAt(Date logOutAt) {
        this.logOutAt = logOutAt;
    }

    public String getLogInStatus() {
        return logInStatus;
    }

    public void setLogInStatus(String logInStatus) {
        this.logInStatus = logInStatus;
    }

    public String getDeviceIP() {
        return deviceIP;
    }

    public void setDeviceIP(String deviceIP) {
        this.deviceIP = deviceIP;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
