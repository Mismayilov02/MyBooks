package com.example.m.ismayilov.book.splash_creen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m.ismayilov.book.R;


public class splash_screen_open_fragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_splash_screen_open_fragment, container, false);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Navigation.findNavController(v).navigate(R.id.navigation_slpashcreen_register_hello);

                }catch (Exception e){
                    System.out.println(e);
                }

            }
        };handler.postDelayed(runnable , 3100);


        return v;
    }
}