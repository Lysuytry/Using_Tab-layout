package com.example.lysuytry.itemprice;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ly Suytry on 7/30/2016.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    onClickItem clickLayout;

    public void setClickLayout(onClickItem clickLayout) {
        this.clickLayout = clickLayout;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName;
        private ImageView imgItem;
        public ViewHolder(View v){
            super(v);

            txtName=(TextView)v.findViewById(R.id.txtIteName);
            imgItem=(ImageView)v.findViewById(R.id.imgItem);
            LinearLayout layout=(LinearLayout) v.findViewById(R.id.layoutItem);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickLayout.onLayoutClick(getLayoutPosition());
                }
            });
        }
    }

    // Store a member variable for the contacts
    private ArrayList<Item> mItems;
    // Store the context for easy access
    private Context mContext;
    private Cursor cursors;
    // Pass in the contact array into the constructor
    public ItemAdapter(Context context,ArrayList<Item> items) {
        mItems = items;
        mContext = context;
    }
    public ItemAdapter(Context context,Cursor cursors) {
        this.cursors= cursors;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }
    String n;
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView txt1=holder.txtName;
        ImageView myImage=holder.imgItem;
        cursors.moveToPosition(position);
        txt1.setText(cursors.getString(1));
        String st=cursors.getString(5);
        try {
            if(!(st.compareTo("")==0))
                Picasso.with(getContext()).load(st).error(R.drawable.a).into(myImage);
        }catch (Exception e){
            Log.e("Error",e+"");
        }
        //Bitmap b= BitmapFactory.decodeFile(cursors.getString(5));
        //img.setImageBitmap(b);
        //Picasso.with(getContext()).load(cursors.getString(5)).resize(70,70).into(img);
        //txt1.setText(mItems.get(position).getItemName());
    }

    @Override
    public int getItemCount() {
        //return mItems.size();
        return cursors.getCount();
    }
}
