package de.interaapps.accounts.apiclient.requests.projects;

import com.google.gson.annotations.SerializedName;

public class EditOAuth2AppRequest {
    public String picture;
    public String name;
    @SerializedName("redirect_url")
    public String redirectUrl;
}
