package com.jim.takeout.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.jim.takeout.R;
import com.jim.takeout.view.base.BaseFragment;


/**
 * 订单列表
 */
public class OrderFragment extends BaseFragment{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.tv);
        textView.setText("订单");
    }
}
