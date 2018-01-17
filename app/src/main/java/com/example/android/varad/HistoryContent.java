package com.example.android.varad;

/**
 * Created by Noemi on 12/5/2017.
 */

public class HistoryContent {
    private String mTurId;

    private String mWebId;

    private int mImageHistoryId;

    public HistoryContent(String turId, String webId, int imageHistoryId){
        mTurId = turId;
        mWebId = webId;
        mImageHistoryId = imageHistoryId;
    }

    public String getTurId(){ return mTurId;}

    public String getWebId(){ return  mWebId;}

    public  int getImageHistoryId(){ return  mImageHistoryId;}

}
