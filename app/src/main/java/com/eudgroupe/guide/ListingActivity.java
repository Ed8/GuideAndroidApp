package com.eudgroupe.guide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.eudgroupe.guide.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class ListingActivity extends AppCompatActivity {

    private TextView textView;
    private GridView gridView;

    private LinearLayout item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        textView = (TextView)findViewById(R.id.textViewTitle);
        gridView = (GridView)findViewById(R.id.gridViewData);

        item = (LinearLayout) findViewById(R.id.idItem);



        if(getIntent().getExtras() != null)     //verifier si un titre à ete transmis
        {
            //afficher le bon titre
            String myTitle = getIntent().getExtras().getString(Constant.INTENT_TITLE);
            textView.setText(myTitle);

            //afficher la liste

            boolean isHotel = getIntent().getExtras().getBoolean(Constant.INTENT_IS_HOTEL);

            if( !isHotel)
            {
                final List<Restaurant> mesRestaurants = new ArrayList<>();
                mesRestaurants.add(new Restaurant("Mac Do", "Fast food", "info@mcdo.fr","0123456789", "https://www.mcdonalds.fr/","https://ws.mcdonalds.fr/media/2d/48/0b/2d480b3bdc2ee08b3894e48ed119c756e32316d5"));
                mesRestaurants.add(new Restaurant("Quick", "Fast food", "info@quick.fr","0186456789", "https://www.quick.fr/","http://www.enseignesrichier.com/site/images/normal/Nos-realisations542d096ad9aa0.jpg"));
                mesRestaurants.add(new Restaurant("Burger King", "Fast food", "info@burgerking.fr","0186456789", "https://www.burgerking.fr/","http://www.franchise-restauration.fr/images/zoom/ouvrir-restaurant-burger-king.jpg"));
                mesRestaurants.add(new Restaurant("La Crémaillere", "Gastronomique", "info@cremaillere.fr","0186456789", "http://paris.fr","https://media-cdn.tripadvisor.com/media/photo-s/06/21/47/89/la-cremaillere.jpg"));
                mesRestaurants.add(new Restaurant("Le Paris", "Gastronomique", "info@leparis.fr","0186456789", "http://paris.fr","https://media-cdn.tripadvisor.com/media/photo-s/06/21/47/89/la-cremaillere.jpg"));

                gridView.setAdapter(new RestaurantAdapter(ListingActivity.this,R.layout.item_restaurant, mesRestaurants ));
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //TODO : lancer l'activité DetailsActivity et envoyer l'objet Restaurant
                        Intent myIntent = new Intent(ListingActivity.this, DetailsActivity.class);

                        Bundle myBundle = new Bundle(); // instance du Bundle
                        // objet Restaurant
                        myBundle.putSerializable(Constant.INTENT_OBJET_RESTAURANT, mesRestaurants.get(position));
                        myIntent.putExtras(myBundle);

                        startActivity(myIntent);
                    }
                });
            } else {

            }
        }
    }
}
