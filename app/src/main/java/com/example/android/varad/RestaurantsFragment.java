package com.example.android.varad;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Noemi on 12/5/2017.
 */

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment(){
    }


    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.generel_list, container, false);

        ArrayList<Content> content = new ArrayList<Content>();
        content.add(new Content("Baretti", "Str. Bulevardul Decebal 60", "0771208323", "www.baretti.ro", R.drawable.baretti));
        content.add(new Content("Spoon", "Aleea Emanuil Ghojdu", "0259708989", "www.spoonrestaurant.ro", R.drawable.spoon));
        content.add(new Content("Coquette", "Piata 1 Decembrie 12", "0748228822", "www.grandpalace.ro/coquette/", R.drawable.coquette));
        content.add(new Content("Corsarul", "Piata Ion Creanga 1", "0259449494", "www.restaurantcorsarul.ro", R.drawable.corsarul));
        content.add(new Content("Vinotera","Str. Caii Ferate 9", "0753999900", "www.ristorante-vinotera.ro", R.drawable.vinotera));

        ContentAdapter adapter = new ContentAdapter(getActivity(), content);

        ListView listView = rootView.findViewById(R.id.general_item);

        listView.setAdapter(adapter);

        return rootView;
    }
}
