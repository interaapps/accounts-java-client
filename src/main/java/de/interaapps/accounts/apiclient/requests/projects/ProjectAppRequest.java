package de.interaapps.accounts.apiclient.requests.projects;

public class ProjectAppRequest {

    public String name;

    public Type type;

    public String url;

    public enum Type {
        OAUTH2
    }
}
