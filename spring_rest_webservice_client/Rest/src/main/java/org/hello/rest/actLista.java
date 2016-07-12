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
import java.util.List;

public class actLista extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


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

        TextView lblVoos = (TextView ) findViewById(R.id.lblVoos);

        lblVoos.setText(strjson);


        ObjectMapper mapper= new ObjectMapper();
        ResponseJson response=null;
        try {
            response = mapper.readValue(strjson, ResponseJson.class);
        } catch (IOException e) {
            e.printStackTrace();
        }



//        String viagens_ida_json="{viagens_ida:"+response.getRows()[0][6]+"}";
//        try {
//            Viagem[] lista_viagens=mapper.readValue(viagens_ida_json,Viagem[].class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        final ArrayList<String> list_print = new ArrayList<>();
        list_print.add(strjson);
        ///list_print.add(response.getRows()[0][7].toString());




        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list_print);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Voo: "+list_print.get(position).toString() + " " + dataIda + " " + dataVolta + " " + origem + " " + destino, Toast.LENGTH_SHORT).show();

            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.



    }

//    private ArrayList<String> preencherDados() {
//        ArrayList<String> dados = new ArrayList<String>();
//        dados.add("JJ3110");
//        dados.add("JJ3111");
//        dados.add("JJ3112");
//        return dados;
//    }


}
