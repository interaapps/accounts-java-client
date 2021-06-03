package de.interaapps.accounts.apiclient.requests.auth;

public class LoginRequest {
    public String name;
    public String password;

    public LoginRequest(String name, String password){
        this.name = name;
        this.password = password;
    }
}
