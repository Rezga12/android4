package com.example.meishvili.revaz.mynewfinalprojectapplication.model.login;

import com.google.gson.annotations.SerializedName;

public class SessionDetails {
    /*"IsChannelActive": true,
    "SessionTimeout": 2*/
    @SerializedName("IsChannelActive")
    private boolean isChannelActive;

    @SerializedName("SessionTimeout")
    private Integer sessionTimeout;

    public boolean isChannelActive() {
        return isChannelActive;
    }

    public void setChannelActive(boolean channelActive) {
        isChannelActive = channelActive;
    }

    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }
}
