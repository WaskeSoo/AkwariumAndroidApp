package com.example.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class premium extends AppCompatActivity {
    Button premiumButton;
    MainActivity mainActivity = new MainActivity();
   public static TextView wynikTextView;
    TextView naglowekTextView;
    public static String zmienna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.premium_content);

        DownloadTask task = new DownloadTask();


        premiumButton = findViewById(R.id.premiumButton);
        naglowekTextView = findViewById(R.id.naglowekTextView);
        wynikTextView = findViewById(R.id.wynikTextView);

        premiumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainActivity.xD>=500) {
                    mainActivity.xD-=500;
                    premiumButton.setVisibility(View.INVISIBLE);
                    DownloadTask downloadTask = new DownloadTask();
                    downloadTask.execute();
                }
            }
        });

    }
}


//Klasa do pobierania info z api

    class DownloadTask extends AsyncTask<Void,Void,Void> {
            String data="";
            String dataParased = "";
            String singleParased="";
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("https://danepubliczne.imgw.pl/api/data/synop");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while(line!= null){
                    line= bufferedReader.readLine();
                    data = data+line;
                }

                JSONArray jsonArray = new JSONArray(data);
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    if (jsonObject.get("id_stacji").equals("12155")) {
                        singleParased = "Temperatura:" + jsonObject.get("temperatura")+"°C"+"\n"+"" +
                                        "Dnia:"+ jsonObject.get("data_pomiaru")+"\n"+
                                        "Mierzona o godzinie:" + jsonObject.get("godzina_pomiaru");
                        dataParased = dataParased + singleParased;
                    }
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            premium.wynikTextView.setText(this.dataParased);
        }


    }


