package com.example.manyacovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    TextView powered,powered2,title;

    Animation bTt,btTwo,imgBounce;

    private int SLEEP_TIMER=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        //hooks
        title=findViewById(R.id.title);
        powered=findViewById(R.id.powered);
        powered2=findViewById(R.id.powered);

        //animations
        bTt= AnimationUtils.loadAnimation(this,R.anim.btttwo);
        btTwo=AnimationUtils.loadAnimation(this,R.anim.btt);
        imgBounce=AnimationUtils.loadAnimation(this,R.anim.imgbounce);


        //set animations on elements
        title.setAnimation(imgBounce);
        powered.setAnimation(imgBounce);
        powered2.setAnimation(imgBounce);


        LogoLauncher logoLauncher= new LogoLauncher();
        logoLauncher.start();
    }


    private class LogoLauncher extends Thread{
        public void run(){
            try{
                sleep(1000*SLEEP_TIMER);
            }catch(InterruptedException e){
                e.printStackTrace();

            }

            Intent intent= new Intent(SplashScreenActivity.this,MainActivity.class);
            startActivity(intent);
            SplashScreenActivity.this.finish();
        }

    }
}
