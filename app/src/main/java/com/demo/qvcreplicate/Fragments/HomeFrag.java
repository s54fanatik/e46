package com.demo.qvcreplicate.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.demo.qvcreplicate.Adapters.PromoAdapter;
import com.demo.qvcreplicate.Adapters.SlideAdapter;
import com.demo.qvcreplicate.Components.DaggerHomeComponent;
import com.demo.qvcreplicate.Components.HomeComponent;
import com.demo.qvcreplicate.Components.HomeModule;
import com.demo.qvcreplicate.HomeViewModel;
import com.demo.qvcreplicate.Item;
import com.demo.qvcreplicate.MainNavigation;
import com.demo.qvcreplicate.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

public class HomeFrag extends Fragment implements View.OnClickListener {
    @Inject
    public SlideAdapter slideAdapter;
    @Inject
    public PromoAdapter promoAdapter;
    @Inject
    public List<Item>itemList;

    private BottomSheetBehavior bottomSheetBehavior;
    private VideoView vvLive;
    private HomeViewModel viewModel;
    private TextView tvPNamePromoAd1, tvPPricePromoAd1, tvPDescriptionPromoAd1, tvPNamePromoAd2, tvPPricePromoAd2, tvPDescriptionPromoAd2, tvHeaderCS1, tvSubCS1, tvHeaderCS2, tvSubCS2,
            tvHeaderCS3, tvSubCS3, tvHeaderCS4, tvSubCS4, tvHeaderPS1,tvHeaderPS2,tvHeaderPS3;
    private ImageView ivProductPromoAd1, ivProductPromoAd2, ivProductTest;
    public RecyclerView rvSlide1, rvSlide2, rvSlide3, rvSlide4, rvPromo1, rvPromo2, rvPromo3, rvTest, rvTest2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.home_frag, container, false);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        return viewGroup;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initialize views
        View bottomSheet = view.findViewById(R.id.bottomSheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);

        vvLive = view.findViewById(R.id.vvLive);

        CardView cvSlide1 = view.findViewById(R.id.slide_show1);
        CardView cvSlide2 = view.findViewById(R.id.slide_show2);
        CardView cvSlide3 = view.findViewById(R.id.slide_show3);
        CardView cvSlide4 = view.findViewById(R.id.slide_show4);
        CardView cvPromoSlide1 = view.findViewById(R.id.promo_slide1);
        CardView cvPromoSlide2 = view.findViewById(R.id.promo_slide2);
        CardView cvPromoSlide3 = view.findViewById(R.id.promo_slide3);
        CardView cvPromoAd1 = view.findViewById(R.id.promo_ad1);
        CardView cvPromoAd2 = view.findViewById(R.id.promo_ad2);
        CardView cvPromoAd3 = view.findViewById(R.id.promo_ad3);
        CardView introCategory = view.findViewById(R.id.intro_category);

        Button btTodaysSPecial = introCategory.findViewById(R.id.btTodaysSpecialValue);
        Button btItemOnAir = introCategory.findViewById(R.id.btItemOnAir);
        Button btTopDeals = introCategory.findViewById(R.id.btTopDeals);
        Button btHotPicks = introCategory.findViewById(R.id.btHotPicks);
        Button btNewArrivals = introCategory.findViewById(R.id.btNewArrivals);
        Button btClearance = introCategory.findViewById(R.id.btClearance);
        btItemOnAir.setOnClickListener(this);

//        rvSlide1 = cvSlide1.findViewById(R.id.rvItems);
        rvSlide1 = view.findViewById(R.id.rvItemsTest);
        rvSlide2 = cvSlide2.findViewById(R.id.rvItems);
        rvSlide3 = cvSlide3.findViewById(R.id.rvItems);
        rvSlide4 = cvSlide4.findViewById(R.id.rvItems);

//        rvPromo1 = cvPromoSlide1.findViewById(R.id.rvItems);
        rvPromo1 = view.findViewById(R.id.rvItemsTest2);
        rvPromo2= cvPromoSlide2.findViewById(R.id.rvItems);
        rvPromo3 = cvPromoSlide3.findViewById(R.id.rvItems);

        tvPNamePromoAd1 = cvPromoAd1.findViewById(R.id.tvProductName);
        tvPPricePromoAd1 = cvPromoAd1.findViewById(R.id.tvPrice);
        ivProductPromoAd1 = cvPromoAd1.findViewById(R.id.ivProduct);
        tvPDescriptionPromoAd1 = cvPromoAd1.findViewById(R.id.tvProductDescription);
        tvPNamePromoAd2 = cvPromoAd2.findViewById(R.id.tvProductName);
        tvPPricePromoAd2 = cvPromoAd2.findViewById(R.id.tvPrice);
        ivProductPromoAd2 = cvPromoAd2.findViewById(R.id.ivProduct);
        tvPDescriptionPromoAd2 = cvPromoAd2.findViewById(R.id.tvProductDescription);

        tvHeaderCS1 = cvSlide1.findViewById(R.id.hdMain);
        tvSubCS1 = cvSlide1.findViewById(R.id.hdSub);
        tvHeaderCS2 = cvSlide2.findViewById(R.id.hdMain);
        tvSubCS2 = cvSlide2.findViewById(R.id.hdSub);
        tvHeaderCS3 = cvSlide3.findViewById(R.id.hdMain);
        tvSubCS3 = cvSlide3.findViewById(R.id.hdSub);
        tvHeaderCS4 = cvSlide4.findViewById(R.id.hdMain);
        tvSubCS4 = cvSlide4.findViewById(R.id.hdSub);

        tvHeaderPS1 = cvPromoSlide1.findViewById(R.id.hdMain);
        tvHeaderPS2 = cvPromoSlide2.findViewById(R.id.hdMain);
        tvHeaderPS3 = cvPromoSlide3.findViewById(R.id.hdMain);


    }

    @Override
    public void onResume() {
        super.onResume();


        viewModel.populateList().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

                HomeComponent homeComponent = DaggerHomeComponent.builder()
                        .homeModule(new HomeModule(s, getActivity()))
                        .build();
                homeComponent.inject(HomeFrag.this);

                tvPNamePromoAd1.setText(itemList.get(3).getItemName());
                tvPPricePromoAd1.setText(String.valueOf(itemList.get(3).getItemSalePrice()));
                Glide.with(getContext()).load(itemList.get(3).getItemURL())
                        .centerCrop()
                        .into(ivProductPromoAd1);

                LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                rvSlide1.setHasFixedSize(true);
                rvSlide1.setLayoutManager(manager);
                rvSlide1.setAdapter(slideAdapter);

                LinearLayoutManager manager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                rvPromo1.setHasFixedSize(true);
                rvPromo1.setLayoutManager(manager2);
                rvPromo1.setAdapter(promoAdapter);

            }
        });



        vvLive.setVideoPath("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4");
        vvLive.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                try {
                    if (mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = new MediaPlayer();
                    }
                    mediaPlayer.setVolume(0f, 0f);
                    mediaPlayer.start();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        });
        vvLive.start();

    }

    @Override
    public void onStop() {
        super.onStop();
        vvLive.stopPlayback();
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.btItemOnAir:
                ItemDetailFrag itemDetailFrag = new ItemDetailFrag();
                Bundle bundle = new Bundle();
                bundle.putBoolean("onAir", true);
                itemDetailFrag.setArguments(bundle);
                ((MainNavigation)getActivity()).replaceFragment(itemDetailFrag);
                break;
        }

    }
}
