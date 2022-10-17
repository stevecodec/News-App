package com.example.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHandler> {

    Context context ;
    ArrayList<ModelClass> modelClassArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHandler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHandler holder, @SuppressLint("RecyclerView") int position) {


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,Webview.class);
                intent.putExtra("url",modelClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });


        holder.mtime.setText("Published At" + modelClassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.mheading.setText(modelClassArrayList.get(position).getTitle());
        holder.mcontent.setText(modelClassArrayList.get(position).getDescription());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHandler extends RecyclerView.ViewHolder {

        TextView mheading,mcontent,mtime,mauthor;
        CardView cardView;
        ImageView imageView;

        public ViewHandler(@NonNull View itemView) {
            super(itemView);

        mheading =itemView.findViewById(R.id.mainheading);
        mcontent =itemView.findViewById(R.id.content);
        mauthor =itemView.findViewById(R.id.author);
        mtime =itemView.findViewById(R.id.time);
        cardView =itemView.findViewById(R.id.cardview);
        imageView =itemView.findViewById(R.id.imageview);


        }
    }
}
