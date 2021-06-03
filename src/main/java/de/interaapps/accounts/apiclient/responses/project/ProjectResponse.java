package de.interaapps.accounts.apiclient.responses.project;


import de.interaapps.accounts.apiclient.responses.ActionResponse;
import de.interaapps.accounts.apiclient.responses.oauth2.OAuth2AppResponse;

import java.util.List;

public class ProjectResponse extends ActionResponse {

    private int id;
    private String name;
    private String image;

    public List<OAuth2AppResponse> oauthApps;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<OAuth2AppResponse> getOauthApps() {
        return oauthApps;
    }

    public String getImage() {
        return image;
    }
}
