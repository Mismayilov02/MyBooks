package com.example.m.ismayilov.book.splash_creen;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m.ismayilov.book.R;
import com.example.m.ismayilov.book.home.screen.MainActivity;

public class splash_screen_login extends Fragment {

    Dialog dialogsucess;
    TextView login_to_register_textview;
    Button login_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_splash_screen_login, container, false);


        login_btn = v.findViewById(R.id.login_login_btn);
        login_to_register_textview = v.findViewById(R.id.login_toregister_textview);


        login_to_register_textview.setOnClickListener(view -> {
            Navigation.findNavController(view ).navigate(R.id.navigation_login_to_register);
        });

        login_btn.setOnClickListener(view -> {
            Toast.makeText(getActivity() , "bu bir demo surumudur!" , Toast.LENGTH_LONG).show();
            get_suces_dialog();
            Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    dialogsucess.dismiss();
                    startActivity(new Intent(getActivity() , MainActivity.class));
                }
            };handler.postDelayed(runnable , 2000);
        });

        return  v;
    }

    void get_suces_dialog(){
        dialogsucess = new Dialog(getActivity());
        dialogsucess.setContentView(R.layout.loginsucees_layout);
        dialogsucess.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogsucess.setCancelable(false);
        dialogsucess.show();
    }
}