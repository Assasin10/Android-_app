package com.example.sevenseas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;


public class backgroundtask extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog1;
    public AsyncResponse delegate=null;
    Context c;
  public int r=111;
  int count=0;
    backgroundtask(Context c)
    {
        this.c = c;

    }
    protected void onPreExecute() {
        super.onPreExecute();
        alertDialog1=new AlertDialog.Builder(c).create();
        alertDialog1.setTitle("login Information.....");
    }

    @Override
    protected String doInBackground(String... voids) {
        String method=voids[0];
        String list_url="http://10.0.2.2/hotel/list.php";
        String login_url="http://10.0.2.2/hotel/login.php";
        String reg2_url="http://10.0.2.2/hotel/register2.php";
        String reg1_url="http://10.0.2.2/hotel/register1.php";
        String delete_url="http://10.0.2.2/hotel/delete.php";
        if(method.equals("login"))
        {
            String login_name = voids[1];
            String login_password=voids[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("login_name","UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+URLEncoder.encode("login_password","UTF-8" )+"="+URLEncoder.encode(login_password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();
                return  response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("register_e"))
        {
            String d1 = voids[1];
            String d2=voids[2];
            String d3=voids[3];
            String d4=voids[4];
            String d5=voids[5];

            System.out.println(d1+""+d2+""+d3);
            try {
                URL url = new URL(reg1_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("d1","UTF-8")+"="+URLEncoder.encode(d1,"UTF-8")+"&"+URLEncoder.encode("d2","UTF-8" )+"="+URLEncoder.encode(d2,"UTF-8")+"&"+URLEncoder.encode("d3","UTF-8" )+"="+URLEncoder.encode(d3,"UTF-8")+"&"+URLEncoder.encode("d4","UTF-8" )+"="+URLEncoder.encode(d4,"UTF-8")+"&"+URLEncoder.encode("d5","UTF-8" )+"="+URLEncoder.encode(d5,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration success";
            }  catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("register_c"))
        {
            String d1 = voids[1];
            String d2=voids[2];
            String d3=voids[3];
            String d4=voids[4];
            String d5=voids[5];
            String d6=voids[6];

            System.out.println(d1+""+d2+""+d3);
            try {
                URL url = new URL(reg2_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("d1","UTF-8")+"="+URLEncoder.encode(d1,"UTF-8")+"&"+URLEncoder.encode("d2","UTF-8" )+"="+URLEncoder.encode(d2,"UTF-8")+"&"+URLEncoder.encode("d3","UTF-8" )+"="+URLEncoder.encode(d3,"UTF-8")+"&"+URLEncoder.encode("d4","UTF-8" )+"="+URLEncoder.encode(d4,"UTF-8")+"&"+URLEncoder.encode("d5","UTF-8" )+"="+URLEncoder.encode(d5,"UTF-8")+"&"+URLEncoder.encode("d6","UTF-8" )+"="+URLEncoder.encode(d6,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration success";
            }  catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("delete"))
        {
            String id = voids[1];
            System.out.println(id);
            String login_password=voids[2];
            try {
                URL url = new URL(delete_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")+"&"+URLEncoder.encode("login_password","UTF-8" )+"="+URLEncoder.encode(login_password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration success";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            count++;
            String login_name = voids[1];
            String login_password=voids[2];
            try {
                URL url = new URL(list_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("login_name","UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+URLEncoder.encode("login_password","UTF-8" )+"="+URLEncoder.encode(login_password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();
                return  response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }






    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }




    @Override
    protected void onPostExecute(String result) {

        //System.out.println(result);
        if (result.equals("Registration success"))
            Toast.makeText(c,result,Toast.LENGTH_LONG).show();
        else if(count==1)
        {
            delegate.processFinish(result);
        }
        else
        {
            if(result.equals("SUCCESS") || result.equals("wrong credentials"))
            {

                System.out.println(r);
                delegate.processFinish(result);




            }
            else {
                alertDialog1.setMessage(result);
                alertDialog1.show();
            }
        }





    }
    public int helper1()
    {
        r++;
        System.out.println(r);
        return r;
    }
}
