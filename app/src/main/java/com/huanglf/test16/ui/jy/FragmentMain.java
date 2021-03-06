package com.huanglf.test16.ui.jy;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.huanglf.test16.R;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUIViewPager;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMain extends Fragment {
    private QMUITabSegment mMainTabSegment;
    private QMUITabSegment.Tab mMainTab, mFavorTab;
    private QMUIViewPager mViewPager;

    public FragmentMain() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mViewPager = view.findViewById(R.id.contentViewPager);
        mMainTabSegment = view.findViewById(R.id.mainTabSegment);
        mMainTabSegment.addOnTabSelectedListener(new QMUITabSegment.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int index) {
            }

            @Override
            public void onTabUnselected(int index) {
            }

            @Override
            public void onTabReselected(int index) {
            }

            @Override
            public void onDoubleTap(int index) {
            }
        });
        initTab();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewPager();
    }

    private void initTab() {
        mMainTab = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.drawable.list),
                ContextCompat.getDrawable(getContext(), R.drawable.list_selected),
                "我的列表", true);
        mFavorTab = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.drawable.favor),
                ContextCompat.getDrawable(getContext(), R.drawable.favor_selected),
                "我的收藏", true);
        mMainTabSegment.addTab(mMainTab);
        mMainTabSegment.addTab(mFavorTab);
    }

    private void initViewPager() {
//      getChildFragmentManagerm必须用这个
        mViewPager.setAdapter(new MainTabAdapter(getChildFragmentManager(), 0));
        mViewPager.setSwipeable(false);
        mMainTabSegment.setupWithViewPager(mViewPager, false);
    }
}
