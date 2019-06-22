package com.demo.qvcreplicate.Components;

import android.app.Activity;

import com.demo.qvcreplicate.Adapters.PromoAdapter;
import com.demo.qvcreplicate.Adapters.SlideAdapter;
import com.demo.qvcreplicate.Item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    List<Item> itemList;
    Activity activity;
    String string;

    public HomeModule(String s, Activity activity){
        this.string = s;
        this.activity = activity;
        prepData(string);
    }

    void prepData(String string){
        try {
            Gson gson = new GsonBuilder()
                    .create();
            JSONArray array = new JSONArray(string);
            itemList = new ArrayList<>();
            for(int i = 0; i < array.length(); i++){
                Item item = gson.fromJson(array.getString(i), Item.class);
                itemList.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Provides
    List<Item> mprovidesItemList(){
        return itemList;
    }

    @Provides
    SlideAdapter mprovideSlideAdapter(){
        return new SlideAdapter(activity, itemList);
    }

    @Provides
    PromoAdapter mprovidePromooAdapter(){
        return new PromoAdapter(activity, itemList);
    }

}
