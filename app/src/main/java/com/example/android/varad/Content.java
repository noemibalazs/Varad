package com.example.android.varad;

import android.content.Context;

import java.net.PortUnreachableException;

/**
 * Created by Noemi on 12/5/2017.
 */

public class Content {
    private String mNameId;

    private String mAddressId;

    private String mTelephoneId;

    private String mWebPageId;

    private int mImageIg;

    public Content (String nameId, String addressId, String telephoneId, String webPageId, int imageId){
        mNameId = nameId;
        mAddressId = addressId;
        mTelephoneId = telephoneId;
        mWebPageId = webPageId;
        mImageIg = imageId;
    }

    public String getNameId(){ return  mNameId;}

    public String getAddressId() { return mAddressId;}

    public String getTelephoneId() { return mTelephoneId;}

    public String getWebPageId() { return mWebPageId;}

    public int getImageId() { return mImageIg;}
}
