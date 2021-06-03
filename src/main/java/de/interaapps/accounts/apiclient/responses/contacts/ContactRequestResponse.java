package de.interaapps.accounts.apiclient.responses.contacts;

import de.interaapps.accounts.apiclient.AccountsClient;
import de.interaapps.accounts.apiclient.responses.ActionResponse;

public class ContactRequestResponse extends ContactResponse {
    public boolean accept(){
        return accountsClient.acceptContact(getId());
    }
}
