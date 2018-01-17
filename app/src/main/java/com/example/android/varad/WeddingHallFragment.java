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

public class WeddingHallFragment extends Fragment {
    public WeddingHallFragment(){
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.generel_list, container, false);

        ArrayList<Content> content = new ArrayList<Content>();

        content.add(new Content("Castello", "Baile Felix", "0744160945", "www.castello-events.ro",R.drawable.castello ));
        content.add(new Content("Grand'Or Deluxe","Str. Vasile Alecsandi", "0773873632", "www.grandordeluxe.ro", R.drawable.grand));
        content.add(new Content("Hanul Pescarilor", "Saldabagiu de Munte", "0259210045", "www.hanulpescarilor.ro", R.drawable.hanul));
        content.add(new Content("Opera", "Calea Aradului FN", "0721123099", "www.operaevents.ro", R.drawable.opera));
        content.add(new Content("Palazzo", "Ciheiului 67", "0740205282", "www.palazzo-oradea.ro", R.drawable.palazzo));
        content.add(new Content("Ambasador", "Calea Aradului 87", "0741222000", "www.ambasadororadea.ro", R.drawable.ambasador));

        ContentAdapter adapter = new ContentAdapter(getActivity(), content);

        ListView listView = rootView.findViewById(R.id.general_item);

        listView.setAdapter(adapter);

        return  rootView;
    }
}
