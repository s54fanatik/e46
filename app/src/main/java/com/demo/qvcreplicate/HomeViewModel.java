package com.demo.qvcreplicate;

import android.app.Application;
import android.content.Context;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class HomeViewModel extends AndroidViewModel {

    private LiveData<String> data;
    private HomeRepository homeRepo;


    public HomeViewModel (Application application){
        super(application);
        homeRepo = new HomeRepository(application);
    }

    public LiveData<String> populateList(){
        data = homeRepo.populateList();
        return data;
    }

}
