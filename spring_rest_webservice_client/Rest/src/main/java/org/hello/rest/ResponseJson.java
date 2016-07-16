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


// string url = "http://book.latam.com/TAM/dyn/air/redemption/availability;?B_DATE_1="
//      "&B_DATE_2="
// "&B_LOCATION_1="
// "&LANGUAGE=BR&WDS_MARKET=BR&passenger_useMyPoints=true&children=0"
// "&E_LOCATION_1="
// "&SERVICE_ID=2&SITE=JJRDJJRD&COUNTRY_SITE=BR&WDS_AWARD_CORPORATE_CODE=&adults=1&infants=0&TRIP_TYPE=R"

 // "url": "http://book.latam.com/TAM/dyn/air/redemption/availability;?B_DATE_1=201611120000&B_DATE_2=201612120000&B_LOCATION_1=GIG&LANGUAGE=BR&WDS_MARKET=BR&passenger_useMyPoints=true&children=0&E_LOCATION_1=FOR&SERVICE_ID=2&SITE=JJRDJJRD&COUNTRY_SITE=BR&WDS_AWARD_CORPORATE_CODE=&adults=1&infants=0&TRIP_TYPE=R",
/*
* {
    "url": "http://book.latam.com/TAM/dyn/air/redemption/availability;?B_DATE_1=201611120000&B_DATE_2=201612120000&B_LOCATION_1=GIG&LANGUAGE=BR&WDS_MARKET=BR&passenger_useMyPoints=true&children=0&E_LOCATION_1=FOR&SERVICE_ID=2&SITE=JJRDJJRD&COUNTRY_SITE=BR&WDS_AWARD_CORPORATE_CODE=&adults=1&infants=0&TRIP_TYPE=R",
    "type": "html",
    "map": {
        "Hora_Ida": {
            "selector": "#outbound_list_flight > tbody > tr.flight>td.tbf-col-1 strong",
            "extract": "text"
        },
        "Aeroporto_origem": {
            "selector": "#outbound_list_flight > tbody > tr.flight>td.tbf-col-1 span",
            "extract": "text"
        },
        "Hora_Volta": {
            "selector": "#outbound_list_flight > tbody > tr.flight>td.tbf-col-2 strong",
            "extract": "text"
        },
         "Aeroporto_destino": {
            "selector": "#outbound_list_flight > tbody > tr.flight>td.tbf-col-2 span",
            "extract": "text"
        },
         "Voo": {
            "selector": "#outbound_list_flight > tbody > tr.flight>td.tbf-col-3",
            "extract": "text"
        },
         "Duracao": {
            "selector": "#outbound_list_flight > tbody > tr.flight>td.tbf-col-4",
            "extract": "text"
        },
         "preco_1": {
            "selector": "#outbound_list_flight > tbody > tr.flight>td.tbf-col-5",
            "extract": "text"
        },
         "preco_2": {
            "selector": "#outbound_list_flight > tbody > tr.flight>td.tbf-col-6",
            "extract": "text"
        },
         "preco_3": {
            "selector": "#outbound_list_flight > tbody > tr.flight>td.tbf-col-7",
            "extract": "text"
        }

    }
}
* */