package ffscompany.howmanytimes.Activitys;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ffscompany.howmanytimes.R;

public class Splash extends AppCompatActivity {
    ImageView splashImage;
    Button BTNsplashContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(0XD3272750);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        }, 2000);   //5 seconds
    }
}