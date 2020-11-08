package com.training.mydata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rvMediaSosial;
    private ArrayList<mediaSosial> list = new ArrayList<>();
    private myAdapter.OnItemClickCallback listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView btnAbtMe = findViewById(R.id.btnAbtMe);
        btnAbtMe.setOnClickListener(this);

        rvMediaSosial = findViewById(R.id.rvSosial);
        rvMediaSosial.setHasFixedSize(true);

        list.addAll(media.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvMediaSosial.setLayoutManager(new LinearLayoutManager(this));

        setOnClickListener();
        myAdapter myAdapter = new myAdapter(list, listener);
        rvMediaSosial.setAdapter(myAdapter);

        setOnClickListener();
    }

    private void setOnClickListener() {
        listener = new myAdapter.OnItemClickCallback() {
            @Override
            public void onClick(View v, int position) {
                Intent moveWithData = new Intent(getApplicationContext(), DetailActivity.class);

                moveWithData.putExtra("title", list.get(position).getTitle());
                moveWithData.putExtra("description", list.get(position).getDescription());
                moveWithData.putExtra("myImage", list.get(position).getImage());

                startActivity(moveWithData);
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAbtMe:
                Intent moveIntent = new Intent(MainActivity.this, AboutMe.class);
                startActivity(moveIntent);

                break;
        }
    }
}