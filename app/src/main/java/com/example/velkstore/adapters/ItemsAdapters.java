package com.example.velkstore.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.velkstore.R;
import com.example.velkstore.activities.ViewAllActivity;
import com.example.velkstore.models.ItemsModel;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class ItemsAdapters extends RecyclerView.Adapter<ItemsAdapters.ViewHolder> {

    private Context context;
    private List<ItemsModel> itemsModelsList;

    public ItemsAdapters(Context context, List<ItemsModel> itemsModelsList) {
        this.context = context;
        this.itemsModelsList = itemsModelsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemsModel model = itemsModelsList.get(position);

        Glide.with(context).load(model.getImg_url()).into(holder.popImg);
        holder.name.setText(model.getName());
        holder.rating.setText(model.getRating());
        holder.description.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewAllActivity.class);
                intent.putExtra("type", model.getType()); // Use model.getType() instead of itemsModelsList.get(position).getType()
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsModelsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView popImg;
        TextView name, description, rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            popImg = itemView.findViewById(R.id.pop_img);
            name = itemView.findViewById(R.id.pop_name);
            description = itemView.findViewById(R.id.pop_des);
            rating = itemView.findViewById(R.id.pop_rating);
        }
    }
}
