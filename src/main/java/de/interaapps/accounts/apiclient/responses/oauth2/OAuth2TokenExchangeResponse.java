package de.interaapps.accounts.apiclient.responses.oauth2;

import com.google.gson.annotations.SerializedName;
import de.interaapps.accounts.apiclient.AccountsClient;
import de.interaapps.accounts.apiclient.responses.ActionResponse;
import de.interaapps.accounts.apiclient.responses.user.UserResponse;

import java.util.List;

public class OAuth2TokenExchangeResponse extends ActionResponse {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("refresh_token")
    private String refreshToken;

    private String scopes;

    @SerializedName("scope_list")
    private List<String> scopeList;

    @SerializedName("token_type")
    private String tokenType = "bearer";

    public List<String> getScopeList() {
        return scopeList;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public AccountsClient getAccountsClient(){
        return new AccountsClient(accessToken);
    }

    public UserResponse getProfile(){
        return getAccountsClient().getProfile();
    }
}
