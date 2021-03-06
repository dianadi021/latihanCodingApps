package com.training.mydata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    TextView tvTitle, tvDescription;
    Context context;

    String Title, Description;
    int Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.imageDetail);
        tvTitle = findViewById(R.id.heading);
        tvDescription = findViewById(R.id.subHeading);

        ImageView btnAbtMe = findViewById(R.id.btnAbtMe);
        btnAbtMe.setOnClickListener(this);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("title") && getIntent().hasExtra("description")){
            this.Title = getIntent().getStringExtra("title");
            this.Description = getIntent().getStringExtra("description");
            this.Image = getIntent().getIntExtra("myImage", 1);
        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private  void setData(){
        this.tvTitle.setText(this.Title);
        this.tvDescription.setText(this.Description);
        this.imageView.setImageResource(this.Image);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAbtMe:
                Intent moveIntent = new Intent(DetailActivity.this, AboutMe.class);
                startActivity(moveIntent);

                break;
        }
    }
}