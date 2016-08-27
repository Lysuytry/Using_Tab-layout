package com.example.lysuytry.itemprice;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeverageFragment extends Fragment {
    public BeverageFragment() {
        // Required empty public constructor
    }
    private String whereArg[]=new String[1];
    private String query="SELECT * FROM Item WHERE ItemType=?";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.list_item,container,false);
        RecyclerView rcvList=(RecyclerView)root.findViewById(R.id.rcvItem);
        DatabaseAdapter dbAdapter=new DatabaseAdapter(getActivity());
        whereArg[0]="1";
        final Cursor cursors=dbAdapter.readData(query,whereArg);
        /*
        ArrayList<Item> l1=new ArrayList<>();
        l1.add(new Item(1,"coca"));
        l1.add(new Item(2,"bbbb"));
        l1.add(new Item(3,"fffff"));
        l1.add(new Item(4,"vvvvv"));
        l1.add(new Item(5,"lllll"));
        ItemAdapter adapter=new ItemAdapter(getActivity(),l1);
        */
        ItemAdapter adapter=new ItemAdapter(getActivity(),cursors);
        //cursors.close();
        rcvList.setHasFixedSize(true);
        adapter.setClickLayout(new onClickItem() {
            @Override
            public void onLayoutClick(int position) {
                cursors.moveToFirst();
                cursors.moveToPosition(position);

                Intent in=new Intent(getActivity(),ScrollingActivity.class);
                in.putExtra("name",cursors.getString(1));
                in.putExtra("retail",cursors.getString(3));
                in.putExtra("whole",cursors.getString(4));
                startActivity(in);
            }
        });
        rcvList.setAdapter(adapter);
        rcvList.setItemAnimator(new DefaultItemAnimator());
        rcvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
