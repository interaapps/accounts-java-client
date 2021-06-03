# Accounts Java Client

## Installation
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.interaapps</groupId>
    <artifactId>accounts-java-client</artifactId>
    <version>1.0 <!-- Current release Tag --></version>
</dependency>
```
## Normal usage
```java
import de.interaapps.accounts.apiclient.AccountsClient;

class Example {
    public static void main(String[] args) {
        AccountsClient accountsClient = new AccountsClient("API-CLIENT");
        System.out.println("Users Username: "+accountsClient.getProfile().getName());
        
        // Example fetch for accepting all contacts
        accountsClient.getContactRequests().forEach(contactRequest -> {
            System.out.println("Username: "+contactRequest.getName());
            contactRequest.accept();
        });
    }
}
```

## OAuth2 usage

```java
import de.interaapps.accounts.apiclient.AccountsClient;
import de.interaapps.accounts.apiclient.oauth2.OAuth2Client;
import de.interaapps.accounts.apiclient.responses.oauth2.OAuth2TokenExchangeResponse;

class OAuth2Example {
    public static void main(String[] args) {
        OAuth2Client oAuth2Client = new OAuth2Client("CLIENT_ID", "CLIENT_SECRET")
                .addScopes("user.description:read");
        
        // Send user to this url
        String url = oAuth2Client.createAuthorizationURL()
                .setRedirectUrl("https://myapp/authentication/interaapps")
                .build();

        // When the user comes back, get the code query parameter and:

        // You may check the scopes before using it.
        if (oAuth2Client.checkScopes(scopes)) {

            OAuth2TokenExchangeResponse response = oAuth2Client.exchangeToken(code);

            System.out.println("Access-Token: "+response.getAccessToken());
            // You can use the refresh token by just using exchangeToken(refreshtoken)
            System.out.println("Refresh-Token: "+response.getRefreshToken());

            System.out.println("Users Name: "+response.getAccountsClient().getProfile().getName());
        }

    }
}
```
