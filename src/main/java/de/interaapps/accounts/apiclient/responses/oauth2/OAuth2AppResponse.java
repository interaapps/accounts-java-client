package de.interaapps.accounts.apiclient.responses.oauth2;

import de.interaapps.accounts.apiclient.AccountsClient;
import de.interaapps.accounts.apiclient.responses.ActionResponse;

public class OAuth2AppResponse extends ActionResponse {
    private String id;
    private String picture;
    private String name;
    private String defaultRedirectUrl;

    private String secret;
    private int codeCount;

    private transient AccountsClient accountsClient;

    public void setAccountsClient(AccountsClient accountsClient) {
        this.accountsClient = accountsClient;
    }

    public OAuth2GrantAccessResponse grant(String[] scopes){
        return accountsClient.grantOAuth2App(id, scopes);
    }

    public String getPicture() {
        return picture;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AccountsClient getAccountsClient() {
        return accountsClient;
    }

    public int getCodeCount() {
        return codeCount;
    }

    public String getDefaultRedirectUrl() {
        return defaultRedirectUrl;
    }

    public String getSecret() {
        return secret;
    }
}
