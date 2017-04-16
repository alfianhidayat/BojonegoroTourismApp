package com.usramrizal.bojonegoro_tourism;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by amrizalns on 3/24/17.
 */

public class Fragment_mainContent extends Fragment {
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_dashboard, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.gridView_menu1);
        gridView.setAdapter(new ImageAdapter(view.getContext()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //sMapFragment.getMapAsync(this);

        //------- ViewPager -------
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);



        return view;
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new myTimerTask(), 4000, 6000);
//    }
//
//    public class myTimerTask extends TimerTask {
//
//        @Override
//        public void run() {
//            getActivity().runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    if(viewPager.getCurrentItem() == 0){
//                        viewPager.setCurrentItem(1);
//                    }else if(viewPager.getCurrentItem() == 1){
//                        viewPager.setCurrentItem(2);
//                    }else {
//                        viewPager.setCurrentItem(0);
//                    }
//                }
//            });
//        }
//    }

    public static class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context context){
            mContext = context;
        }

        @Override
        public int getCount() {
            return mImage.length;
        }

        public Object getItem(int position){
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imgV = new ImageView(mContext);
            imgV.setLayoutParams(new GridView.LayoutParams(300, 300));
            imgV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgV.setPadding(5,5,5,5);
            imgV.setImageResource(mImage[position]);
            return imgV;
        }

        Integer[] mImage ={
                R.drawable.img_content1,
                R.drawable.img_content2,
                R.drawable.img_content3
        };

        String[] mText ={
                "Dummy1",
                "Dummy2",
                "Dummy3",
                "Dummy4",
                "Dummy5",
                "Dummy6"
        };

    }


}
