package com.example.m.ismayilov.book.home.screen;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;
import com.example.m.ismayilov.book.R;

import java.util.ArrayList;

public class my_book_adapter extends ArrayAdapter<String> {


    ArrayList<String> book_name = new ArrayList<>();
    ArrayList<Bitmap> image  =new ArrayList<>();
    ArrayList<LottieAnimationView> lottieAnimationViewArrayList = new ArrayList<>();
    Context context;


    my_book_adapter(Context context , ArrayList<String> book_name , ArrayList<Bitmap> image){
        super(context , R.layout.book_cardview_designer , R.id.design_cardview_name_text , book_name);
        this.book_name  = book_name;
        this.image = image;
        this.context = context;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.book_cardview_designer , null);

        TextView name_text = v.findViewById(R.id.design_cardview_name_text);
        ImageView imageView = v.findViewById(R.id.design_cardview_image);
        LottieAnimationView lottieAnimationView  = v.findViewById(R.id.open_text_animation);
        lottieAnimationView.pauseAnimation();
        lottieAnimationViewArrayList.add(lottieAnimationView);
        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lottieAnimationView.setVisibility(View.INVISIBLE);
                System.out.println(position);
                Toast.makeText(context , "print" , Toast.LENGTH_SHORT).show();
            }
        });

        imageView.setImageBitmap(image.get(position));
        name_text.setText(book_name.get(position));


        return  v;
    }
}
