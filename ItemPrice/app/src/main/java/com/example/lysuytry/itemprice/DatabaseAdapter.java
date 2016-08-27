package com.example.lysuytry.itemprice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Ly Suytry on 8/5/2016.
 */
public class DatabaseAdapter {
    private MyAssetsDatabase db;
    private Context context;
    public DatabaseAdapter(Context c){
        context=c;
        db=new MyAssetsDatabase(context);
    }
    public Context getContext(){return context;}
    public void writeData(String []data){
        SQLiteDatabase InsertDB=db.getWritableDatabase();
        ContentValues recordValue=new ContentValues();
        recordValue.put(DatabaseName.TableName.COL_ItemName,data[0]);
        recordValue.put(DatabaseName.TableName.COL_ItemType,data[1]);
        recordValue.put(DatabaseName.TableName.COL_RetailPrice,data[2]);
        recordValue.put(DatabaseName.TableName.COL_WholesalePrice,data[3]);
        recordValue.put("ItemPicture",data[4]);
        long primaryKey=InsertDB.insert("Item",null,recordValue);
        Toast.makeText(context,"Fuq "+primaryKey,Toast.LENGTH_LONG).show();
        Log.e("PRIMARY KEY : "," "+primaryKey);
    }
    public Cursor readData(String sql,String arg[]){
        Cursor c=db.getReadableDatabase().rawQuery(sql,arg);
        c.moveToFirst();
        return c;
    }
}
