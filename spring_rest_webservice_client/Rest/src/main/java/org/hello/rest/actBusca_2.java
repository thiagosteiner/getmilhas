package org.hello.rest;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.goebl.david.Webb;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class  actBusca_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actbusca);


        Spinner spnDestino = (Spinner) findViewById(R.id.spnDestino);
        Spinner spnOrigem = (Spinner) findViewById(R.id.spnOrigem);


        List<String> dados = new ArrayList<String>();
        dados.add("BSB");
        dados.add("GIG");
        dados.add("VIX");
        dados.add("GRU");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,dados);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spnOrigem.setAdapter(adapter);

        List<String> dados_2 = new ArrayList<String>();

        dados_2.add("GIG");
        dados_2.add("VIX");
        dados_2.add("GRU");
        dados_2.add("BSB");

        ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,dados_2);
        // Specify the layout to use when the list of choices appears
        adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        spnDestino.setAdapter(adapter_2);
    }



    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    Activity activity = (Activity) getBaseContext();

    public void irparalista(View v) {
        EditText DataIda = (EditText) findViewById(R.id.edtDataIda);
        EditText DataVolta = (EditText) findViewById(R.id.edtDataVolta);
        Spinner spnDestino = (Spinner) findViewById(R.id.spnDestino);
        Spinner spnOrigem = (Spinner) findViewById(R.id.spnOrigem);
        String itemSelecionadospnOrigem = spnOrigem.getSelectedItem().toString();
        String itemSelecionadospnDestino = spnDestino.getSelectedItem().toString();
//        Date dataida = new Date();
//        Date datavolta = new Date();
//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        try {
//            dataida = (Date) df.parse(DataIda.getText().toString());
//            datavolta = (Date) df.parse(DataVolta.getText().toString());
//        }
//        catch (Exception e){
//            Log.e("DATE", e.getMessage(), e);
//        }
        String dataIda=DataIda.getText().toString();
        String dataVolta=DataVolta.getText().toString();
        new HttpRequestTask(itemSelecionadospnOrigem, itemSelecionadospnDestino, dataIda, dataVolta).execute();

    }

    private class HttpRequestTask extends AsyncTask<Void, Void, ResponseJson> {

        String origem;
        String destino;
        String dataida;
        String datavolta;



        HttpRequestTask(String origem, String destino, String dataida, String datavolta) {
            this.origem = origem;
            this.destino = destino;
            this.dataida = dataida;
            this.datavolta = datavolta;
        }


        public void setOrigem(String origem) {
            this.origem = origem;
        }

        public String getOrigem() {
            return this.origem;
        }

        public void setDestino(String destino) {
            this.destino = destino;
        }

        public String getDestino() {
            return this.destino;
        }

        public void setDataIda(String dataida) {
            this.dataida = dataida;
        }

        public String getDataIda() {
            return this.dataida;
        }

        public void setDataVolta(String datavolta) {
            this.datavolta = datavolta;
        }

        public String getDataVolta() {
            return this.datavolta;
        }

        @Override
        protected ResponseJson doInBackground(Void... params) {
            try {
                final String url = "https://api.dexi.io/runs/55b0593d-c2c8-4e6d-9411-d8b1b84063bb/execute/inputs/wait";
                MyRestTemplate restTemplate = new MyRestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                Request request = new Request("64302440325", "Tonohotel0830", origem, destino, dataida, datavolta);

                // Set the Content-Type header
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.setContentType(new MediaType("application", "json"));
                requestHeaders.add("X-CloudScrape-Access", "0fe528798ed3dac103e836e192742f83");
                requestHeaders.add("X-CloudScrape-Account", "cd84c702-2069-4510-bd44-03d90a4b767d");
                requestHeaders.add("Accept", "application/json");
                requestHeaders.add("Accept-Encoding", "gzip");

                HttpEntity<Request> requestEntity = new HttpEntity<>(request, requestHeaders);

                ResponseEntity<ResponseJson> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ResponseJson.class);
                //Response response = restTemplate.postForObject(url,request,Response,);

                return responseEntity.getBody();
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }


        public class MyRestTemplate extends RestTemplate {
            public MyRestTemplate() {
                if (getRequestFactory() instanceof SimpleClientHttpRequestFactory) {
                    Log.d("HTTP", "HttpUrlConnection is used");
                    ((SimpleClientHttpRequestFactory) getRequestFactory()).setConnectTimeout(200 * 1000);
                    ((SimpleClientHttpRequestFactory) getRequestFactory()).setReadTimeout(200 * 1000);
                } else if (getRequestFactory() instanceof HttpComponentsClientHttpRequestFactory) {
                    Log.d("HTTP", "HttpClient is used");
                    ((HttpComponentsClientHttpRequestFactory) getRequestFactory()).setReadTimeout(200 * 1000);
                    ((HttpComponentsClientHttpRequestFactory) getRequestFactory()).setConnectTimeout(200 * 1000);
                }
            }
        }

            @Override
            protected void onPostExecute(ResponseJson response) {
                Intent it = new Intent(getApplicationContext(), actLista_2.class);
                it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                it.putExtra("Origem", this.getOrigem());
                it.putExtra("Destino", this.getDestino());
                it.putExtra("Json", response.getRows()[0][6].toString());
                getApplicationContext().startActivity(it);
            }



    }




}
