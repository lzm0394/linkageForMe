package com.lzm.meandmybreakheart.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lzm.meandmybreakheart.R;
import com.squareup.picasso.Picasso;

/**
 * Created by luzhiming on 2017/3/9.
 */

public class FragementOne extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragemnt_one, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        Picasso.with(getActivity()).load("http://wx4.sinaimg.cn/mw1024/9d52c073gy1fdfqguyrjej20ia0wgtci.jpg").into(imageView);
        return view;
    }
}
