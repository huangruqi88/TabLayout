package com.huang.tablayout.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uchon.yuqiang.com.tablayout.R;

/**
 * 短视频相册界面.
 *
 * @author 黄汝琪
 * @date 2018/5/15
 */
public class AlbumFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //引用创建好的xml布局
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        return view;

    }


}
