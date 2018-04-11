package com.jim.takeout.presenter.base;

import com.jim.takeout.model.dao.DBHelper;
import com.jim.takeout.presenter.api.ResponseInfoAPI;
import com.jim.takeout.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2018/3/11.
 */

public class BasePresenter {
    protected static ResponseInfoAPI mApi;
    protected DBHelper helper;
    //数据库

    //网络


    public BasePresenter(){
        if (mApi==null){
            Retrofit build = new Retrofit.Builder().baseUrl(Constant.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mApi = build.create(ResponseInfoAPI.class);
        }
        helper=DBHelper.getInstance();
    }
}
