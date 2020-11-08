package com.training.mydata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ListViewHolder>{
    private ArrayList<mediaSosial> listMediaSosial;
    private OnItemClickCallback listener;

    public myAdapter (ArrayList<mediaSosial> list, OnItemClickCallback listener){
        this.listMediaSosial = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listdata, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        mediaSosial mediaSosial = listMediaSosial.get(position);

        Glide.with(holder.itemView.getContext())
                .load(mediaSosial.getImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        holder.tvTitle.setText(mediaSosial.getTitle());
        holder.tvDescription.setText(mediaSosial.getDescription());
    }

    @Override
    public int getItemCount() {
        return listMediaSosial.size();

    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvTitle, tvDescription;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.imgMediaSosial);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(itemView, getAdapterPosition());
        }
    }

    public interface OnItemClickCallback {
        void onClick(View v, int position);
    }
}
