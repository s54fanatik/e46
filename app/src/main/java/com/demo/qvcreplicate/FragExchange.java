package com.demo.qvcreplicate;

import android.app.Activity;
import android.content.Context;

import com.demo.qvcreplicate.Fragments.HomeFrag;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragExchange extends Fragment{


    public void replace(Fragment fragment){

        ((MainNavigation)getActivity()).replaceFragment(fragment);


    }

}
