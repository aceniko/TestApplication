package com.testapplication.core.models.api;

import com.google.gson.annotations.SerializedName;

public class AuthenticateResultModel {
    @SerializedName("accessToken")
    private String accessToken;
    @SerializedName("encryptedAccessToken")
    private String encryptedAccessToken;
    @SerializedName("expireInSeconds")
    private int expireInSeconds;
    @SerializedName("userId")
    private long userId;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getEncryptedAccessToken() {
        return encryptedAccessToken;
    }

    public void setEncryptedAccessToken(String encryptedAccessToken) {
        this.encryptedAccessToken = encryptedAccessToken;
    }

    public int getExpireInSeconds() {
        return expireInSeconds;
    }

    public void setExpireInSeconds(int expireInSeconds) {
        this.expireInSeconds = expireInSeconds;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
