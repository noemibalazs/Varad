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

public class HistoryFragment extends Fragment {
    public HistoryFragment(){
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,  Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.generel_list, container, false);

        ArrayList<HistoryContent> content = new ArrayList<HistoryContent>();

        content.add(new HistoryContent(getString(R.string.tour_virtual), "www.youtube.com/watch?v=1hGtHkG79Y4", R.drawable.turvirtual));
        content.add(new HistoryContent(getString(R.string.city_center), "www.youtube.com/watch?v=0WoQduq0WjE", R.drawable.kozpont));
        content.add(new HistoryContent(getString(R.string.black_eagle_palace), "www.youtube.com/watch?v=uu-r4VfNJ6Y", R.drawable.sas));
        content.add(new HistoryContent(getString(R.string.fortress), "www.youtube.com/watch?v=tifkm7nnPJE", R.drawable.var));
        content.add(new HistoryContent(getString(R.string.mushroom), "www.youtube.com/watch?v=K_b_uVAB4KU", R.drawable.gomba));
        content.add(new HistoryContent( getString(R.string.lotus_center), "www.youtube.com/watch?v=fKnNiD9FAEc", R.drawable.lotus));

        HistoryContentAdapter adapter = new HistoryContentAdapter(getActivity(), content);

        ListView listView = rootView.findViewById(R.id.general_item);

        listView.setAdapter(adapter);

        return rootView;
    }
}
