package com.example.sevenseas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register_employees extends AppCompatActivity {

    EditText d1,d2,d3,d4,d5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_employees);
        d1 = (EditText)findViewById(R.id.name_of_employee);
        d2=(EditText)findViewById(R.id.password_of_employee);
        d3=(EditText)findViewById(R.id.age_of_employee);
        d4=(EditText)findViewById(R.id.Gender);
        d5=(EditText)findViewById(R.id.id_of_employee);

    }

    public void register_employee_execute(View view) {
        backgroundtask b = new backgroundtask(this);
        b.execute("register_e",d1.getText().toString(),d2.getText().toString(),d3.getText().toString(),d4.getText().toString(),d5.getText().toString());
        finish();

    }
}
