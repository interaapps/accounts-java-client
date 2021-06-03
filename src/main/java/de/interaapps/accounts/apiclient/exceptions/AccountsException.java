package de.interaapps.accounts.apiclient.exceptions;

import de.interaapps.accounts.apiclient.responses.ExceptionResponse;

public class AccountsException extends Exception {
    private ExceptionResponse exceptionResponse;

    public AccountsException(ExceptionResponse exceptionResponse, String message){
        super(message);
        this.exceptionResponse = exceptionResponse;
    }

    public ExceptionResponse getExceptionResponse() {
        return exceptionResponse;
    }
}
