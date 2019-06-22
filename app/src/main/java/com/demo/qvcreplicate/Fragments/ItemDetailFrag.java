package com.demo.qvcreplicate.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.demo.qvcreplicate.HomeViewModel;
import com.demo.qvcreplicate.Item;
import com.demo.qvcreplicate.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public class ItemDetailFrag extends Fragment {

    HomeViewModel viewModel;
    TextView tvItemName, tvItemPrice;
    ImageView ivProduct;
    Spinner spQuantity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.item_detail_frag, container, false);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        return viewGroup;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvItemName = view.findViewById(R.id.tvItemName);
        tvItemPrice = view.findViewById(R.id.itemPrice);
        ivProduct = view.findViewById(R.id.ivProduct);
        spQuantity = view.findViewById(R.id.spQuantity);

        Integer[] quantity = new Integer[]{1,2,3,4,5};
        ArrayAdapter<Integer> quantityArray = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, quantity);
        quantityArray.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spQuantity.setAdapter(quantityArray);

    }

    @Override
    public void onResume() {
        super.onResume();



        if(getArguments().getBoolean("onAir")){
            viewModel.populateList().observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    try {
                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();
                        JSONArray array = new JSONArray(s);
                        Item item = gson.fromJson(array.getString(3), Item.class);

                        tvItemName.setText(item.getItemName());
                        tvItemPrice.setText(String.valueOf(item.getItemSalePrice()));
                        Glide.with(getActivity()).load(item.getItemURL())
                                .centerCrop()
                                .into(ivProduct);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        }


    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
