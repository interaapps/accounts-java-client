package de.interaapps.accounts.apiclient.responses.iaauth;

import de.interaapps.accounts.apiclient.responses.ActionResponse;

public class IAAuthServicePermissionGrantResponse extends ActionResponse {
    public String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public String getUserKey(){
        return redirectUrl.split("userkey=")[1];
    }
}
