package com.example.m.ismayilov.book;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Calendar;


public class personal_data_edit_fragment extends Fragment {


    ImageView personal_date_exit_image ,personal_data_edit_image ;
    BottomNavigationView bottomNavigationView;
    TextView personal_data_date_edit;
    DatePickerDialog.OnDateSetListener dateSetListener;
    Calendar calendar;
     InputStream imageStream;
    String date;
    Bitmap bmp;
    int day, moth, year;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_personal_data_edit_fragment, container, false);

//        bottomNavigationView = v.findViewById(R.id.bottom_navigationview);
//        bottomNavigationView.setVisibility(View.INVISIBLE);

        personal_date_exit_image= v.findViewById(R.id.personal_data_exit_image);
        personal_data_date_edit = v.findViewById(R.id.personal_data_date_edit);
        personal_data_edit_image = v.findViewById(R.id.edit_image);


        personal_data_edit_image.setOnClickListener(view -> {

            Intent i = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, 100);

        });


        personal_date_exit_image.setOnClickListener(view -> {
          //  bottomNavigationView.setVisibility(View.VISIBLE);
            Navigation.findNavController(view ).navigate(R.id.navhost_personaldata_to_profile);
        });

        personal_data_date_edit.setOnClickListener(view -> {
            calendar = Calendar.getInstance();
            int end_year = calendar.get(Calendar.YEAR);
            int  end_mont = calendar.get(Calendar.MONTH);
            int end_day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext() , android.R.style.Theme_DeviceDefault_Dialog, dateSetListener , end_year,end_mont,end_day);
            datePickerDialog.show();
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                date =day + "-" + month + "-" + year;
                personal_data_date_edit.setText(date);
//                bool_enddate = true;
//                System.out.println("end");
//                if(bool_enddate && bool_startdate){
//                    all = false;
//                    get_data_sellect();
//                }
//
//                try {
//                    time_end = simple_timeformat.parse(end_date);
//                }catch (Exception e){
//
//                }
//                System.out.println(time_end.getTime());
//                //   System.out.println(Math.abs(time_end.getTime() - time_start_convert.getTime()));
            }
        };


        return v;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final Uri imageUri = data.getData();

        try {
            imageStream = getActivity().getContentResolver().openInputStream(imageUri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
        personal_data_edit_image.setImageBitmap(selectedImage);

    }
}