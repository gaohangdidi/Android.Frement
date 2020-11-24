package com.example.xiaoyuantaobao.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;


public  abstract class BaseActivity extends AppCompatActivity {

    protected Activity mContext;
    protected Handler mhandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        mhandler = new Handler();
        setContentView(getResourcesViewId());
        ButterKnife.bind(this.mContext);
        initData();
        addListener();
    }

    protected abstract void addListener();

    protected abstract void initData();

    protected abstract int getResourcesViewId();
}
