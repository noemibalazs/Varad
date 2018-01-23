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

public class HotelsFragment extends Fragment {
    public HotelsFragment() {
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.generel_list, container, false);

        ArrayList<Content> content = new ArrayList<Content>();

        content.add(new Content("Ramada", "Calea Aradului 9", "0359403333", "www.ramadaoradea.ro",R.drawable.ramada));
        content.add(new Content("Hilton Double Tree", "Aleea Strandului 9", "0259259259", "www.hiltonhotels.com", R.drawable.hilton));
        content.add(new Content("Lotus Therm", "Str. Victoria 20 - Baile Felix", "0359414474","www.lotustherm.ro", R.drawable.lotus_therm));
        content.add(new Content("Astoria", "Str. Teatrului 1 - 2", "0259430508", "www.astoriaoradea.ro", R.drawable.astoria));

        ContentAdapter adapter = new ContentAdapter(getActivity(), content);

        ListView listView = rootView.findViewById(R.id.general_item);

        listView.setAdapter(adapter);

        return rootView;
    }
}
