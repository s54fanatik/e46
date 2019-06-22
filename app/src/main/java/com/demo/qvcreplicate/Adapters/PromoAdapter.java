package com.demo.qvcreplicate.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.demo.qvcreplicate.Item;
import com.demo.qvcreplicate.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PromoAdapter extends RecyclerView.Adapter<SetViewHolder> {

    private Activity activity;
    private List<Item> items;


    public PromoAdapter(Activity activity, List<Item> items) {
        this.activity = activity;
        this.items = items;
    }

    @NonNull
    @Override
    public SetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.promo_ad, parent, false);
        return new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SetViewHolder holder, int position) {
        holder.tvProductNamePromo.setText(items.get(position).getItemName());
        holder.tvProductDescriptionPromo.setText(items.get(position).getItemDescription());
        holder.tvProductPricePromo.setText(String.valueOf(items.get(position).getItemSalePrice()));
        Glide.with(activity)
                .load(items.get(position).getItemURL())
                .centerCrop()
                .into(holder.ivProductPromo);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
