package com.example.velkstore.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.velkstore.R;
import com.example.velkstore.models.ViewAllModel;

public class DetailedActivity extends AppCompatActivity {

    ImageView detailedImg;
    TextView price, description;
    Button order;
    Toolbar toolbar;

    ViewAllModel viewAllModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Object object = getIntent().getSerializableExtra("detail");
        if (object instanceof ViewAllModel) {
            viewAllModel = (ViewAllModel) object;
        }

        detailedImg = findViewById(R.id.detailed_img);
        price = findViewById(R.id.detailed_price);
        description = findViewById(R.id.detailed_dec); // Corrected ID to match XML

        if (viewAllModel != null) {
            Glide.with(this).load(viewAllModel.getImg_url()).into(detailedImg); // Load image using Glide
            description.setText(viewAllModel.getDescription());
            price.setText("Price : Rp " + viewAllModel.getPrice());
        }

        order = findViewById(R.id.order);
    }
}
