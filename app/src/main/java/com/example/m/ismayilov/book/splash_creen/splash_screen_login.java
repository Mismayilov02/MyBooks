package com.example.m.ismayilov.book.splash_creen;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m.ismayilov.book.R;
import com.example.m.ismayilov.book.home.screen.MainActivity;

public class splash_screen_login extends Fragment {

    Dialog dialogsucess;
    TextView login_to_register_textview;
    EditText login_emai_text , login_pasword_text;
    String email , password;
    ImageView imageView;
    boolean eye_bolean = true;
    Button login_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_splash_screen_login, container, false);


        login_btn = v.findViewById(R.id.login_login_btn);
        imageView = v.findViewById(R.id.ilogin_pasword_eye);
        login_to_register_textview = v.findViewById(R.id.login_to_login_textview);
        login_emai_text = v.findViewById(R.id.login_email_text);
        login_pasword_text = v.findViewById(R.id.login_passwor_text);


        login_to_register_textview.setOnClickListener(view -> {
            Navigation.findNavController(view ).navigate(R.id.navigation_login_to_about);
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(eye_bolean){
                    imageView.setImageResource(R.drawable.eye_show);
                    eye_bolean = false;
                    login_pasword_text.setTransformationMethod(null);
                }else
                {
                    imageView.setImageResource(R.drawable.eye_hide);
                    login_pasword_text.setTransformationMethod(new PasswordTransformationMethod());
                    eye_bolean= true;
                }
            }
        });

        login_btn.setOnClickListener(view -> {
            //Toast.makeText(getActivity() , "bu bir demo surumudur!" , Toast.LENGTH_LONG).show();
            email = login_emai_text.getText().toString();
            password = login_pasword_text.getText().toString();

            if(!email.isEmpty() && !password.isEmpty()) {
                get_suces_dialog();
                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        dialogsucess.dismiss();
                        startActivity(new Intent(getActivity(), MainActivity.class));
                    }
                };
                handler.postDelayed(runnable, 2000);
            }else {
                if(email.isEmpty()){
                    login_emai_text.setHintTextColor(Color.parseColor("#C9D83D3D"));
                    Toast.makeText(getActivity() , "lutfen email adresi dahil ediniz" , Toast.LENGTH_SHORT).show();
                }
                if(password.isEmpty()){
                    login_pasword_text.setHintTextColor(Color.parseColor("#C9D83D3D"));
                    Toast.makeText(getActivity() , "lutfen sifreyi dogru yaziniz" , Toast.LENGTH_SHORT).show();
                }
            }
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