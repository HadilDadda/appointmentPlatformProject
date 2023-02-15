package com.example.cardview;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

public class dbWorkerLogin extends AsyncTask {
    private Context c;
    private AlertDialog alert;

    public dbWorkerLogin(Context c){
        this.c = c;
    }
    @Override
    protected void onPreExecute(){
        this.alert = new AlertDialog.Builder(this.c).create();
        this.alert.setTitle("Login Information");
    }
    @Override
    protected String doInBackground(Object[] param){
        String cible = "http://192.168.2.22/prjStage/login.php";
//        172.16.227.154  172.16.225.213
        try{
            URL url = new URL(cible);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("POST");

            OutputStream outs = con.getOutputStream();
            BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(outs, "utf-8"));

            String msg = URLEncoder.encode("numStudent", "utf-8")+"="+
                    URLEncoder.encode((String)param[0],"utf8")+
                    "&"+URLEncoder.encode("password","utf-8")+"="+
                    URLEncoder.encode((String)param[1], "utf-8");
            bufw.write(msg);
            bufw.flush();
            bufw.close();
            outs.close();

            InputStream ins = con.getInputStream();
            BufferedReader bufr = new BufferedReader(new InputStreamReader(ins, "iso-8859-1"));
            String line;
            StringBuffer sbuff = new StringBuffer();

            while((line = bufr.readLine()) != null){
                sbuff.append(line + "\n");
            }
            return sbuff.toString();
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }
    @Override
    protected  void onPostExecute(Object o){
        Session.key = (String)o;
        final String sep =",";
        String info = Session.key;
        String w[] = info.split(sep);

        Session.key = w[0];
        Session.numStudent = w[1];
        Session.password = w[2];


        if((String)o!=null){
            alert.setMessage("Success!");
            alert.show();}
        else{
            alert.setMessage("Error. Try again!");
            alert.show();
        }
    }
}
