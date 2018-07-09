package com.huang.tablayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.android.support.design.widget.TabItem;
import com.android.support.design.widget.TabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.huang.tablayout.adapter.AlbumAdapter;
import com.huang.tablayout.fragment.AlbumFragment;
import com.huang.tablayout.fragment.AlbumFragment1;
import java.lang.reflect.Field;
import java.util.ArrayList;

import uchon.yuqiang.com.tablayout.R;

/**
 * @author PC
 */
public class MainActivity extends AppCompatActivity implements OnTabSelectListener {

    private TabLayout mTabLayout;
    private TabLayout mTabLayout1;
    private TabLayout mTabLayout2;
    private ViewPager mViewPager;
    private String[] mTitles;
    private TabItem tabItem1;
    private TabItem tabItem2;
    private TabItem tabItem3;

    private TabItem tabItem11;
    private TabItem tabItem22;
    private TabItem tabItem33;

    private TabItem tabItem111;
    private TabItem tabItem222;
    private TabItem tabItem333;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView(); // 初始化控件
        initViewPager(); // 初始化ViewPager
        mTitles = getResources().getStringArray(R.array.album_title);
        String m = getResources().getString(R.string.tab1);
        Log.d("", "onCreate: ----------------");
//        tabItem1.getTe
    }

    private void initViewPager() {
        // 创建一个集合,装填Fragment
        ArrayList<Fragment> fragments = new ArrayList<>();
        // 装填
        fragments.add(new AlbumFragment());
        fragments.add(new AlbumFragment1());
        fragments.add(new AlbumFragment());

        // 创建ViewPager适配器
        AlbumAdapter mPagerAdapter = new AlbumAdapter(getSupportFragmentManager(),fragments);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout1));
        mTabLayout1.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout2));
        mTabLayout2.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        mViewPager.setAdapter(mPagerAdapter);
//        mTabLayout.
//        mPagerAdapter.setFragments(fragments);
//        mViewPager.setAdapter(mPagerAdapter);
//        mTabLayout.setViewPager(mViewPager,mTitles);
//        mTabLayout.setOnTabSelectListener(this);
//        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelect(int position) {
//            }
//
//            @Override
//            public void onTabReselect(int position) {
//
//            }
//        });
//
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                mTabLayout.setCurrentTab(position);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//        mViewPager.setCurrentItem(1);

        // tablayout和viewpager建立相互的联系
//        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
//        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        // 给ViewPager设置适配器


//        mTabLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                setIndicator(mTabLayout, dip2px(20), dip2px(20));
//            }
//        });

    }

    /**
     * 初始化控件
     */
    private void initView() {
        mTabLayout = findViewById(R.id.tab_toolbar);
        tabItem1 = findViewById(R.id.tabItem1);
        tabItem2 = findViewById(R.id.tabItem2);
        tabItem3 = findViewById(R.id.tabItem3);

        mTabLayout1 = findViewById(R.id.tab_toolbar1);
        tabItem11 = findViewById(R.id.tabItem11);
        tabItem22 = findViewById(R.id.tabItem22);
        tabItem33 = findViewById(R.id.tabItem33);

        mTabLayout2 = findViewById(R.id.tab_toolbar2);
        tabItem111 = findViewById(R.id.tabItem111);
        tabItem222 = findViewById(R.id.tabItem222);
        tabItem333 = findViewById(R.id.tabItem333);
        mViewPager = findViewById(R.id.view_pager_album);
    }

    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.width = leftDip ;
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
//        try {
//            //拿到tabLayout的mTabStrip属性
//            LinearLayout mTabStrip = (LinearLayout) tabs.getChildAt(0);
//
//            int dp10 = dip2px(10);
//
//            for (int i = 0; i < mTabStrip.getChildCount(); i++) {
//                View tabView = mTabStrip.getChildAt(i);
//
//                //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
//                Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
//                mTextViewField.setAccessible(true);
//
//                TextView mTextView = (TextView) mTextViewField.get(tabView);
//
//                tabView.setPadding(0, 0, 0, 0);
//
//                //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
//                int width = dip2px(10);
////                width = mTextView.getWidth();
////                if (width == 0) {
//////                    mTextView.measure(0, 0);
////                    width = dip2px(10);
////                }
//
//                //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
//                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
//                params.width = width ;
//                params.leftMargin = leftDip;
//                params.rightMargin = leftDip;
//                tabView.setLayoutParams(params);
//
//                tabView.invalidate();
//            }
//
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(float dpValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public int px2dip(float pxValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    @Override
    public void onTabSelect(int position) {

    }

    @Override
    public void onTabReselect(int position) {

    }
}
