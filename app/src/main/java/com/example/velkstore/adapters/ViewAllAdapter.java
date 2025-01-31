package com.example.velkstore.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.velkstore.R;
import com.example.velkstore.activities.DetailedActivity;
import com.example.velkstore.models.ViewAllModel;

import java.util.List;

public class ViewAllAdapter extends RecyclerView.Adapter<ViewAllAdapter.ViewHolder> {

    private Context context;
    private List<ViewAllModel> list;

    public ViewAllAdapter(Context context, List<ViewAllModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_all_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewAllModel model = list.get(position);

        Glide.with(context).load(model.getImg_url()).into(holder.imageView);
        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("detail",list.get(position));
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.view_img);
            name = itemView.findViewById(R.id.view_name);
            price = itemView.findViewById(R.id.view_price);
        }
    }
}
