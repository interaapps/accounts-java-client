package de.interaapps.accounts.apiclient.responses;

public class ExceptionResponse extends ActionResponse {
    public boolean error = true;
    public String exception = "InternalError";
    public String message = "";

}
