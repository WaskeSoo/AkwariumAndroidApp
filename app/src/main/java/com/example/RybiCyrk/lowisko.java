package com.example.RybiCyrk;

import android.os.Bundle;
import android.view.View;
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
