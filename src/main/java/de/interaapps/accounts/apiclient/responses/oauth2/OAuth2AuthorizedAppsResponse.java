package de.interaapps.accounts.apiclient.responses.oauth2;

import de.interaapps.accounts.apiclient.responses.ActionResponse;

import java.util.ArrayList;
import java.util.List;

public class OAuth2AuthorizedAppsResponse extends ActionResponse {
    public OAuth2AppResponse app;
    public List<String> permissions = new ArrayList<>();
}
