package de.interaapps.accounts.apiclient.responses;

import org.javawebstack.abstractdata.AbstractElement;

public class AuthenticationMethodResponse extends ActionResponse {
    public int id;
    public Type type;
    public AbstractElement data;

    public enum Type {
        TOTP, QUESTIONS, EMAIL
    }
}
