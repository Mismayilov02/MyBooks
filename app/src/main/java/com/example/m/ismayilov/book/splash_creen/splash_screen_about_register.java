package com.example.m.ismayilov.book.splash_creen;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m.ismayilov.book.R;


public class splash_screen_about_register extends Fragment {

    Button splashscreen_about_next_btn;
    EditText about_register_name_text , about_register_surnmae_text;
    TextView about_to_login;
    CardView about_male_cardview , about_female_carview , about_other_varview;
    String gender = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_splash_screen_about_register, container, false);

        splashscreen_about_next_btn = v.findViewById(R.id.about_register_next_btn);
        about_register_surnmae_text = v.findViewById(R.id.about_register_surnmae_text);
        about_register_name_text = v.findViewById(R.id.about_register_name_text);
        about_to_login = v.findViewById(R.id.about_to_login_textviev);
        about_female_carview = v.findViewById(R.id.about_female_cardview);
        about_male_cardview = v.findViewById(R.id.about_male_cardview);
        about_other_varview = v.findViewById(R.id.about_other_cardview);


        about_male_cardview.setOnClickListener(view -> {
            gender_set("male");
        });

        about_female_carview.setOnClickListener(view -> {
            gender_set("female");
        });

        about_other_varview.setOnClickListener(view -> {
            gender_set("other");
        });




        about_to_login.setOnClickListener(view -> {
            Navigation.findNavController(view ).navigate(R.id.navigation_about_to_login);
        });


        splashscreen_about_next_btn.setOnClickListener(view -> {
            String name , surname;
            name = String.valueOf(about_register_name_text.getText());
            surname = String.valueOf(about_register_name_text.getText());
            if(!name.isEmpty() && !surname.isEmpty() && !gender.isEmpty()) {
                Navigation.findNavController(view).navigate(R.id.navigation_about_to_register);
            }
            else{
                if(name.isEmpty()){
                    about_register_name_text.setHintTextColor(Color.parseColor("#C9D83D3D"));
                    Toast.makeText(getActivity() , "ad bos kalamaz" , Toast.LENGTH_SHORT).show();
                } if(surname.isEmpty()){
                    about_register_surnmae_text.setHintTextColor(Color.parseColor("#C9D83D3D"));
                    Toast.makeText(getActivity() , "soyisim bos kalamaz" , Toast.LENGTH_SHORT).show();
                }if(gender.isEmpty()){
                    Toast.makeText(getActivity() , "lutfen cins secimi yapiniz" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }


    void  gender_set(String gender){
        this.gender =gender;

        switch (gender){
            case "male":
                about_male_cardview.setCardBackgroundColor(Color.parseColor("#6B854D4D"));
                about_other_varview.setCardBackgroundColor(Color.parseColor("#6B4C4C4C"));
                about_female_carview.setCardBackgroundColor(Color.parseColor("#6B4C4C4C"));


                break;

            case "female":
                about_female_carview.setCardBackgroundColor(Color.parseColor("#6B854D4D"));
                about_other_varview.setCardBackgroundColor(Color.parseColor("#6B4C4C4C"));
                about_male_cardview.setCardBackgroundColor(Color.parseColor("#6B4C4C4C"));

                break;

            case "other":
                about_other_varview.setCardBackgroundColor(Color.parseColor("#6B854D4D"));
                about_male_cardview.setCardBackgroundColor(Color.parseColor("#6B4C4C4C"));
                about_female_carview.setCardBackgroundColor(Color.parseColor("#6B4C4C4C"));

                break;
        }

    }
}