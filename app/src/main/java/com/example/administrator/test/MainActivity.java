package com.example.administrator.test;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * fragment模拟微信主页面
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private FragmentManager mFm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_weixin).setOnClickListener(this);
        findViewById(R.id.bt_contacts).setOnClickListener(this);
        findViewById(R.id.bt_discover).setOnClickListener(this);
        findViewById(R.id.bt_me).setOnClickListener(this);

        mFm = getFragmentManager();

    }

    @Override
    public void onClick(View v) {
        // 每点击一次都会开启一个事务，提交一个事务，第二次点击需要重新再开另外一个事务
        FragmentTransaction fragmentTransaction = mFm.beginTransaction();
        switch (v.getId()) {
            case R.id.bt_weixin:
                fragmentTransaction.replace(R.id.fl_root, new WeixinFragment());
                break;
            case R.id.bt_contacts:
                fragmentTransaction.replace(R.id.fl_root, new ContactsFragment());
                break;
            case R.id.bt_discover:
                fragmentTransaction.replace(R.id.fl_root, new DiscoverFragment());
                break;
            case R.id.bt_me:
                fragmentTransaction.replace(R.id.fl_root, new MeFragment());
                break;
        }
        fragmentTransaction.commit();
    }
}
