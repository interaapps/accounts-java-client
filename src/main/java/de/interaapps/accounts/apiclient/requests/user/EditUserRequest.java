package de.interaapps.accounts.apiclient.requests.user;

import com.google.gson.annotations.SerializedName;

public class EditUserRequest {
    @SerializedName("favorite_color")
    public String favoriteColor;

    @SerializedName("full_name")
    public String fullName;

    public String description;

    public String birthday;
}
