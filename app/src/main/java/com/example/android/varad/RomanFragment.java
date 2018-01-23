package com.example.android.varad;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Noemi on 12/8/2017.
 */

public class RomanFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
          releaseMediaPlayer();
        }
    };

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if(i == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            }
            else if (i == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };

    public RomanFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  @Nullable ViewGroup container,  Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.generel_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

       final ArrayList<RomanContent>contents = new ArrayList<RomanContent>();

        contents.add(new RomanContent("Unde este cea mai apropiata sectie de politie?", "Where is the nearest police station?", R.raw.politie));
        contents.add(new RomanContent("Este scumpa calatoria cu tramvaiul in acest oras?", "Is it expensive to travel by tram in this town?", R.raw.tramvai));
        contents.add(new RomanContent("Aveti farmacie non-stop in acest oras?", "Excuse me! Do you have a non-stop pharmacy in this town?", R.raw.farmacie));
        contents.add(new RomanContent("Cum pot sa ajung la aeroport?", "How can I get to the airport?", R.raw.aeroport));
        contents.add(new RomanContent("Cum pot sa ajung la spital?", "How can I get to the hospital", R.raw.spital));
        contents.add(new RomanContent("Va rog sa-mi chemati un taxi!", "PLease, call me a taxi as soon as posible!", R.raw.taxi));
        contents.add(new RomanContent("Scuzati-ma! Bacsisul este inclus in nota de plata?", "Excuse me! Is it the tip on the bill?", R.raw.bacsis));

        RomanContentAdaptor adapter = new RomanContentAdaptor(getActivity(), contents);

        ListView listView = rootView.findViewById(R.id.general_item);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();

                RomanContent myContent = contents.get(position);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){

                    mMediaPlayer = MediaPlayer.create(getActivity(), myContent.getAudioId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return rootView;
    }


    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer=null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
