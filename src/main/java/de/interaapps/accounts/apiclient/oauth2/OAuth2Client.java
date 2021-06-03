package de.interaapps.accounts.apiclient.oauth2;

import de.interaapps.accounts.apiclient.AccountsClient;
import de.interaapps.accounts.apiclient.requests.oauth2.OAuth2AccessTokenRequest;
import de.interaapps.accounts.apiclient.responses.oauth2.OAuth2TokenExchangeResponse;
import org.javawebstack.httpclient.HTTPClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OAuth2Client extends HTTPClient {
    private final String clientId;
    private final String secret;
    private List<String> scopes = new ArrayList<>();

    public OAuth2Client(String clientId, String secret){
        this.clientId = clientId;
        this.secret = secret;
        setBaseUrl(AccountsClient.ACCOUNTS_URL);
    }

    public AuthorizationURLBuilder createAuthorizationURL(){
        return new AuthorizationURLBuilder(clientId, secret).addScopes(scopes.toArray(new String[0]));
    }

    public boolean checkScopes(List<String> scopes){
        for (String scope : this.scopes) {
            if (!scopes.contains(scope))
                return false;
        }
        return true;
    }

    public OAuth2Client addScopes(String ...scope){
        scopes.addAll(Arrays.asList(scope));
        return this;
    }

    public boolean checkScopes(AuthorizationURLBuilder urlBuilder, List<String> scopes){
        for (String scope : urlBuilder.getScopes()) {
            if (!scopes.contains(scope))
                return false;
        }
        return true;
    }

    public OAuth2TokenExchangeResponse exchangeToken(String code){
        OAuth2AccessTokenRequest request = new OAuth2AccessTokenRequest();
        request.clientId = clientId;
        request.clientSecret = secret;
        request.code = code;
        return post("/api/v2/authorization/oauth2/access_token").jsonBody(request).object(OAuth2TokenExchangeResponse.class);
    }

    public List<String> getScopes() {
        return scopes;
    }

    public static class AuthorizationURLBuilder {
        private String redirectUrl;
        private String state;
        private List<String> scopes = new ArrayList<>();

        private final String clientId;
        private final String secret;

        public AuthorizationURLBuilder(String clientId, String secret){
            this.clientId = clientId;
            this.secret = secret;
        }

        public AuthorizationURLBuilder addScopes(String ...scope){
            scopes.addAll(Arrays.asList(scope));
            return this;
        }

        public AuthorizationURLBuilder setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }
        public AuthorizationURLBuilder setState(String state) {
            this.state = state;
            return this;
        }
        public List<String> getScopes() {
            return scopes;
        }
        public String getState() {
            return state;
        }
        public String getRedirectUrl() {
            return redirectUrl;
        }

        private String encodeUrl(String component){
            try {
                return URLEncoder.encode(component, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "";
        }

        public String build(){
            return AccountsClient.ACCOUNTS_URL
                    +"/auth/oauth2"
                    +"?client_id="+encodeUrl(clientId)
                    +"&scope="+encodeUrl(String.join(" ", scopes))
                    +(redirectUrl == null ? "" : "&redirect_url="+encodeUrl(redirectUrl))
                    +(state == null ? "" : "&state="+encodeUrl(state));
        }
    }
}
