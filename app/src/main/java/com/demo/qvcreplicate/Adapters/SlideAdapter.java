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

public class SlideAdapter extends RecyclerView.Adapter<SetViewHolder>{

    private Activity activity;
    List<Item> items;

    public SlideAdapter(Activity activity, List<Item> items) {
        this.activity = activity;
        this.items = items;
    }


    @NonNull
    @Override
    public SetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slideshow_card_item, parent, false);
        return new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SetViewHolder holder, int position) {
        holder.tvProductNameSlide.setText(items.get(position).getItemName());
        holder.tvPreviousPriceSlide.setText(String.valueOf(items.get(position).getItemPreviousPrice()));
        holder.tvSalePriceSlide.setText(String.valueOf(items.get(position).getItemSalePrice()));
        Glide.with(activity).load(items.get(position).getItemURL())
                .centerCrop()
                .into(holder.ivProductSlideShow);
    }



    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
