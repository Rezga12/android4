package com.example.meishvili.revaz.mynewfinalprojectapplication.model.login;

import com.google.gson.annotations.SerializedName;

public class UserDetails {

    /*"UserId": 1,
    "Username": "sample string 2",
    "Name": "sample string 3",
    "LastName": "sample string 4",
    "PhoneForSms": "sample string 5",
    "Active": true*/
    @SerializedName("UserId")
    private Integer userId;

    @SerializedName("UserName")
    private String userName;

    @SerializedName("Name")
    private String name;

    @SerializedName("LastName")
    private String lastName;

    @SerializedName("PhoneForSms")
    private String phoneForSms;

    @SerializedName("Active")
    private boolean active;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneForSms() {
        return phoneForSms;
    }

    public void setPhoneForSms(String phoneForSms) {
        this.phoneForSms = phoneForSms;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



}
