package com.demo.qvcreplicate;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginException;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class HomeRepository {

    Context context;

    public HomeRepository(Context context){
        this.context = context;
    }


    public LiveData<String> populateList(){
        final MutableLiveData<String> data = new MutableLiveData<>();
        StringRequest srList = new StringRequest(Request.Method.GET, "http://dspumoni.hol.es/QVCReplicate/retrieveItems.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                data.setValue(response);
                Log.i("STATUSCHECK", "onResponse: " +response +"\n data : "+ data.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("STATUSCHECK", "onErrorResponse: " + error);
            }
        });
        VolleyHTTP.getInstance(context).addToRequestQueue(srList);
        return data;
    }

//    public LiveData<String> populateList2(){
//        final MutableLiveData<String> data = new MutableLiveData<>();
//        StringRequest srList = new StringRequest(Request.Method.GET, "http://dspumoni.hol.es/QVCReplicate/retrieveItems.php", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                data.setValue(response);
//                Log.i("STATUSCHECK", "onResponse: " +response +"\n data : "+ data.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.i("STATUSCHECK", "onErrorResponse: " + error);
//            }
//        });
//        VolleyHTTP.getInstance(context).addToRequestQueue(srList);
//        return data;
//    }

}
