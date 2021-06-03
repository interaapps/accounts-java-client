package de.interaapps.accounts.apiclient.responses;

import com.google.gson.Gson;

public class ActionResponse {
    public boolean success = false;

    public static ActionResponse success(){
        ActionResponse response = new ActionResponse();
        response.success = true;
        return response;
    }

    public String toString() {
        return  new Gson().toJson(this);
    }
}
