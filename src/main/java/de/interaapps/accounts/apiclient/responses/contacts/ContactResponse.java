package de.interaapps.accounts.apiclient.responses.contacts;

import de.interaapps.accounts.apiclient.AccountsClient;
import de.interaapps.accounts.apiclient.responses.ActionResponse;

public class ContactResponse extends ActionResponse {
    private int id;
    private String name;
    private String profilePicture;
    protected transient AccountsClient accountsClient;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setAccountsClient(AccountsClient accountsClient) {
        this.accountsClient = accountsClient;
    }

    public boolean remove(){
        return accountsClient.deleteContact(id);
    }
}
