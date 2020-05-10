package com.example.sevenseas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LOGIN extends AppCompatActivity implements AsyncResponse {




    TextView tv;
    EditText id ;
    Button button;
//    String[] fruits=new String[1000] ;
//     List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits));
//
//    // Create an ArrayAdapter from List
//     ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
//            (this, android.R.layout.simple_list_item_1,fruits_list);

    // DataBind ListView with items from ArrayAdapter


    @Override
    public void processFinish(String output) {

//        String lineSep = System.getProperty("line.separator");
//        String yourString=output;
//
//
//        yourString= yourString.replaceAll("\n", "\n");
//        tv.setText(yourString);
        tv.setText(Html.fromHtml(output));
        System.out.println(output);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        lv=(ListView)findViewById(R.id.list_guests);
//        lv.setAdapter(arrayAdapter);
        tv = (TextView) findViewById(R.id.textView);
        tv.setMovementMethod(new ScrollingMovementMethod());
        id = (EditText) findViewById(R.id.remove_guest_text);
        button = (Button)findViewById(R.id.delete_guest);


    }


    public void view_guests_execute(View view) {
        backgroundtask b = new backgroundtask(this);
        b.delegate=this;
        b.execute("login1","lol","lol");

    }

    public void add_guest_execute(View view) {
        Intent in = new Intent(this,Register_guests.class);
        startActivity(in);
        finish();
    }

    public void remove_guest_execute(View view) {
        backgroundtask b = new backgroundtask(this);
        b.execute("delete",id.getText().toString(),"lol");

    }
}

