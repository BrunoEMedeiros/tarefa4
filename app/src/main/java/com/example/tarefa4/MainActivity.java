package com.example.tarefa4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.tarefa4.Paises;

import org.json.JSONArray;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Paises> listaPaises = new ArrayList<Paises>();

    String url = "https://restcountries.eu/rest/v2/lang/pt";
    JsonArrayRequest request = new JsonArrayRequest(
            Request.Method.GET,
            url, null,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {

                        int responseLength = response.length();

                        for (int i = 0; i <= responseLength; i++){

                            //System.out.println(String.valueOf(response.getJSONObject(i).getString("name")));
                            //System.out.println(response.getJSONObject(i).getJSONArray("latlng").getString(0).toString());
                            //System.out.println(response.getJSONObject(i).getJSONArray("latlng").getString(1).toString());

                            //nome.add(response.getJSONObject(i).getString("name"));
                            //lat.add(Double.parseDouble(response.getJSONObject(i).getJSONArray("latlng").getString(0).toString()));
                            //lng.add(Double.parseDouble(response.getJSONObject(i).getJSONArray("latlng").getString(1).toString()));

                            Paises p = new Paises(response.getJSONObject(i).getString("name"),
                                    response.getJSONObject(i).getJSONArray("latlng").getString(0).toString(),
                                    response.getJSONObject(i).getJSONArray("latlng").getString(1).toString()
                            );

                            listaPaises.add(p);

                            System.out.println(listaPaises.get(i).getNome());
                            System.out.println(listaPaises.get(i).getLatitude());
                            System.out.println(listaPaises.get(i).getLongitude());

                            //String nome = listaPaises.get(i).getNome();

                        }
                    }
                    catch (Exception ex){
                    }
                }
            },new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            // TODO: Handle error
            System.err.println(error);
        }

    });



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);

        ListView listview = (ListView) findViewById(R.id.listview);

        ArrayAdapter<Paises> arrayAdapter = new ArrayAdapter<Paises>(
                this,
                android.R.layout.simple_list_item_1,
                listaPaises
        );

        System.out.println(arrayAdapter);

        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent it = new Intent(MainActivity.this, MapsActivity.class);

                startActivity(it);
            }
        });

    }


    public void startSecondActivity(View view) {
        Intent secondActivity = new Intent(this, MapsActivity.class);
        startActivity( secondActivity);
    }
}