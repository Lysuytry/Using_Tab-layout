package com.example.lysuytry.itemprice;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Ly Suytry on 8/5/2016.
 */
public class MyAssetsDatabase extends SQLiteAssetHelper{
    private static final String DATABASE_NAME = "ItemDatabase.db";
    private static final int DATABASE_VERSION = 1;

    public MyAssetsDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
