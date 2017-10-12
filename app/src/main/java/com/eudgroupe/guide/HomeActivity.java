package com.eudgroupe.guide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    private Button buttonRed, buttonBlue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonRed = (Button) findViewById(R.id.buttonRed);
        buttonBlue = (Button) findViewById(R.id.buttonBlue);

        //ecouteur 1
        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // lancement de ListingActivity
                Intent intent = new Intent(HomeActivity.this, ListingActivity.class);
                intent.putExtra(Constant.INTENT_TITLE, getString(R.string.listing_restaurant_title));
                intent.putExtra(Constant.INTENT_IS_HOTEL, false);
                startActivity(intent);  //declenche louverture de l'ecran

            }
        });

        //ecouteur 2
        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // lancement de ListingActivity
                Intent intent = new Intent(HomeActivity.this, ListingActivity.class);
                intent.putExtra(Constant.INTENT_TITLE, getString(R.string.Listing_hotel_title));
                intent.putExtra(Constant.INTENT_IS_HOTEL, true);
                startActivity(intent);  //declenche louverture de l'ecran
            }
        });
    }
}



