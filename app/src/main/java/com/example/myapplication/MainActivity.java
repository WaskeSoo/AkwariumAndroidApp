package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ProgressBar vertical_progress_bar1;
    ProgressBar vertical_progress_bar2;
    ProgressBar vertical_progress_bar3;
    ImageView ryba1ImageView;
    ImageView ryba2ImageView;
    ImageView ryba3ImageView;
    Button button1;
    Button button2;
    Button button3;
    Button karmienieButton;
    RotateAnimation rotate;
    RotateAnimation rotate1;
    RotateAnimation rotate2;
    ObjectAnimator animation;
    ObjectAnimator animation1;
    TextView pieniądzeTextView;
    int xD=1;
    boolean ryba1Alive=true;
    boolean ryba2Alive=true;
    boolean ryba3Alive=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vertical_progress_bar1 = findViewById(R.id.vertical_progressbar1);
        vertical_progress_bar2 = findViewById(R.id.vertical_progressbar2);
        vertical_progress_bar3 = findViewById(R.id.vertical_progressbar3);
        ryba1ImageView=findViewById(R.id.ryba1ImageView);
        ryba2ImageView=findViewById(R.id.ryba2ImageView);
        ryba3ImageView=findViewById(R.id.ryba3ImageView);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        karmienieButton=findViewById(R.id.karmienieButton);
        rotate = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotate1 = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.8f,Animation.RELATIVE_TO_SELF,0.8f);
        rotate2 = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,-0.8f,Animation.RELATIVE_TO_SELF,-0.8f);


        animation = ObjectAnimator.ofFloat(ryba2ImageView,"translationX",-400f);

        animation.setDuration(5000);

        rotate.setDuration(5000);
        rotate.setInterpolator(new LinearInterpolator());
        rotate1.setDuration(5000);
        rotate1.setInterpolator(new LinearInterpolator());
        pieniądzeTextView = findViewById(R.id.pieniądzeTextView);


        vertical_progress_bar1.setProgress(10);
        vertical_progress_bar2.setProgress(10);
        vertical_progress_bar3.setProgress(10);

        guzik();
        hajs();
        karmienie(karmienieButton);

    }
    //Zarabianie hajsu i wyswietlanie go
    public void hajs(){

  CountDownTimer x=new CountDownTimer(1000,1000) {

    @Override
    public void onTick(long l) {

        pieniądzeTextView.setText(String.valueOf("Twoje pieniądze: "+xD));
    }

    @Override
    public void onFinish() {

xD++;

        start();
    }
};
        x.start();
    }
//Przycisk karmienia
    public void karmienie(View view){
        karmienieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(xD>=20){

                    vertical_progress_bar1.setProgress(vertical_progress_bar1.getProgress()+1);
                    vertical_progress_bar2.setProgress(vertical_progress_bar2.getProgress()+1);
                    vertical_progress_bar3.setProgress(vertical_progress_bar3.getProgress()+1);
                    xD-=20;
                }
            }
        });


    }

    //Ktory z przyciskow ma dzialac
    public void guzik(){

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vertical_progress_bar1.setProgress(vertical_progress_bar1.getProgress()-1);
                    zabijRybe(ryba1ImageView);
                    doTrick(ryba1ImageView);


                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vertical_progress_bar2.setProgress(vertical_progress_bar2.getProgress()-1);
                    zabijRybe(ryba2ImageView);
                    doTrick(ryba2ImageView);
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vertical_progress_bar3.setProgress(vertical_progress_bar3.getProgress()-1);
                    zabijRybe(ryba3ImageView);
                    doTrick(ryba3ImageView);
                }
            });
        }

//Trikasy fikasy rybasy dzimdziumbasy
    public void doTrick(View view){
        if(view==ryba1ImageView){
        ryba1ImageView.startAnimation(rotate);
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);


    }
        if(view==ryba2ImageView){
            ryba2ImageView.startAnimation(rotate);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
        }
        if(view==ryba3ImageView){
            ryba3ImageView.startAnimation(rotate1);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
        }
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if(ryba1Alive==true)
                {
                    button1.setEnabled(true);
                }else vertical_progress_bar1.setVisibility(View.INVISIBLE);

                if(ryba2Alive==true)
                {
                    button2.setEnabled(true);
                }else vertical_progress_bar2.setVisibility(View.INVISIBLE);
                if(ryba3Alive==true)
                {
                    button3.setEnabled(true);
                }else vertical_progress_bar3.setVisibility(View.INVISIBLE);
            }
        }.start();



    }

    //Zabij 1 z 3 ryb ze zmeczenia
    public void zabijRybe(View view){

        if(view==ryba1ImageView){
           if(vertical_progress_bar1.getProgress()<=0) {
               ryba1ImageView.animate().alpha(1).setDuration(1000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
                   @Override
                   public void run() {
                       ryba1ImageView.animate().alpha(0).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();

                   }
               }).start();
               ryba1Alive=false;

           }
        }
        if(view==ryba2ImageView){
            if(vertical_progress_bar2.getProgress()<=0) {
                ryba2ImageView.animate().alpha(1).setDuration(1000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        ryba2ImageView.animate().alpha(0).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();

                    }
                }).start();
                ryba2Alive=false;

            }
        }
        if(view==ryba3ImageView){
            if(vertical_progress_bar3.getProgress()<=0) {
                ryba3ImageView.animate().alpha(1).setDuration(1000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        ryba3ImageView.animate().alpha(0).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();

                    }
                }).start();
               ryba3Alive=false;

            }
        }
    }
}
