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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m.ismayilov.book.R;
import com.example.m.ismayilov.book.home.screen.MainActivity;


public class Splash_screen_register extends Fragment {

    TextView register_to_login_textview;
    EditText register_email_text , register_password_text , register_confirmpassword_text;
    Dialog dialogsucess;
    Button register_btn;
    ImageView register_to_about_btn;
    String password , confirm_pasword , email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_splash_screen_register, container, false);

        register_to_login_textview = v.findViewById(R.id.login_to_login_textview);
        register_btn = v.findViewById(R.id.register_register_btn);
        register_to_about_btn = v.findViewById(R.id.register_to_about_btn);
        register_confirmpassword_text = v.findViewById(R.id.register_confirmpassword_text);
        register_password_text = v.findViewById(R.id.register_passwor_text);
        register_email_text = v.findViewById(R.id.register_email_text);



        register_to_about_btn.setOnClickListener(view -> {
            Navigation.findNavController(view ).navigate(R.id.navigation_register_to_about);
        });

        register_to_login_textview.setOnClickListener(view -> {
            Navigation.findNavController(view ).navigate(R.id.navigation_register_to_login);

        });

        register_btn.setOnClickListener(view -> {
           // Toast.makeText(getActivity() , "bu bir demo surumudur!" , Toast.LENGTH_LONG).show();
            email = register_email_text.getText().toString();
            password = register_password_text.getText().toString();
            confirm_pasword = register_confirmpassword_text.getText().toString();

            if(!email.isEmpty() && !password.isEmpty() &&  !confirm_pasword.isEmpty()) {
                if(password.equals(confirm_pasword)) {
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
                    Toast.makeText(getActivity() , "sifreler bir-biri ile esit degildir!" , Toast.LENGTH_SHORT).show();
                }
            }else{
                if(password.isEmpty()){
                    register_password_text.setHintTextColor(Color.parseColor("#C9D83D3D"));
                    Toast.makeText(getActivity() , "lutfen sifreyi dogru yazninz" , Toast.LENGTH_SHORT).show();
                }
                if(confirm_pasword.isEmpty()){
                    register_confirmpassword_text.setHintTextColor(Color.parseColor("#C9D83D3D"));
                    Toast.makeText(getActivity() , "lutfen sifrenizi dogru yaziniz" , Toast.LENGTH_SHORT).show();
                }
                if(email.isEmpty()){
                    register_email_text.setHintTextColor(Color.parseColor("#C9D83D3D"));
                    Toast.makeText(getActivity() , "lutfen email adresinizi yaziniz" , Toast.LENGTH_SHORT).show();
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