package com.eudgroupe.guide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.eudgroupe.guide.models.Restaurant;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private ImageView imageViewPhoto;
    private Button buttonEmail;
    private Button buttonPhone;
    private Button buttonSite;
    private TextView textViewTitle;
    private TextView textViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        buttonEmail = (Button) findViewById(R.id.buttonEmail);
        buttonPhone = (Button) findViewById(R.id.buttonPhone);
        buttonSite = (Button) findViewById(R.id.buttonSite);
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textViewCategory = (TextView) findViewById(R.id.textViewCategory);



        if(getIntent().getExtras() != null ) { // on vérifie des données sont dans l'Intent

            Restaurant monRestaurant = (Restaurant) getIntent().getExtras().get(Constant.INTENT_OBJET_RESTAURANT);

            textViewTitle.setText(monRestaurant.getNom());
            textViewCategory.setText(monRestaurant.getCategory());
            buttonEmail.setText(monRestaurant.getEmail());
            buttonPhone.setText(monRestaurant.getPhone());
            buttonSite.setText(monRestaurant.getUrl());
            Picasso.with(DetailsActivity.this).load(monRestaurant.getImage()).into(imageViewPhoto);
        }
    }

    public void sendEmail(View view) {
        Intent intentEmail = new Intent(Intent.ACTION_SEND);
        intentEmail.setType("message/rfc822");
        intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"youremail@yahoo.com"});
        intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intentEmail.putExtra(Intent.EXTRA_TEXT, "Hola !");

        startActivity(Intent.createChooser(intentEmail, "Send Email"));
    }

    public void callPhone(View view) {
        // appel numero tel du restaurant
        Intent intentPhone= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + buttonPhone.getText().toString()));
        startActivity(intentPhone);

        //voir aussi action_call et les permission dangereuses
    }

    public void visitWebsite(View view) {
        // redirection vers l'url du restaurant
        Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(buttonSite.getText().toString()));
        startActivity(intentWebsite);
    }
}
