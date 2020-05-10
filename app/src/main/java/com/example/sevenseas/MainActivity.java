package com.example.sevenseas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AsyncResponse {
    backgroundtask asynctask=new backgroundtask(this);
    EditText name,pass;
    Context c;
    public Context con()
    {
        return this;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.admin_name);
        pass=(EditText)findViewById(R.id.admin_password);
    }

    @Override
    public void processFinish(String output) {
        System.out.println(output);
        if(output.equals("SUCCESS"))
        {
            Intent in = new Intent(this,LOGIN.class);
            startActivity(in);
        }
        else
        {
            Toast.makeText(this,output,Toast.LENGTH_LONG).show();
            Intent in = new Intent(this,MainActivity.class);
            startActivity(in);
        }




    }

    public void admin_login_execute(View view) {
        String data="login";

        backgroundtask b = new backgroundtask(this);
        String data1= name.getText().toString();
        String data2= pass.getText().toString();
        asynctask.delegate=this;
        asynctask.execute(data,data1,data2);




       // finish();
       // String result=b.returnmethod();


    }

    public void admin_register_execute(View view) {

        Intent in = new Intent(this,Register_employees.class);
        startActivity(in);


    }
}
