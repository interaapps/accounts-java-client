# Accounts .http files
This folder includes multiple IntelliJ .http files which you can execute in JetBrains IDEs.

## Setup
Rename `http-client.private.env.example.json` to `http-client.private.env.json`

Set in the environment file authkey to your access-token.
### Getting Access-Token
If you want to get your access token just for testing just go to accounts.interaapps.de, open the javascript console and enter `localStorage["authkey"]` and use the given string.

Read more about getting access tokens: https://developers.interaapps.de/docs/accounts/header

> Feature missing which you can use in the frontend? Just go into your webbrowser -> press F12 (Dev-Console) -> Go to network and just look what is getting sent
