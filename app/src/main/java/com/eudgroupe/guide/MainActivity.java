package com.eudgroupe.guide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**********Passer à l'écran suivant*********************/
        timer = new Timer(); //instance

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // lancement de homeActivity
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);  //declenche louverture de l'ecran
                finish();   //fermer lactivity courante
            }
        },2000);    //au bout des 2 seconde, il va ds le run
        /******************************************************/

    }
}