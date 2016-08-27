package com.example.lysuytry.itemprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ScrollingActivity extends AppCompatActivity {
    TextView txtName,txtRvalue,txtWvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout c=(CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        Intent in=getIntent();
        //ac.setDisplayHomeAsUpEnabled(true);
        txtName=(TextView)findViewById(R.id.txtHead);
        txtRvalue=(TextView)findViewById(R.id.retailValue);
        txtWvalue=(TextView)findViewById(R.id.wholeValue);
        String name,retail,whole;
        name=in.getStringExtra("name");
        retail=in.getStringExtra("retail");
        whole=in.getStringExtra("whole");
        c.setTitle(name);
        txtName.setText(name);
        txtRvalue.setText(retail);
        txtWvalue.setText(whole);
    }
}
