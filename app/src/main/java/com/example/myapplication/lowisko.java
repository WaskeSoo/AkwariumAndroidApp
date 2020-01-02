package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lowisko extends AppCompatActivity {
    Button wskrzeszanieButton;

MainActivity mainActivity = new MainActivity();



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nowe_lowisko);

        wskrzeszanieButton=findViewById(R.id.wskrzeszanieButton);

wskrzeszanieButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(mainActivity.ryba1Alive==false)
        {
        mainActivity.VPB1=10;
       mainActivity.ryba1Alive=true;
        }
        if(mainActivity.ryba2Alive==false){
            mainActivity.VPB2=10;
            mainActivity.ryba2Alive=true;
        }
        if(mainActivity.ryba3Alive==false){
            mainActivity.VPB3=10;
            mainActivity.ryba2Alive=true;
        }


    }
});
    }
}
