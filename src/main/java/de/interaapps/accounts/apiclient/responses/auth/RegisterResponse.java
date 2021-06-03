package de.interaapps.accounts.apiclient.responses.auth;

import de.interaapps.accounts.apiclient.AccountsClient;
import de.interaapps.accounts.apiclient.responses.ActionResponse;

public class RegisterResponse extends ActionResponse {
    private AuthKeyResponse authKey;

    public AuthKeyResponse getAuthKey() {
        return authKey;
    }

    public AccountsClient getAccountClient(){
        return new AccountsClient(authKey.getKey());
    }
}
