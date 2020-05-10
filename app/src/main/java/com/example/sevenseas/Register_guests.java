package com.example.sevenseas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register_guests extends AppCompatActivity {

    EditText d1,d2,d3,d4,d5,d6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_guests);
        d1=(EditText)findViewById(R.id.editText);
        d2=(EditText)findViewById(R.id.editText2);
        d3=(EditText)findViewById(R.id.editText3);
        d4=(EditText)findViewById(R.id.editText4);
        d5=(EditText)findViewById(R.id.editText5);
        d6=(EditText)findViewById(R.id.editText6);


    }

    public void register_guest_execute(View view) {
        backgroundtask b = new backgroundtask(this);
        b.execute("register_c",d1.getText().toString(),d2.getText().toString(),d3.getText().toString(),d4.getText().toString(),d5.getText().toString(),d6.getText().toString());

    }
}
