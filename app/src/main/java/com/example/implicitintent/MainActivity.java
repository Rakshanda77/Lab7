package com.example.implicitintent;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);
        ArrayList<String> listItems = new ArrayList<String>();
        ArrayList<String> url = new ArrayList<String>();

        Intent i = getIntent();
        String action = i.getAction();
        String data1 = i.getStringExtra(Intent.EXTRA_TEXT);

        listItems.add(data1);

        i.putExtra("url", data1);

//        String type = i.getType();
//        Uri data = i.getData();
//        Intent intent = getIntent();
//        intent.putStringArrayListExtra("test", (ArrayList<String>) listItems);
//        ArrayList<String> test = getIntent().getStringArrayListExtra("test");

        listItems.add(data1);
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Object position = listView.getItemAtPosition(i);
                String URL = url.get(i);

                Intent intent = new Intent(MainActivity.this, Brief.class);
               // intent.putExtra("url", URL);
                startActivity(intent);

            }
        });
    }

}
