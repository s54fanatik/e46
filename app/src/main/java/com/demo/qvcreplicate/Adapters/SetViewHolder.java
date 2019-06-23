package com.demo.qvcreplicate.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.qvcreplicate.R;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class SetViewHolder extends RecyclerView.ViewHolder {

    public TextView tvProductNameSlide, tvPreviousPriceSlide, tvSalePriceSlide, tvProductNamePromo, tvProductPricePromo, tvProductDescriptionPromo;
    public ImageView ivProductSlideShow, ivProductPromo;

    public SetViewHolder(@NonNull View itemView) {
        super(itemView);

        //slideshow_card_item
        tvProductNameSlide = itemView.findViewById(R.id.tvProductName);
        tvPreviousPriceSlide = itemView.findViewById(R.id.tvPreviousPrice);
        tvSalePriceSlide = itemView.findViewById(R.id.tvSalePrice);
        ivProductSlideShow = itemView.findViewById(R.id.ivProduct);

        //promo_ad
        tvProductNamePromo = itemView.findViewById(R.id.tvProductName);
        tvProductDescriptionPromo = itemView.findViewById(R.id.tvProductDescription);
        tvProductPricePromo = itemView.findViewById(R.id.tvPrice);
        ivProductPromo = itemView.findViewById(R.id.ivProduct);

    }
}
