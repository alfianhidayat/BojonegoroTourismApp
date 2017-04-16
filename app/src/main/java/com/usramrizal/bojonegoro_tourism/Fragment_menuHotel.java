package com.usramrizal.bojonegoro_tourism;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amrizalns on 4/10/17.
 */

public class Fragment_menuHotel extends Fragment {
    private GridLayoutManager lLayout;

    View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_hotel, null);
        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(view.getContext(), 2);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecycleViewAdapter rcAdapter = new RecycleViewAdapter(view.getContext(), rowListItem);
        rView.setAdapter(rcAdapter);
        return view;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Jalan MH. Thamrin No.102","Hotel Ibis", R.drawable.hotel_1));
        allItems.add(new ItemObject("Jalan Sekartaji N0.03-04","Hotel Zest", R.drawable.hotel_2));
        allItems.add(new ItemObject("Jalan Gatot Subroto No.01","Hotel Grand Pullman", R.drawable.hotel_6));
        allItems.add(new ItemObject("Jalan Veteran No.22-24","Hotel Jayakarta", R.drawable.hotel_5));
        allItems.add(new ItemObject("Jalan Pelajar Pejuang No.111","Fave Hotel", R.drawable.hotel_3));
        allItems.add(new ItemObject("Jalan Selat Sunda No.18","Hotel Zodiak", R.drawable.hotel_7));
        allItems.add(new ItemObject("Jalan Soekarno Hatta No.107","Hotel Horison", R.drawable.hotel_4));
        allItems.add(new ItemObject("Jalan Pasir Koja No.79","Hotel Grand Cordela", R.drawable.hotel_8));
        return allItems;
    }
}
