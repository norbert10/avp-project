package com.example.auction_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.auction_app.data.BidItem;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    List<BidItem> modelList;

    public ItemAdapter(List<BidItem> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_row,
                                parent,
                                false)
                , parent.getContext()
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(modelList.get(position));
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView details;
        Button bid;

        public ItemViewHolder(View itemView, Context context) {
            super(itemView);
            imageView = itemView.findViewById(R.id.mImage);
            details = itemView.findViewById(R.id.mText);
            bid = itemView.findViewById(R.id.mButton);
            bid.setOnClickListener(v -> {
                context.startActivity(new Intent(context,Bids.class)
                .putExtra("bid",getAdapterPosition()));
            });
        }

        void bind(BidItem item) {
            imageView.setImageResource(Integer.parseInt(item.getImageUrl()));
            details.setText(
                    String.format("Name:%s\n", item.getStart()) +
                            String.format("Price:%s\n", item.getPrice()) +
                            String.format("Location:%s\n", item.getEnd()) +
                            String.format("Condition:%s", item.getPrice())
            );
        }
    }
}
