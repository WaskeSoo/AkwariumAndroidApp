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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class premium extends AppCompatActivity {
    Button premiumButton;
    MainActivity mainActivity = new MainActivity();
TextView wynikTextView;
    TextView naglowekTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.premium_content);

        DownloadTask task = new DownloadTask();
        task.execute("https://danepubliczne.imgw.pl/api/data/synop");


        premiumButton = findViewById(R.id.premiumButton);
        naglowekTextView = findViewById(R.id.naglowekTextView);
        wynikTextView = findViewById(R.id.wynikTextView);

        premiumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainActivity.xD>10){
                    mainActivity.xD-=10;
                    premiumButton.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    public class DownloadTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                int data = reader.read();
                while(data!=-1){
                    char current = (char) data;
                    result+=current;
                    data = reader.read();
                }
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        //W tej funkcji trzeba coś zmienić ponieważ error: 2020-01-03 01:54:15.470 11832-11832/com.example.myapplication W/System.err: org.json.JSONException: Value [{"id_stacji":"12295","stacja":"Białystok","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"-1.8","predkosc_wiatru":"1","kierunek_wiatru":"250","wilgotnosc_wzgledna":"75.7","suma_opadu":"000000000.01","cisnienie":"1022.6"},{"id_stacji":"12600","stacja":"Bielsko Biała","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"1.6","predkosc_wiatru":"0","kierunek_wiatru":"0","wilgotnosc_wzgledna":"37.8","suma_opadu":"0000000000.8","cisnienie":"1027.1"},{"id_stacji":"12235","stacja":"Chojnice","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"-2","predkosc_wiatru":"3","kierunek_wiatru":"240","wilgotnosc_wzgledna":"81.0","suma_opadu":"0000000000.4","cisnienie":"1020.8"},{"id_stacji":"12550","stacja":"Częstochowa","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"3.9","predkosc_wiatru":"3","kierunek_wiatru":"200","wilgotnosc_wzgledna":"34.7","suma_opadu":"000000000.01","cisnienie":"1025.6"},{"id_stacji":"12160","stacja":"Elbląg","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"0.5","predkosc_wiatru":"7","kierunek_wiatru":"220","wilgotnosc_wzgledna":"60.6","suma_opadu":"0000000000.2","cisnienie":"1019.4"},{"id_stacji":"12155","stacja":"Gdańsk","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"-0.2","predkosc_wiatru":"4","kierunek_wiatru":"180","wilgotnosc_wzgledna":"68.8","suma_opadu":"000000000.01","cisnienie":"1018.8"},{"id_stacji":"12300","stacja":"Gorzów","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"-0.4","predkosc_wiatru":"3","kierunek_wiatru":"230","wilgotnosc_wzgledna":"85.0","suma_opadu":"000000000.01","cisnienie":"1023.5"},{"id_stacji":"12135","stacja":"Hel","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"3.6","predkosc_wiatru":"3","kierunek_wiatru":"210","wilgotnosc_wzgledna":"69.6","suma_opadu":"000000000.01","cisnienie":"1018.2"},{"id_stacji":"12500","stacja":"Jelenia Góra","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"-6.4","predkosc_wiatru":"1","kierunek_wiatru":"150","wilgotnosc_wzgledna":"89.7","suma_opadu":"000000000.01","cisnienie":"1027.2"},{"id_stacji":"12435","stacja":"Kalisz","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"0.2","predkosc_wiatru":"4","kierunek_wiatru":"260","wilgotnosc_wzgledna":"70.0","suma_opadu":"0000000000.2","cisnienie":"1024.2"},{"id_stacji":"12650","stacja":"Kasprowy Wierch","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"4.8","predkosc_wiatru":"7","kierunek_wiatru":"220","wilgotnosc_wzgledna":"5.9","suma_opadu":"0000000000.8","cisnienie":null},{"id_stacji":"12560","stacja":"Katowice","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"-4.8","predkosc_wiatru":"0","kierunek_wiatru":"0","wilgotnosc_wzgledna":"91.2","suma_opadu":"000000000.01","cisnienie":"1027.7"},{"id_stacji":"12185","stacja":"Kętrzyn","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"0.1","predkosc_wiatru":"5","kierunek_wiatru":"190","wilgotnosc_wzgledna":"65.8","suma_opadu":"0000000001.9","cisnienie":"1020.3"},{"id_stacji":"12570","stacja":"Kielce","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"-5.6","predkosc_wiatru":"1","kierunek_wiatru":"20","wilgotnosc_wzgledna":"91.9","suma_opadu":"000000000.01","cisnienie":"1027.5"},{"id_stacji":"12520","stacja":"Kłodzko","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"1","predkosc_wiatru":"4","kierunek_wiatru":"200","wilgotnosc_wzgledna":"66.0","suma_opadu":"000000000.01","cisnienie":"1027.1"},{"id_stacji":"12345","stacja":"Koło","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"-1.6","predkosc_wiatru":"2","kierunek_wiatru":"170","wilgotnosc_wzgledna":"74.6","suma_opadu":"0000000000.2","cisnienie":"1023.9"},{"id_stacji":"12100","stacja":"Kołobrzeg","data_pomiaru":"2020-01-03","godzina_pomiaru":"0","temperatura":"0.8","predkosc_wiatru":"4","kierunek_wiatru":"230","wilgotnosc_wzgledna":"89.0","suma_opadu":"0000000000.7","cisnienie":"1020.1"},{"id_st

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                String tempInfo = jsonObject.getString("temp");
                JSONArray array = new JSONArray(tempInfo);
                for(int i=0;i<array.length();i++){
                    JSONObject jsonPart = array.getJSONObject(i);
                    if(jsonPart.getString("id_stacji").equals("12155"))
                    {
                        Log.i("main:",jsonPart.getString("cisnienie"));
                        wynikTextView.setText(jsonPart.getString("temperatura"));
                    }



                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
