package de.interaapps.accounts.apiclient.responses.auth;

import de.interaapps.accounts.apiclient.responses.ActionResponse;

import java.util.HashMap;
import java.util.Map;

public class AuthKeyResponse extends ActionResponse {

    private int id;
    private int userId;
    private String key;

    private UserAgent userAgent;

    public static class UserAgent {
        private String browser;
        private String operatingSystem;

        public String getBrowser() {
            return browser;
        }

        public String getOperatingSystem() {
            return operatingSystem;
        }
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getKey() {
        return key;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }
}
