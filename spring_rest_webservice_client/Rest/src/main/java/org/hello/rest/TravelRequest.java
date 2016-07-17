package org.hello.rest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by volpi on 7/16/16.
 */
public class TravelRequest {
    Date dataida;
    Date datavolta;
    String partida;
    String destino;
    String url;
    public TravelRequest(Date di, Date dv, String p, String d){
        this.dataida = di;
        this.datavolta = dv;
        this.partida = p;
        this.destino = d;
        this.url = this.getUrl();
    }

    public Date getDataida() {
        return dataida;
    }

    public void setDataida(Date dataida) {
        this.dataida = dataida;
    }

    public Date getDatavolta() {
        return datavolta;
    }

    public void setDatavolta(Date datavolta) {
        this.datavolta = datavolta;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getUrl(){
        DateFormat df = new SimpleDateFormat("yyyyMMdd0000");
        String url = "http://book.latam.com/TAM/dyn/air/redemption/availability;?B_DATE_1=" + df.format(dataida) +
            "&B_DATE_2=" + df.format(datavolta) +
            "&B_LOCATION_1=" + partida +
            "&LANGUAGE=BR&WDS_MARKET=BR&passenger_useMyPoints=true&children=0" +
            "&E_LOCATION_1=" + destino +
            "&SERVICE_ID=2&SITE=JJRDJJRD&COUNTRY_SITE=BR&WDS_AWARD_CORPORATE_CODE=&adults=1&infants=0&TRIP_TYPE=R";
        return url;
    }
}
