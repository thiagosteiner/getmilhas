package org.hello.rest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            new HttpRequestTask().execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }


    private class HttpRequestTask extends AsyncTask<Void, Void, Response> {
        @Override
        protected Response doInBackground(Void... params) {
            try {
                final String url = "https://api.dexi.io/runs/55b0593d-c2c8-4e6d-9411-d8b1b84063bb/execute/inputs/wait";
                MyRestTemplate restTemplate = new MyRestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                Request request=new Request("64302440325","Tonohotel0830","GRU","BSB","05/12/2016","06/12/2016");

                // Set the Content-Type header
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.setContentType(new MediaType("application","json"));
                requestHeaders.add("X-CloudScrape-Access","0fe528798ed3dac103e836e192742f83");
                requestHeaders.add("X-CloudScrape-Account","cd84c702-2069-4510-bd44-03d90a4b767d");
                requestHeaders.add("Accept","application/json");
                requestHeaders.add("Accept-Encoding","gzip");

                HttpEntity<Request> requestEntity = new HttpEntity<>(request, requestHeaders);

                ResponseEntity<Response> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Response.class);
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
                    ((SimpleClientHttpRequestFactory) getRequestFactory()).setConnectTimeout(100 * 1000);
                    ((SimpleClientHttpRequestFactory) getRequestFactory()).setReadTimeout(100 * 1000);
                } else if (getRequestFactory() instanceof HttpComponentsClientHttpRequestFactory) {
                    Log.d("HTTP", "HttpClient is used");
                    ((HttpComponentsClientHttpRequestFactory) getRequestFactory()).setReadTimeout(100 * 1000);
                    ((HttpComponentsClientHttpRequestFactory) getRequestFactory()).setConnectTimeout(100 * 1000);
                }
            }
        }


        @Override
        protected void onPostExecute(Response response) {
            TextView greetingIdText = (TextView) findViewById(R.id.id_value);
            TextView greetingContentText = (TextView) findViewById(R.id.content_value);
            greetingIdText.setText("Teste");
            greetingContentText.setText(response.getHeaders().get(1));
        }

    }

}
