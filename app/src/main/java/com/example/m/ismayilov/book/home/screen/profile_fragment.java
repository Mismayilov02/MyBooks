package com.example.m.ismayilov.book.home.screen;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m.ismayilov.book.R;


public class profile_fragment extends Fragment {

    CardView profile_personaldata_cardview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_profile_fragment, container, false);


        profile_personaldata_cardview= v.findViewById(R.id.profile_personaldate_cardview);

        profile_personaldata_cardview.setOnClickListener(view -> {
            Navigation.findNavController(view ).navigate(R.id.navhost_profile_to_personaldata);
        });



        return v;
    }
}