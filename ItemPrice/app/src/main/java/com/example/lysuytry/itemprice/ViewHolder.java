package com.example.lysuytry.itemprice;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Ly Suytry on 7/30/2016.
 */
public class ViewHolder extends RecyclerView.ViewHolder{
    TextView txtName;
    public ViewHolder(View v){
        super(v);
        txtName=(TextView)v.findViewById(R.id.txtIteName);
    }
}
