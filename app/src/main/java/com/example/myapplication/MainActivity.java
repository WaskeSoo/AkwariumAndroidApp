package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    ImageView serduszka1ImageView;
    ImageView serduszka2ImageView;
    Animation animSlide;
    Button button1;
    Button button2;
    Button button3;
    Button karmienieButton;
    RotateAnimation rotate;
    RotateAnimation rotate1;
    RotateAnimation rotate2;



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
        serduszka1ImageView=findViewById(R.id.serduszka1ImageView);
        serduszka2ImageView=findViewById(R.id.serduszka2ImageView);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        karmienieButton=findViewById(R.id.karmienieButton);
        rotate = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotate1 = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.8f,Animation.RELATIVE_TO_SELF,0.8f);
        rotate2 = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,-0.8f,Animation.RELATIVE_TO_SELF,-0.8f);




        rotate.setDuration(5000);
        rotate.setInterpolator(new LinearInterpolator());
        rotate1.setDuration(5000);
        rotate1.setInterpolator(new LinearInterpolator());
        pieniądzeTextView = findViewById(R.id.pieniądzeTextView);
        animSlide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);

        vertical_progress_bar1.setProgress(10);
        vertical_progress_bar2.setProgress(10);
        vertical_progress_bar3.setProgress(10);
        serduszka1ImageView.setVisibility(View.INVISIBLE);
        serduszka2ImageView.setVisibility(View.INVISIBLE);

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
                    hearts();
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

    //Wyslij serduszka

    public void hearts(){

        serduszka1ImageView.startAnimation(animSlide);
        serduszka2ImageView.startAnimation(animSlide);
        serduszka1ImageView.animate().alpha(0).setDuration(3000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
            @Override
            public void run() {
                serduszka1ImageView.animate().alpha(1).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();
            }
        }).start();
        serduszka2ImageView.animate().alpha(0).setDuration(3000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
            @Override
            public void run() {
                serduszka2ImageView.animate().alpha(1).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();
            }
        }).start();
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

    //Wskrzeszanie

    //Czy ryba zyje
//     public void wskrzeszanko(View view){
//        if(ryba1Alive==false){
//            ryba1Alive=true;
//            Log.i("Kurwa mac to dziala","Jebana ryba powinna zyc");
//            ryba1ImageView.setVisibility(View.VISIBLE);
//            button1.setEnabled(true);
//            vertical_progress_bar1.setProgress(10);
//            ryba1ImageView.animate().alpha(0).setDuration(1000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
//                @Override
//                public void run() {
//                    ryba1ImageView.animate().alpha(1).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();
//
//                }
//            }).start();
//        }
//        if(ryba2Alive==false){
//            ryba2Alive=true;
//            ryba2ImageView.setVisibility(View.VISIBLE);
//            button2.setEnabled(true);
//            vertical_progress_bar2.setProgress(10);
//            ryba2ImageView.animate().alpha(0).setDuration(1000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
//                @Override
//                public void run() {
//                    ryba2ImageView.animate().alpha(1).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();
//
//                }
//            }).start();
//        }
//        if(ryba3Alive==false){
//            ryba3Alive=true;
//            ryba3ImageView.setVisibility(View.VISIBLE);
//            button3.setEnabled(true);
//            vertical_progress_bar3.setProgress(10);
//            ryba3ImageView.animate().alpha(0).setDuration(1000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
//                @Override
//                public void run() {
//                    ryba3ImageView.animate().alpha(1).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();
//
//                }
//            }).start();
//        }
//
//
//
//    }

    //WIELKI PROBLEM HERE ------------------ WYLACZA APKE ALE WSKRZESZA RYBE? (BEZ UZUPELNIANIA PASKA)
//Ustawianie hp po wskrzeszeniu
    public void ustawienie(){
        final int gethp = getIntent().getExtras().getInt("hp");
        vertical_progress_bar1.setVisibility(View.VISIBLE);
        vertical_progress_bar1.setProgress(gethp);
    }


    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

//Obsluga menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.wskrzeszanie){
            Intent intent = new Intent(getApplicationContext(), lowisko.class);
            startActivity(intent);
            return true;
        }
        return false;
    }



}
