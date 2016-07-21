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

    public String getJsonRequest(){

        return "{\n" +
                "    \"url\": "+"\""+getUrl()+"\""+ ",\n" +
                "    \"type\": \"html\",\n" +
                "    \"map\": {\n" +
                "        \"voo_ida_hora_saida\": {\n" +
                "            \"selector\": \"#outbound_list_flight > tbody > tr>td.tbf-col-1 strong\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "        \"voo_ida_aeroporto_origem\": {\n" +
                "            \"selector\": \"#outbound_list_flight > tbody > tr>td.tbf-col-1 span\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "        \"voo_ida_hora_chegada\": {\n" +
                "            \"selector\": \"#outbound_list_flight > tbody > tr>td.tbf-col-2 strong\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "         \"voo_ida_aeroporto_destino\": {\n" +
                "            \"selector\": \"#outbound_list_flight > tbody > tr>td.tbf-col-2 span\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "         \"voo_ida_numero\": {\n" +
                "            \"selector\": \"#outbound_list_flight > tbody > tr>td.tbf-col-3\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "         \"voo_ida_duracao\": {\n" +
                "            \"selector\": \"#outbound_list_flight > tbody > tr>td.tbf-col-4\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "         \"voo_ida_preco_1\": {\n" +
                "            \"selector\": \"#outbound_list_flight > tbody > tr>td.tbf-col-5\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "         \"voo_ida_preco_2\": {\n" +
                "            \"selector\": \"#outbound_list_flight > tbody > tr>td.tbf-col-6\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "         \"voo_ida_preco_3\": {\n" +
                "            \"selector\": \"#outbound_list_flight > tbody > tr>td.tbf-col-7\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "        \"voo_volta_hora_saida\": {\n" +
                "            \"selector\": \"#inbound_list_flight > tbody > tr>td.tbf-col-1 strong\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "        \"voo_volta_aeroporto_origem\": {\n" +
                "            \"selector\": \"#inbound_list_flight > tbody > tr>td.tbf-col-1 span\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "        \"voo_volta_hora_chegada\": {\n" +
                "            \"selector\": \"#inbound_list_flight > tbody > tr>td.tbf-col-2 strong\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "         \"voo_volta_aeroporto_destino\": {\n" +
                "            \"selector\": \"#inbound_list_flight > tbody > tr>td.tbf-col-2 span\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "         \"voo_volta_numero\": {\n" +
                "            \"selector\": \"#inbound_list_flight > tbody > tr>td.tbf-col-3\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "         \"voo_volta_duracao\": {\n" +
                "            \"selector\": \"#inbound_list_flight > tbody > tr>td.tbf-col-4\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "         \"voo_volta_preco_1\": {\n" +
                "            \"selector\": \"#inbound_list_flight > tbody > tr>td.tbf-col-5\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "         \"voo_volta_preco_2\": {\n" +
                "            \"selector\": \"#inbound_list_flight > tbody > tr>td.tbf-col-6\",\n" +
                "            \"extract\": \"text\"\n" +
                "        },\n" +
                "         \"voo_volta_preco_3\": {\n" +
                "            \"selector\": \"#inbound_list_flight > tbody > tr>td.tbf-col-7\",\n" +
                "            \"extract\": \"text\"\n" +
                "        }\n" +
                "        \n" +
                "    }\n" +
                "}";

    }


}
