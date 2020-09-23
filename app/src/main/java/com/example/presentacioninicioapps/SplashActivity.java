package com.example.presentacioninicioapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class SplashActivity extends AppCompatActivity {

    private static int splashTimeOut = 2000;
    public int bandera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences datos1 = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
                bandera = Integer.parseInt(datos1.getString("bandera","0"));

                if (bandera==1){
                    Intent intent = new Intent(SplashActivity.this,InicioPantalla.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(SplashActivity.this,InicioPantalla.class);
                    startActivity(intent);

                    Intent intent2 = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent2);
                }
                finish();
            }
        },splashTimeOut);
    }
}