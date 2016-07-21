package org.hello.rest;

/**
 * Created by steiner on 08/07/16.
 */

public class ResponseJson {
    private java.lang.Object[][] rows;

    public void setRows(java.lang.Object[][] rows) {
        this.rows = rows;
    }

    public java.lang.Object[][] getRows() {
        return rows;
    }

    private java.lang.String[] headers;

    public void setHeaders(java.lang.String[] headers) {
        this.headers = headers;
    }

    public java.lang.String[] getHeaders() {
        return headers;
    }

}

