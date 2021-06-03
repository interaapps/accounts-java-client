package de.interaapps.accounts.apiclient.responses;

import java.util.ArrayList;
import java.util.List;

public class ListResponse<T> extends ActionResponse {
    private List<T> data;

    public List<T> getData() {
        return data;
    }
}
