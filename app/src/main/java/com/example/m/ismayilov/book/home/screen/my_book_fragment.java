package com.example.m.ismayilov.book.home.screen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.m.ismayilov.book.R;

import java.util.ArrayList;


public class my_book_fragment extends Fragment {

    ArrayList<String> book_name = new ArrayList<>();
    ArrayList<Bitmap> image  = new ArrayList<>();
    ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_my_book_fragment, container, false);

        listView= v.findViewById(R.id.my_book_listview);

        book_name.add("olume fisildayan admam");
        book_name.add("seker ortakali");
        book_name.add("karabasan");
        book_name.add("vulf dorn");

        Bitmap m11 = BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.m1);
        Bitmap m44 = BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.m4);
        Bitmap m33 = BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.m3);
        Bitmap m66 = BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.m6);

        image.add(m11);
        image.add(m44);
        image.add(m33);
        image.add(m66);

        my_book_adapter my_book_adapter = new my_book_adapter(getActivity() , book_name , image);
        listView.setAdapter(my_book_adapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
//            my_book_adapter.lottieAnimationViewArrayList.get(i).setMinAndMaxProgress(0F,1F);
           // my_book_adapter.lottieAnimationViewArrayList.get(i).playAnimation();

        });





        return v;
    }
}