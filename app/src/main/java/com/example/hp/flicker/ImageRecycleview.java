package com.example.hp.flicker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.flicker.Models.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageRecycleview extends RecyclerView.Adapter<ImageRecycleview.MyViewHolder> {
    List<Photo> photoList;
    public ImageRecycleview(List<Photo> list_photos) {
        this.photoList=list_photos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.imagerow, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        String new_url="https://farm"+photoList.get(i).getFarm()+".staticflickr.com/"+photoList.get(i).getServer()+"/"+photoList.get(i).getId()+"_"+String.valueOf(photoList.get(i).getSecret())+"_z.jpg";

        holder.image_title.setText(photoList.get(i).getTitle());
        holder.dimen.setText("640 X 480");
        Picasso.get()
                .load(new_url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.image);

        //Log.e("title",photoList.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView image_title,dimen;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image_title = (TextView) itemView.findViewById(R.id.image_title);
            dimen = (TextView) itemView.findViewById(R.id.dim);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
