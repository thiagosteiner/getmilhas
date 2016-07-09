package org.hello.rest;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steiner on 05/07/16.
 */
public final class Response {
    @JsonProperty("headers") public List<String> headers= new ArrayList<String>();
    @JsonProperty("rows") public List<Rows> rows=new ArrayList<Rows>();

    @JsonCreator
    public Response(@JsonProperty("headers") List<String> headers, @JsonProperty("rows") List<Rows> rows){
        this.headers = headers;
        this.rows = rows;
    }

    public void setHeaders(List<String> headers){
        this.headers=headers;
    }
    public List<String> getHeaders(){
        return this.headers;
    }

    public void setRows(List<Rows> rows){
        this.rows=rows;
    }
    public List<Rows> getRows(){
        return this.rows;
    }


}