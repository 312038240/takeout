package com.jim.takeout.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.jim.takeout.R;
import com.jim.takeout.view.base.BaseActivity;
import com.jim.takeout.view.fragment.HomeFragment;
import com.jim.takeout.view.fragment.MoreFragment;
import com.jim.takeout.view.fragment.OrderFragment;
import com.jim.takeout.view.fragment.UserFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {


    @BindView(R.id.main_fragment_container)
    FrameLayout mMainFragmentContainer;
    @BindView(R.id.main_bottome_switcher_container)
    LinearLayout mMainBottomeSwitcherContainer;
    ArrayList<Fragment> mList=new ArrayList<>();




    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int i = mMainBottomeSwitcherContainer.indexOfChild(v);
            changeUi(i);
            changeFragment(i);
        }
    };

    private void changeFragment(int i) {
        Fragment fragment = mList.get(i);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment_container,fragment)
                .commit();
    }
    /**
     * 改变Index对应的孩子的状态，包括这个孩子中多有控件的状态（不可用状态：enable=false）
     * 改变其他的孩子的状态，，包括这些孩子中多有控件的状态
     * @param index
     */
    private void changeUi(int index) {

        int childCount = mMainBottomeSwitcherContainer.getChildCount();

        for (int i = 0; i < childCount; i++) {

            // 判断i是否与index相同
            // 相同：不可用状态：enable=false
            if(i==index){
                // 不可以再点击了
//                mainBottomeSwitcherContainer.getChildAt(i).setEnabled(false);
                // 每个Item中的控件都需要切换状态
                setEnable(mMainBottomeSwitcherContainer.getChildAt(i),false);

            }else{
                // 不可以再点击了
//                mainBottomeSwitcherContainer.getChildAt(i).setEnabled(true);
                // 每个Item中的控件都需要切换状态
                setEnable(mMainBottomeSwitcherContainer.getChildAt(i),true);
            }


        }

    }
    /**
     * 将每个Item中的所用控件状态一同改变
     * 由于我们处理一个通用的代码，那么Item可能会有很多层，所以我们需要使用递归
     * @param item
     * @param b
     */
    private void setEnable(View item, boolean b) {
        item.setEnabled(b);
        if(item instanceof ViewGroup)
        {
            int childCount = ((ViewGroup) item).getChildCount();
            for (int i = 0; i < childCount; i++) {
                setEnable(((ViewGroup) item).getChildAt(i),b);
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        setListen();
    }

    private void init() {
        mList.add(new HomeFragment());
        mList.add(new OrderFragment());
        mList.add(new UserFragment());
        mList.add(new MoreFragment());

        onClickListener.onClick(mMainBottomeSwitcherContainer.getChildAt(0));
    }

    private void setListen() {
        int childCount = mMainBottomeSwitcherContainer.getChildCount();
        for (int i = 0; i <childCount ; i++) {
            FrameLayout childAt = (FrameLayout) mMainBottomeSwitcherContainer.getChildAt(i);
            childAt.setOnClickListener(onClickListener);
        }
    }

}
