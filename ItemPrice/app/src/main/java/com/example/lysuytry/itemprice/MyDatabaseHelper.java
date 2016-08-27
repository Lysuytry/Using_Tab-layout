package com.example.lysuytry.itemprice;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ly Suytry on 8/3/2016.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name="ItemDatabase.db";
    public static final int Database_Version=1;

    private static final String Var_Type1="TEXT";
    private static final String Var_Type2="DOUBLE";
    private static final String Var_Type3="INTEGER";
    private static final String COMMA=",";
    private static final String CREATETABLE_QUERY="CREATE TABLE"+
            DatabaseName.TableName.TABLE_NAME+"("+ DatabaseName.TableName.COL_ItemCode+" INTEGER PRIMARY KEY AUTOINCREMENT "
            + COMMA + DatabaseName.TableName.COL_ItemName + Var_Type1
            + COMMA + DatabaseName.TableName.COL_ItemType + Var_Type3
            + COMMA + DatabaseName.TableName.COL_RetailPrice + Var_Type2
            + COMMA + DatabaseName.TableName.COL_WholesalePrice + Var_Type2
            + ")";
    public MyDatabaseHelper(Context context){
        super(context,Database_Name,null,Database_Version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(CREATETABLE_QUERY);
        }catch (SQLException e){

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

