package com.example.android.varad;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Noemi on 12/5/2017.
 */

public class HistoryContentAdapter extends ArrayAdapter<HistoryContent> {
    public HistoryContentAdapter(Context context, ArrayList<HistoryContent>content){
        super(context, 0, content);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.history_activity, parent, false);}

        HistoryContent myHistoryContent = getItem(position);

        TextView textView5 = (TextView)listItemView.findViewById(R.id.textview5);
        textView5.setText(myHistoryContent.getTurId());

        TextView textView6 = (TextView)listItemView.findViewById(R.id.textview6);
        textView6.setText(myHistoryContent.getWebId());
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView6 = (TextView)view.findViewById(R.id.textview6);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://" + textView6.getText()));
                if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                    getContext().startActivity(intent);
                }
            }
        });

        ImageView imageView2 = (ImageView) listItemView.findViewById(R.id.kep);
        imageView2.setImageResource(myHistoryContent.getImageHistoryId());




      return listItemView;
    }
}
