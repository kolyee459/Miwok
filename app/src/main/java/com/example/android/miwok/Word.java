package com.example.android.miwok;

import android.media.MediaPlayer;

public class Word {

    private String mDefaultTranslation = new String();
    private String MiwokTranslation = new String();
    /**
     * Image resource ID for the word
     */
    private int mImageResourceId;
    private int mSoundResourceId;


    Word(String defaultTranslation, String miwokTranslation,int soundResourceId) {
        this.mDefaultTranslation = defaultTranslation;
        this.MiwokTranslation = miwokTranslation;
        this.mSoundResourceId = soundResourceId;

    }

    Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int soundResourceId) {
        this.mDefaultTranslation = defaultTranslation;
        this.MiwokTranslation = miwokTranslation;
        this.mImageResourceId = imageResourceId;
        this.mSoundResourceId = soundResourceId;



    }


    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return MiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getSoundResourceId() {
        return mSoundResourceId;
    }

    public boolean hasValidImage() {
        if (mImageResourceId != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", MiwokTranslation='" + MiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mSoundResourceId=" + mSoundResourceId +
                '}';
    }
}
