package com.example.m.ismayilov.book.splash_creen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.example.m.ismayilov.book.R;
public class splash_screen_open_text_register extends Fragment {

    Button open_text_start_btn;
    LottieAnimationView lottieAnimationView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_splash_screen_open_text_register, container, false);

        open_text_start_btn = v.findViewById(R.id.open_text_start_btn);
        lottieAnimationView = v.findViewById(R.id.open_text_animation);


        open_text_start_btn.setOnClickListener(view -> {
            Navigation.findNavController(view ).navigate(R.id.navigation_opentext_to_about);
        });

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                lottieAnimationView.pauseAnimation();
            }
        };handler.postDelayed(runnable , 2000);


        return v;
    }
}