package com.example.android.miwok;


public class Word {

    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private Integer mImageID= NO_IMAGE;

    private static final int NO_IMAGE = -1;


    public Word(String defaultWord,String miwokWord){
        mMiwokTranslation= miwokWord;
        mDefaultTranslation= defaultWord;
    }

    public Word(String defaultWord, String miwokWord, Integer imageID){
        mMiwokTranslation = miwokWord;
        mDefaultTranslation = defaultWord;
        mImageID= imageID;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public Integer getIconResourseID(){
        return mImageID;
    }

    public boolean hasImage(){
     return mImageID!=NO_IMAGE;
    }
}
