package com.example.mapp_project_countries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;






    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=d21emijo";
    private final String JSON_FILE = "countries.json";//För att använda json assets istället för internet






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        Button about = findViewById(R.id.about);

        //myWebView = findViewById(R.id.myWebView);



        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("===","button press");
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);


            }


        });




        new JsonTask(this).execute(JSON_URL); //ladda ner filen
    }

    @Override
    public void onPostExecute(String json) {



        Gson gson = new Gson();
        Type type = new TypeToken<List<Countries>>() {}.getType();
        List<Countries> listOfCountries = gson.fromJson(json, type); //hämta lista från gson
        recyclerViewAdapter.setItems(listOfCountries);  //hämta lista från Mountain
        recyclerViewAdapter.notifyDataSetChanged();     //uppdatera

        Log.d("====","Number of element " + listOfCountries.size() );
        Log.d("=====" , "element 0 "+ listOfCountries.get(1).toString());

    }

}