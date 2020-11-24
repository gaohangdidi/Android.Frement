package com.example.xiaoyuantaobao;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.xiaoyuantaobao.adapter.MainPagerAdapter;
import com.example.xiaoyuantaobao.base.BaseActivity;
import com.example.xiaoyuantaobao.fragment.CartFragment;
import com.example.xiaoyuantaobao.fragment.HomeFragment;
import com.example.xiaoyuantaobao.fragment.HotFragment;
import com.example.xiaoyuantaobao.fragment.MessageFragment;
import com.example.xiaoyuantaobao.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tv_tab_home)
    TextView tvTabHome;
    @BindView(R.id.tv_tab_hot)
    TextView tvTabHot;
    @BindView(R.id.tv_tab_message)
    TextView tvTabMessage;
    @BindView(R.id.tv_tab_cart)
    TextView tvTabCart;
    @BindView(R.id.tv_tab_user)
    TextView tvTabUser;
    @BindView(R.id.ll_bottom_menu)
    LinearLayout llBottomMenu;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private List<Fragment> fragments;

    @Override
    protected int getResourcesViewId() {
        return R.layout.activity_main;
    }
    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(0,new HomeFragment());
        fragments.add(1,new HotFragment());
        fragments.add(2,new MessageFragment());
        fragments.add(3,new CartFragment());
        fragments.add(4,new UserFragment());

        MainPagerAdapter adapter=new MainPagerAdapter(getSupportFragmentManager(),fragments);
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(0);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageScrollStateChanged(int state) { }
            //当前页面被选中了
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        viewpager.setCurrentItem(0);//设置当前页面为第1页
                        tvTitle.setText("首页");
                        //设置 当前 home的 文字为 红色
                        setSelected();
                        tvTabHome.setSelected(true);
                        break;
                    case 1:
                        viewpager.setCurrentItem(1);//设置当前页面为第2页
                        tvTitle.setText("热卖");
                        setSelected();
                        tvTabHot.setSelected(true);
                        break;
                    case 2:
                        viewpager.setCurrentItem(2);//设置当前页面为第3页
                        tvTitle.setText("消息");
                        setSelected();
                        tvTabMessage.setSelected(true);
                        break;
                    case 3:
                        viewpager.setCurrentItem(3);//设置当前页面为第3页
                        tvTitle.setText("购物车");
                        setSelected();
                        tvTabCart.setSelected(true);
                        break;
                    case 4:
                        viewpager.setCurrentItem(4);//设置当前页面为第4页
                        tvTitle.setText("个人中心");
                        setSelected();
                        tvTabUser.setSelected(true);
                        break;
                }

            }
        });
    }
    private void setSelected(){
        tvTabHome.setSelected(false);
        tvTabHot.setSelected(false);
        tvTabMessage.setSelected(false);
        tvTabCart.setSelected(false);
        tvTabUser.setSelected(false);
    }
    @Override
    protected void addListener() {
        tvTabUser.setOnClickListener(this);
        tvTabMessage.setOnClickListener(this);
        tvTabCart.setOnClickListener(this);
        tvTabHome.setOnClickListener(this);
        tvTabHot.setOnClickListener(this);
        tvTabHome.performClick();
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.tv_tab_home:
                viewpager.setCurrentItem(0);//设置当前页面为第1页
                //设置 当前 home的 文字为 红色
                setSelected();
                tvTabHome.setSelected(true);
                break;
            case R.id.tv_tab_hot:
                viewpager.setCurrentItem(1);//设置当前页面为第2页
                setSelected();
                tvTabHot.setSelected(true);
                break;
            case R.id.tv_tab_message:
                viewpager.setCurrentItem(2);//设置当前页面为第2页
                setSelected();
                tvTabMessage.setSelected(true);
                break;
            case R.id.tv_tab_cart:
                viewpager.setCurrentItem(3);//设置当前页面为第3页
                setSelected();
                tvTabCart.setSelected(true);
                break;
            case R.id.tv_tab_user:
                viewpager.setCurrentItem(4);//设置当前页面为第4页
                setSelected();
                tvTabUser.setSelected(true);
                break;
        }
    }



}
