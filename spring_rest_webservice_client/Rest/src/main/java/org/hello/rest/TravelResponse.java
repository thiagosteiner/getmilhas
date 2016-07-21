package org.hello.rest;

/**
 * Created by steiner on 08/07/16.
 */

public class TravelResponse{

    private Results results;

    public void setResults(Results results) {
        this.results = results;
    }

    public Results getResults() {
        return results;
    }

    private java.lang.String created;

    public void setCreated(java.lang.String created) {
        this.created = created;
    }

    public java.lang.String getCreated() {
        return created;
    }

}