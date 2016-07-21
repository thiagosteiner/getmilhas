package org.hello.rest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class actLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actlista);

        ListView lista = (ListView) findViewById(R.id.lvVoos);

        Intent it = getIntent();
        final String dataIda = it.getStringExtra("DataIda");
        final String dataVolta = it.getStringExtra("DataVolta");
        final String origem = it.getStringExtra("Origem");
        final String destino = it.getStringExtra("Destino");
        String strjson = it.getStringExtra("Json");


        ObjectMapper mapper= new ObjectMapper();
        TravelResponse[] response=null;
        try {
            response = mapper.readValue(strjson, TravelResponse[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final ArrayList<String> list_print = new ArrayList<>();
        int contador=0;

        for (int i=0;i< (response[0].getResults().getVooIdaHoraSaida().size());i++) {

            if (Objects.equals(response[0].getResults().getVooIdaAeroportoOrigem().get(i), origem)) {
                list_print.add("Ida:"+
                                response[0].getResults().getVooIdaHoraSaida().get(i) + " " +
                                response[0].getResults().getVooIdaAeroportoOrigem().get(i) + " " +
                                response[0].getResults().getVooIdaHoraChegada().get(i) + " " +
                                response[0].getResults().getVooIdaAeroportoDestino().get(i) + " " +
                                response[0].getResults().getVooIdaDuracao().get(i) + " " +
                                response[0].getResults().getVooIdaNumero().get(i) + "\nPreços "+
                                response[0].getResults().getVooIdaPreco1().get(contador) + " "+
                                response[0].getResults().getVooIdaPreco2().get(contador) + " "+
                                response[0].getResults().getVooIdaPreco3().get(contador)
                );
                contador=contador+1;



            } else {

                list_print.add("Conexão:"+
                                response[0].getResults().getVooIdaHoraSaida().get(i) + " " +
                                response[0].getResults().getVooIdaAeroportoOrigem().get(i) + " " +
                                response[0].getResults().getVooIdaHoraChegada().get(i) + " " +
                                response[0].getResults().getVooIdaAeroportoDestino().get(i) + " " +
                                response[0].getResults().getVooIdaDuracao().get(i) + " " +
                                response[0].getResults().getVooIdaNumero().get(i) + " "
                );
            }
        }

        contador=0;

        for (int i=0;i< (response[0].getResults().getVooVoltaHoraSaida().size());i++) {

            if (Objects.equals(response[0].getResults().getVooVoltaAeroportoOrigem().get(i), destino)) {
                list_print.add("Volta:"+
                        response[0].getResults().getVooVoltaHoraSaida().get(i) + " " +
                        response[0].getResults().getVooVoltaAeroportoOrigem().get(i) + " " +
                        response[0].getResults().getVooVoltaHoraChegada().get(i) + " " +
                        response[0].getResults().getVooVoltaAeroportoDestino().get(i) + " " +
                        response[0].getResults().getVooVoltaDuracao().get(i) + " " +
                        response[0].getResults().getVooVoltaNumero().get(i) + "\nPreços:"+
                        response[0].getResults().getVooVoltaPreco1().get(contador) + " "+
                        response[0].getResults().getVooVoltaPreco2().get(contador) + " "+
                        response[0].getResults().getVooVoltaPreco3().get(contador)
                );
                contador=contador+1;



            } else {


                list_print.add("Conexão:"+
                        response[0].getResults().getVooVoltaHoraSaida().get(i) + " " +
                        response[0].getResults().getVooVoltaAeroportoOrigem().get(i) + " " +
                        response[0].getResults().getVooVoltaHoraChegada().get(i) + " " +
                        response[0].getResults().getVooVoltaAeroportoDestino().get(i) + " " +
                        response[0].getResults().getVooVoltaDuracao().get(i) + " " +
                        response[0].getResults().getVooVoltaNumero().get(i) + " "
                );
            }
        }




        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list_print);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),list_print.get(position).toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }



}
