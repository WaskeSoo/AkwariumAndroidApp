package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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


//wskrzeszenie();
wskrzeszanieButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(lowisko.this, MainActivity.class);
        mainActivity.vertical_progress_bar1.setProgress(10);
        intent.putExtra("hp", mainActivity.vertical_progress_bar1.getProgress());

        startActivity(intent);
    }
});
    }






//public void wskrzeszenie(){
//    wskrzeszanieButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            if(mainActivity.ryba1Alive==false){
//                mainActivity.ryba1Alive=true;
//                Log.i("Kurwa mac to dziala","Jebana ryba powinna zyc");
//                mainActivity.ryba1ImageView.setVisibility(View.VISIBLE);
//                mainActivity.button1.setEnabled(true);
//                mainActivity.vertical_progress_bar1.setProgress(10);
//                mainActivity.ryba1ImageView.animate().alpha(0).setDuration(1000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
//                    @Override
//                    public void run() {
//                        mainActivity.ryba1ImageView.animate().alpha(1).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();
//
//                    }
//                }).start();
//            }
//            if(mainActivity.ryba2Alive==false){
//                mainActivity.ryba2Alive=true;
//                mainActivity.ryba2ImageView.setVisibility(View.VISIBLE);
//                mainActivity.button2.setEnabled(true);
//                mainActivity.vertical_progress_bar2.setProgress(10);
//                mainActivity.ryba2ImageView.animate().alpha(0).setDuration(1000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
//                    @Override
//                    public void run() {
//                        mainActivity.ryba2ImageView.animate().alpha(1).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();
//
//                    }
//                }).start();
//            }
//            if(mainActivity.ryba3Alive==false){
//                mainActivity.ryba3Alive=true;
//                mainActivity.ryba3ImageView.setVisibility(View.VISIBLE);
//                mainActivity.button3.setEnabled(true);
//                mainActivity.vertical_progress_bar3.setProgress(10);
//                mainActivity.ryba3ImageView.animate().alpha(0).setDuration(1000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
//                    @Override
//                    public void run() {
//                        mainActivity.ryba3ImageView.animate().alpha(1).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();
//
//                    }
//                }).start();
//            }
//        }
//    });
//}




    //Obsluga menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.rybicyrk){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

}
