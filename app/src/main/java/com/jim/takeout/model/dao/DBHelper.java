package com.jim.takeout.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.jim.takeout.MakeOutApplication;

/**
 * Created by Teacher on 2016/9/2.
 */
public class DBHelper extends OrmLiteSqliteOpenHelper{
    private static final String DATABASENAME = "takeout.db";
    private static final int DATABASEVERSION = 1;
    private static DBHelper instance;
    /**
     * 单例处理
     */
    public static DBHelper getInstance() {
        if (instance==null){
            synchronized (DBHelper.class){
                if (instance==null){
                    instance=new DBHelper(MakeOutApplication.getContext());
                }
                return instance;
            }
        }
        return instance;
    }

    private DBHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }





    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
