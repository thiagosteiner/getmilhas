package org.hello.rest;


/**
 * Created by steiner on 05/07/16.
 */
public final class Response {
    public final String[] headers;
    public final Rows rows;


    public Response(String[] headers,Rows rows){
        this.headers = headers;
        this.rows = rows;
    }
}