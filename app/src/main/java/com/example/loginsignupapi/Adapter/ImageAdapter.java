package com.example.loginsignupapi.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginsignupapi.Model.Images;
import com.example.loginsignupapi.R;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.holder> {
ArrayList<Images> imageslist;
Context context;

    public ImageAdapter(ArrayList<Images> imageslist, Context context) {
        this.imageslist = imageslist;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custem_list,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.holder holder, int position) {
        Images imageob=imageslist.get(position);
        holder.name.setText(imageob.getId());
        Glide.with(context).load(imageslist.get(position).getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageslist.size();
    }

    public class holder  extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,email;
        public holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_list);
            email=itemView.findViewById(R.id.email_list);
            imageView=itemView.findViewById(R.id.image_list);
        }
    }
}
