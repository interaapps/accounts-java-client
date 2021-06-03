package de.interaapps.accounts.apiclient.responses.auth;

import de.interaapps.accounts.apiclient.AccountsClient;
import de.interaapps.accounts.apiclient.responses.ActionResponse;
public class LoginResponse extends ActionResponse {
    private AuthKeyResponse authKey;
    private boolean authenticationRequired = false;

    public AuthKeyResponse getAuthKey() {
        return authKey;
    }

    public AccountsClient getAccountClient(){
        return new AccountsClient(authKey.getKey());
    }

    public boolean isAuthenticationRequired() {
        return authenticationRequired;
    }
}
