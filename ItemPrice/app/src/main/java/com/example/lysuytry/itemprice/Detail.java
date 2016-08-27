package com.example.lysuytry.itemprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Ly Suytry on 8/3/2016.
 */
public class Detail extends AppCompatActivity {
    TextView txtName,txtRvalue,txtWvalue;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Intent in=getIntent();
        ActionBar ac=getSupportActionBar();
        ac.setDisplayHomeAsUpEnabled(true);
        txtName=(TextView)findViewById(R.id.txtHead);
        txtRvalue=(TextView)findViewById(R.id.retailValue);
        txtWvalue=(TextView)findViewById(R.id.wholeValue);
        String name,retail,whole;
        name=in.getStringExtra("name");
        retail=in.getStringExtra("retail");
        whole=in.getStringExtra("whole");
        txtName.setText(name);
        txtRvalue.setText(retail);
        txtWvalue.setText(whole);
    }
}
