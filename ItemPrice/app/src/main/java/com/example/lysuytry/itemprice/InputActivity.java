package com.example.lysuytry.itemprice;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by Ly Suytry on 8/3/2016.
 */
public class InputActivity extends AppCompatActivity {
    public EditText ed1,ed2,ed3,ed4;
    public Button btSave;
    private ImageView btPicture;
    private Uri u;
    private static final int SELECT_PICTURE = 1;
    private String selectedImagePath="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputitem);
        ActionBar ac=getSupportActionBar();
        ac.setDisplayHomeAsUpEnabled(true);
        //final SQLiteOpenHelper db=new MyDatabaseHelper(getApplicationContext());
        //final MyAssetsDatabase db=new MyAssetsDatabase(getApplicationContext());
        final DatabaseAdapter dbAdapter=new DatabaseAdapter(getApplicationContext());
        ed1=(EditText)findViewById(R.id.editName);
        ed2=(EditText)findViewById(R.id.editType);
        ed3=(EditText)findViewById(R.id.editRetail);
        ed4=(EditText)findViewById(R.id.editWholesale);
        btSave=(Button)findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] data={ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString(),
                        ed4.getText().toString(),u.toString()};
                if(data[0].compareTo("")==0 || data[1].compareTo("")==0
                        || data[2].compareTo("")==0 || data[3].compareTo("")==0)
                    Snackbar.make(view, "Input All of the data !!! ", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                else
                   dbAdapter.writeData(data);
            }
        });
        Button btCancel=(Button)findViewById(R.id.btCancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
            }
        });
        btPicture=(ImageView)findViewById(R.id.imgSelected);
        //RoundedBitmapDrawable drawable= RoundedBitmapDrawableFactory.create();
        //drawable.setCircular(true);
        btPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,
                        "Select Picture"), SELECT_PICTURE);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                u=selectedImageUri;
                selectedImagePath = getPath(selectedImageUri);
                Picasso.with(this).load(u).into(btPicture);
                //Toast.makeText(getApplicationContext(),""+selectedImagePath,Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * helper to retrieve the path of an image URI
     */
    public String getPath(Uri uri) {
        // just some safety built in
        if( uri == null ) {
            // TODO perform some logging or show user feedback
            return null;
        }
        // try to retrieve the image from the media store first
        // this will only work for images selected from gallery
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if( cursor != null ){
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        // this is our fallback here
        return uri.getPath();
    }

}
