package de.interaapps.accounts.apiclient.requests.oauth2;

import com.google.gson.annotations.SerializedName;

public class OAuth2SetEASRequest {
    @SerializedName("client_id")
    public String clientId;
    @SerializedName("client_secret")
    public String clientSecret;
    @SerializedName("url")
    public String url;
}
