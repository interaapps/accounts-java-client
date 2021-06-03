package de.interaapps.accounts.apiclient.responses.user;

import de.interaapps.accounts.apiclient.AccountsClient;
import de.interaapps.accounts.apiclient.requests.user.EditUserRequest;
import de.interaapps.accounts.apiclient.responses.ActionResponse;

public class UserResponse extends ActionResponse {
    private int id;
    private String name;
    private String fullName;
    private String mail;
    private String birthday;
    private String favoriteColor;
    private String description;
    private String profilePicture;

    private transient EditUserRequest editUserRequest;
    private transient AccountsClient accountsClient;

    public String getProfilePicture() {
        return profilePicture;
    }

    public int getId() {
        return id;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDescription() {
        return description;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
        editUserRequest.description = description;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        editUserRequest.fullName = fullName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        editUserRequest.birthday = birthday;
    }

    public void setAccountsClient(AccountsClient accountsClient) {
        this.accountsClient = accountsClient;
    }

    public boolean save(){
        return accountsClient.editProfile(editUserRequest);
    }
}
