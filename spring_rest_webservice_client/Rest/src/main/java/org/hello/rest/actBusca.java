package org.hello.rest;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class  actBusca extends AppCompatActivity {

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
        dados.add("FNL");
        dados.add("SDU");
        dados.add("FNL");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,dados);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spnOrigem.setAdapter(adapter);
        spnDestino.setAdapter(adapter);
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
        Date dataida = new Date();
        Date datavolta = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dataida = (Date) df.parse(DataIda.getText().toString());
            datavolta = (Date) df.parse(DataVolta.getText().toString());
        }
        catch (Exception e){
            Log.e("DATE", e.getMessage(), e);
        }

        new HttpRequestTask(itemSelecionadospnOrigem, itemSelecionadospnDestino, dataida, datavolta, activity).execute();

    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        Spinner spnDestino = (Spinner) findViewById(R.id.spnDestino);
        TextView lblDestino = (TextView) findViewById(R.id.lblDestino);

        Spinner spnOrigem = (Spinner) findViewById(R.id.spnOrigem);
        Button btnBuscar = (Button) findViewById(R.id.btnBuscar);

        Bundle bludle = getIntent().getExtras();


        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.chbSomenteIda:
                if (checked) {
                    spnDestino.setVisibility(View.INVISIBLE);
                    lblDestino.setVisibility(View.INVISIBLE);
                } else {
                    spnDestino.setVisibility(View.VISIBLE);
                    lblDestino.setVisibility(View.VISIBLE);
                }
                // Put some meat on the sandwich
                // else
                // Remove the meat
                break;

        }
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, TravelResponse> {
        WeakReference<Activity> mActivityReference;

        String origem;
        String destino;
        Date dataida;
        Date datavolta;

        public AsyncResponse delegate = null;

        HttpRequestTask(String origem, String destino, Date dataida, Date datavolta, Activity activity) {
            this.origem = origem;
            this.destino = destino;
            this.dataida = dataida;
            this.datavolta = datavolta;
            this.mActivityReference = new WeakReference<Activity>(activity);
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

        public void setDataIda(Date dataida) {
            this.dataida = dataida;
        }

        public Date getDataIda() {
            return this.dataida;
        }

        public void setDataVolta(Date datavolta) {
            this.datavolta = datavolta;
        }

        public Date getDataVolta() {
            return this.datavolta;
        }

        @Override
        protected TravelResponse doInBackground(Void... params) {
            try {
                final String url = "https://noodle-thiagosteiner.c9users.io:8081";
                MyRestTemplate restTemplate = new MyRestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                TravelRequest request = new TravelRequest(dataida, datavolta, origem, destino);

                // Set the Content-Type header
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.setContentType(new MediaType("application", "json"));
                //requestHeaders.add("Accept", "application/json");
                requestHeaders.add("Content-Type", "application/json");

                HttpEntity<TravelRequest> requestEntity = new HttpEntity<>(request, requestHeaders);

                ResponseEntity<TravelResponse[]> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, TravelResponse[].class);
                //Response response = restTemplate.postForObject(url,request,Response,);
                Log.e("PASSOU", "passou");
                return responseEntity.getBody()[0];
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
        protected void onPostExecute(TravelResponse response) {

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = null;
            try {
                json = ow.writeValueAsString(response);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


            Intent it = new Intent(getApplicationContext(), actLista.class);
            it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            it.putExtra("DataIda", this.getDataIda().toString());
            it.putExtra("DataVolta", this.getDataVolta().toString());
            it.putExtra("Origem", this.getOrigem());
            it.putExtra("Destino", this.getDestino());
            it.putExtra("Json", json);

            getApplicationContext().startActivity(it);


        }

    }
}
