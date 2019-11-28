package com.example.implicitintent;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList Url = new ArrayList<String>();;
    static  Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = findViewById(R.id.listview);
       // final TextView textView = findViewById(R.id.textView);

        i = getIntent();

        String data = i.getStringExtra(Intent.EXTRA_TEXT);

        if (data == null) {
            Url.add("");
        } else {
             Url.add( "" + data + "" );
        }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, Url);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Object links = listView.getItemAtPosition(i);
                String link = (String) Url.get(i);



                Intent intent = new Intent(MainActivity.this, Brief.class);
                intent.putExtra("url", link);
                startActivity(intent);
            }
        });

    }
}