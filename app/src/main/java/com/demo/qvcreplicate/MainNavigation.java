package com.demo.qvcreplicate;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.SigningInfo;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.VideoView;

import com.demo.qvcreplicate.Fragments.HomeFrag;
import com.demo.qvcreplicate.Fragments.SignInFrag;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainNavigation extends AppCompatActivity {

    public static final String  TAG= "STATUSCHECK";

    private DrawerLayout mainDrawer;
    private NavigationView navigationView;
    private Toolbar toolBar;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ExpandableListView expandableListView;
    ExpandableListAdapter adapter;
    List<String> listHeaders;
    HashMap<String, List<String>> listChildren;

    List<Fragment> navIntents;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);

        //initialize views
        mainDrawer = findViewById(R.id.mainDrawer);
        navigationView = findViewById(R.id.navigationView);
        toolBar = findViewById(R.id.toolBar);
        expandableListView = findViewById(R.id.expandableList);

        setupLayout();

        prepareMenuList();

        expandableListView.setOnChildClickListener( new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                Toast.makeText(MainNavigation.this, "Child Clicked :" + i+", "+i1, Toast.LENGTH_SHORT).show();



                return false;
            }
        });
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Toast.makeText(MainNavigation.this, "Group Clicked :" +i , Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        HomeFrag homeFrag = new HomeFrag();
        fragmentTransaction.add(R.id.frag_container, homeFrag);
        fragmentTransaction.commit();

    }

    public void setupNavDrawer(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Log.i(TAG, "onNavigationItemSelected: ");
                menuItem.setChecked(true);
                mainDrawer.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                return true;
            case R.id.live_video:
                return true;
            case R.id.cart:
                return true;
            case android.R.id.home:
                mainDrawer.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void prepareMenuList(){

        navIntents = new ArrayList<>();
        listHeaders = new ArrayList<>();
        listChildren = new HashMap<>();


        listHeaders.add("Welcome Guest");
        listHeaders.add("Categories");
        listHeaders.add("More");
        listHeaders.add("Legal");

        List<String> Heading1 = new ArrayList<>();
        Heading1.add("Sign In");
        SignInFrag signInFrag = new SignInFrag();
        navIntents.add(0, signInFrag);
        Heading1.add("Home");
        Heading1.add("My Account");
        Heading1.add("Program Guide");
        Heading1.add("QCard");

        List<String> Heading2 = new ArrayList<>();
        Heading2.add("Fashion");
        Heading2.add("Shoes");
        Heading2.add("Jewelery");
        Heading2.add("Beauty");
        Heading2.add("Electronics");
        Heading2.add("For the Home");
        Heading2.add("Garden Center");
        Heading2.add("Health and Fitness");
        Heading2.add("Kitchen and Food");
        Heading2.add("Health and Fitness");
        Heading2.add("Clearance");
        Heading2.add("Men's");
        Heading2.add("Top Brands");
        Heading2.add("Gifts and Holidays");

        List<String> Heading3 = new ArrayList<>();
        Heading3.add("Manage Reminders");
        Heading3.add("Video Settings");
        Heading3.add("Help");
        Heading3.add("Contact QVC");
        Heading3.add("Feedback");

        List<String> Heading4 = new ArrayList<>();
        Heading4.add("General Terms of Use");
        Heading4.add("Privacy Statement");
        Heading4.add("Online Closed Captioning");


        listChildren.put(listHeaders.get(0), Heading1);
        listChildren.put(listHeaders.get(1), Heading2);
        listChildren.put(listHeaders.get(2), Heading3);
        listChildren.put(listHeaders.get(3), Heading4);

        adapter = new MyExpandableListAdapter(this, listHeaders, listChildren, expandableListView);
        expandableListView.setAdapter(adapter);

    }


    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_container, fragment);
        fragmentTransaction.commit();
    }

    public void setupLayout(){
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Home");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        setupNavDrawer();
    }
}
