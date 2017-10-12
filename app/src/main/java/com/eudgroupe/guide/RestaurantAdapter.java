package com.eudgroupe.guide;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.eudgroupe.guide.models.Restaurant;

import org.w3c.dom.Text;

import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    LayoutInflater inflater; //permet de gerer l'affichage du layout item_restaurant
    int layout;

    public RestaurantAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Restaurant> objects) {
        super(context, resource, objects);

        inflater = LayoutInflater.from(context); //initialiser l'inflater
        layout = resource; //layout = R.layout.item_restaurant
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //afficher R.Layout.item_restaurant
        convertView = inflater.inflate(layout, null); //remplacement du convertView par le layout item_restaurant

        //récupération des éléments (titre et catégorie)
        TextView textViewTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
        TextView textViewCategorie = (TextView) convertView.findViewById(R.id.textViewCategorie);

        //affichage des données
        Restaurant resto = getItem(position);

        textViewTitle.setText(resto.getNom());
        textViewCategorie.setText(resto.getCategory());

        return convertView;
    }
}
