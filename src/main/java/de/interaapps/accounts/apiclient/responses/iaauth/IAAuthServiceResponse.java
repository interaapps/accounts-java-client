package de.interaapps.accounts.apiclient.responses.iaauth;

import de.interaapps.accounts.apiclient.AccountsClient;
import de.interaapps.accounts.apiclient.responses.ActionResponse;

public class IAAuthServiceResponse extends ActionResponse {
    public int id;
    public String name;
    public String image;
    private String redirectUrl;


    private transient AccountsClient accountsClient;

    public void setAccountsClient(AccountsClient accountsClient) {
        this.accountsClient = accountsClient;
    }
}
