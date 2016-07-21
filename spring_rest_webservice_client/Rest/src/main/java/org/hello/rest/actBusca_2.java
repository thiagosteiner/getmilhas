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

    }

    private class HttpRequestTask extends AsyncTask<Void, Void, String> {
        WeakReference<Activity> mActivityReference;

        String origem;
        String destino;
        Date dataida;
        Date datavolta;



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
        protected String doInBackground(Void... params) {
            try {
                final String url = "https://noodle-thiagosteiner.c9users.io:8081";


                TravelRequest request = new TravelRequest(dataida, datavolta, origem, destino);

                String json="{\n" +
                        "    \"url\": "+"\""+request.getUrl()+"\""+ ",\n" +
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



                JSONObject msg= new JSONObject(json);  //passed in as a parameter to this method


                // we use http://hgoebl.github.io/DavidWebb/
                Webb webb = Webb.create();
                JSONArray result = webb.post(url)
                        .useCaches(false)
                        .body(msg)
                        .ensureSuccess()
                        .asJsonArray()
                        .getBody();


                Log.e("PASSOU", "passou");

                return result.toString();
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }


        @Override
        protected void onPostExecute(String json) {


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
