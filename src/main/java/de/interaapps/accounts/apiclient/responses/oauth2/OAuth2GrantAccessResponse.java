package de.interaapps.accounts.apiclient.responses.oauth2;


import de.interaapps.accounts.apiclient.oauth2.OAuth2Client;
import de.interaapps.accounts.apiclient.responses.ActionResponse;

public class OAuth2GrantAccessResponse extends ActionResponse {
    private String code;

    public String getCode() {
        return code;
    }

    public OAuth2TokenExchangeResponse exchangeToken(OAuth2Client oAuth2Client){
        return oAuth2Client.exchangeToken(code);
    }
}
