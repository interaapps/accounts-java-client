package de.interaapps.accounts.apiclient;

import de.interaapps.accounts.apiclient.exceptions.AccountsException;
import de.interaapps.accounts.apiclient.requests.auth.LoginRequest;
import de.interaapps.accounts.apiclient.requests.auth.RegisterRequest;
import de.interaapps.accounts.apiclient.requests.contacts.CreateContactRequest;
import de.interaapps.accounts.apiclient.requests.user.EditUserRequest;
import de.interaapps.accounts.apiclient.responses.ActionResponse;
import de.interaapps.accounts.apiclient.responses.ExceptionResponse;
import de.interaapps.accounts.apiclient.responses.ListResponse;
import de.interaapps.accounts.apiclient.responses.auth.AuthKeyResponse;
import de.interaapps.accounts.apiclient.responses.auth.LoginResponse;
import de.interaapps.accounts.apiclient.responses.auth.RegisterResponse;
import de.interaapps.accounts.apiclient.responses.contacts.ContactRequestResponse;
import de.interaapps.accounts.apiclient.responses.contacts.ContactResponse;
import de.interaapps.accounts.apiclient.responses.iaauth.IAAuthServicePermissionGrantResponse;
import de.interaapps.accounts.apiclient.responses.iaauth.IAAuthServiceResponse;
import de.interaapps.accounts.apiclient.responses.listresponses.*;
import de.interaapps.accounts.apiclient.responses.oauth2.ExternalResourcesResponse;
import de.interaapps.accounts.apiclient.responses.oauth2.OAuth2AppResponse;
import de.interaapps.accounts.apiclient.responses.oauth2.OAuth2AuthorizedAppsResponse;
import de.interaapps.accounts.apiclient.responses.oauth2.OAuth2GrantAccessResponse;
import de.interaapps.accounts.apiclient.responses.user.UserResponse;
import org.javawebstack.httpclient.HTTPClient;
import org.javawebstack.httpclient.HTTPRequest;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountsClient extends HTTPClient {

    public static final String ACCOUNTS_URL = "https://accounts.interaapps.de";


    public AccountsClient(){
        setBaseUrl(ACCOUNTS_URL);
        after(httpRequest -> {
            ActionResponse res = httpRequest.object(ActionResponse.class);

            if (!res.success) {
                ExceptionResponse exceptionResponse = httpRequest.object(ExceptionResponse.class);
                try {
                    throw new AccountsException(exceptionResponse, exceptionResponse.exception+" | "+exceptionResponse.message);
                } catch (AccountsException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AccountsClient(String authKey){
        this();
        bearer(authKey);
    }

    public AccountsClient setAuthKey(String authKey) {
        bearer(authKey);
        return this;
    }

    public UserResponse getProfile(){
        UserResponse response = get("/api/v2/user").object(UserResponse.class);
        response.setAccountsClient(this);
        return response;
    }

    public boolean editProfile(EditUserRequest request){
        return put("/api/v2/user").jsonBody(request).object(ActionResponse.class).success;
    }

    public List<IAAuthServiceResponse> getAuthorizedIAAuthApps(){
        return get("/api/v2/iaauth/authorized_apps").object(IAAuth2AuthorizedAppsListResponse.class).getData();
    }

    public List<OAuth2AuthorizedAppsResponse> getAuthorizedOAuth2Apps(){
        return get("/api/v2/authorization/oauth2/authorized_apps").object(OAuth2AuthorizedAppsListResponse.class).getData();
    }


    public ExternalResourcesResponse getExternalResourceKey(String scope){
        try {
            return get("/api/v2/resources/external/"+URLEncoder.encode(scope, "utf-8")).object(ExternalResourcesResponse.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public OAuth2GrantAccessResponse grantOAuth2App(String id, String[] scope){
        OAuth2GrantAccessResponse response = null;
        try {
            response = get("/api/v2/authorization/oauth2/apps/"+URLEncoder.encode(id, "utf-8")+"/grant").query("scope", String.join(" ", scope)).object(OAuth2GrantAccessResponse.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return response;
    }

    public IAAuthServiceResponse getIAAuthApp(String id){
        IAAuthServiceResponse response = get("/api/v2/authorization/oauth2/authorized_apps").object(IAAuthServiceResponse.class);
        response.setAccountsClient(this);
        return response;
    }

    public ExternalResourcesResponse getExternalKey(String appId){
        return post("/api/v2/oauth2/external/"+appId).object(ExternalResourcesResponse.class);
    }

    public IAAuthServicePermissionGrantResponse grantIAAuthApp(String id){
        IAAuthServicePermissionGrantResponse response = null;
        try {
            response = get("/api/v2/iaauth/app/"+URLEncoder.encode(id, "utf-8")+"/grant").object(IAAuthServicePermissionGrantResponse.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return response;
    }

    public List<AuthKeyResponse> getAuthKeys(){
        return get("/api/v2/authkeys").object(AuthKeyListResponse.class).getData();
    }

    public List<AuthKeyResponse> getAuthKeys(String filter){
        return get("/api/v2/authkeys").query("filter", filter).object(AuthKeyListResponse.class).getData();
    }

    public ActionResponse deleteAuthKey(String id){
        return delete("/api/v2/authkeys/" + id).object(ActionResponse.class);
    }

    public OAuth2AppResponse getOAuth2App(String id){
        OAuth2AppResponse response = get("/api/v2/authorization/oauth2/authorized_apps").object(OAuth2AppResponse.class);
        response.setAccountsClient(this);
        return response;
    }


    public List<ContactResponse> getContacts(){
        return get("/api/v2/contacts").object(ContactListResponse.class).getData();
    }

    public List<ContactRequestResponse> getContactRequests(){
        return get("/api/v2/contacts/requests").object(ContactRequestListResponse.class).getData();
    }

    public UserResponse getContact(int id){
        return get("/api/v2/contacts/"+id).object(UserResponse.class);
    }

    public boolean isContactedTo(int id){
        return get("/api/v2/contacts/"+id).object(UserResponse.class) != null;
    }

    public boolean deleteContact(int id){
        return delete("/api/v2/contacts/"+id).object(ActionResponse.class).success;
    }

    public boolean acceptContact(int id){
        return get("/api/v2/contacts/requests/"+id+"/accept").object(ActionResponse.class).success;
    }

    public boolean addContact(String name){
        return post("/api/v2/contacts").jsonBody(new CreateContactRequest(name)).object(ActionResponse.class).success;
    }

    public String oAuthLogin(String platform, String code){
        return get("/api/v2/auth/oauthlogin/"+platform).query("code", code).execute().header("Location").split("auth_key=")[0];
    }

    public LoginResponse login(String username, String password){
        return post("/api/v2/auth/login").jsonBody(new LoginRequest(username, password)).object(LoginResponse.class);
    }

    /**
     * INFORMATION: THIS METHOD MIGHT GET OUTDATED IN THE FUTURE, BECAUSE IT MIGHT NEED A CAPTCHA OR SO. DON'T USE THIS!
     */
    public RegisterResponse register(String username, String mail, String password, boolean acceptPrivacyPolicies){
        return post("/api/v2/auth/register").jsonBody(new RegisterRequest(username, mail, password, acceptPrivacyPolicies)).object(RegisterResponse.class);
    }

}
