package de.interaapps.accounts.apiclient.requests.auth;

import com.google.gson.annotations.SerializedName;
import de.interaapps.accounts.apiclient.responses.auth.RegisterResponse;

public class RegisterRequest {
    public String name;

    public String mail;

    public String password;

    @SerializedName("privacy_policies_accepted")
    public boolean privacyPoliciesAccepted;


    @SerializedName("profile_picture")
    public String profilePicture;

    public RegisterRequest(String name, String mail, String password, boolean privacyPoliciesAccepted){
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.privacyPoliciesAccepted = privacyPoliciesAccepted;
    }
}
