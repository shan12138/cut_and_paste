package com.huanglf.test16.ui.jy;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.huanglf.test16.R;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

/**
 * Date: 2019/7/6
 * Author: JinYue
 * description:
 */
public class TopBarFragment extends Fragment {
    private QMUITopBarLayout mTopBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_bar, container, false);
        mTopBar = view.findViewById(R.id.topBar);
        initTopBar();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.left_user);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).navigate(R.id.toPersonFromMain);
            }
        });
        ImageView imageViewRight = view.findViewById(R.id.right_new);
        imageViewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.toDetailFromMain);
            }
        });
    }

    private void initTopBar() {
        mTopBar.setTitle("我的剪切记录");
        mTopBar.addLeftImageButton(R.drawable.user_round, R.id.left_user);
        mTopBar.addRightImageButton(R.drawable.plus, R.id.right_new);
        mTopBar.setBackgroundColor(Color.parseColor("#359BFF"));
    }
}
