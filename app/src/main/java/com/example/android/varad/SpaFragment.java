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

public class SpaFragment extends Fragment {

    public SpaFragment(){

    }


    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.generel_list, container, false);

        ArrayList<Content> content = new ArrayList<Content>();

        content.add(new Content( "Aqua Park Nymphea", "Aleea Strandului 13B", "0770366388","www.aquapark-nymphaea.ro", R.drawable.nymphea ));
        content.add(new Content("Lotus Therm", "Str. Victoria 20 - Baile Felix", "0359414474", "www.lotustherm.ro", R.drawable.spathermal));
        content.add(new Content("Strand Apollo", "Str. Victoria 30", "0259318204", "www.bailefelix.net", R.drawable.felix));
        content.add(new Content("Nevis", "Str. Lapusului 2", "0259407970", "www.hotelnevis.ro", R.drawable.nevisspa));

        ContentAdapter adapter = new ContentAdapter(getActivity(), content);

        ListView listView = (ListView)rootView.findViewById(R.id.general_item);

        listView.setAdapter(adapter);


        return rootView;
    }
}
