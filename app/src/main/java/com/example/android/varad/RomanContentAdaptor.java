package com.example.android.varad;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Noemi on 12/8/2017.
 */

public class RomanContentAdaptor extends ArrayAdapter<RomanContent>{

    public RomanContentAdaptor(Context context, ArrayList<RomanContent>content){
        super(context, 0, content);
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.roman_activity, parent, false);
        }

        RomanContent myContent = getItem(position);

        TextView textView7 = (TextView)listItemView.findViewById(R.id.textview7);
        textView7.setText(myContent.getRomanId());

        TextView textView8 = (TextView)listItemView.findViewById(R.id.textview8);
        textView8.setText(myContent.getEnglishId());


        return listItemView;
    }
}
