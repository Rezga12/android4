package com.example.meishvili.revaz.mynewfinalprojectapplication.model.login;

import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("SessionId")
    private String sessionId;

    @SerializedName("SessionDetails")
    private SessionDetails sessionDetails;

    @SerializedName("UserDetails")
    private UserDetails userDetails;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public SessionDetails getSessionDetails() {
        return sessionDetails;
    }

    public void setSessionDetails(SessionDetails sessionDetails) {
        this.sessionDetails = sessionDetails;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
