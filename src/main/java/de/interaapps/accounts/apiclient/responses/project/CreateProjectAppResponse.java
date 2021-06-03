package de.interaapps.accounts.apiclient.responses.project;

import de.interaapps.accounts.apiclient.responses.ActionResponse;

public class CreateProjectAppResponse extends ActionResponse {
    private String id;
    private String name;
    private String picture;
    private Type type;

    public enum Type {
        OAUTH2,
        IAAUTH
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPicture() {
        return picture;
    }

    public Type getType() {
        return type;
    }
}
