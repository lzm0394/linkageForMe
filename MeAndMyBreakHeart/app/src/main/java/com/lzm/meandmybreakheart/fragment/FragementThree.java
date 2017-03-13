package com.lzm.meandmybreakheart.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.lzm.meandmybreakheart.R;
import com.lzm.meandmybreakheart.fragment.adapter.HeadListViewAdapter;
import com.lzm.meandmybreakheart.fragment.adapter.LeftAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by luzhiming on 2017/3/9.
 */

public class FragementThree extends Fragment implements AbsListView.OnScrollListener {


    private String[] stringArray;
    private ListView listView;
    private LeftAdapter leftAdapter;
    private List<Integer> positionList;
    private HeadListViewAdapter headListViewAdapter;
    private StickyListHeadersListView stickyListHeadersListView;
    private List<String> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragemnt_three, null);
        stickyListHeadersListView = (StickyListHeadersListView) view.findViewById(R.id.head_list_view);
        listView = (ListView) view.findViewById(R.id.list_view);
        stringArray = getActivity().getResources().getStringArray(R.array.countries);
        headListViewAdapter = new HeadListViewAdapter(getActivity(), stringArray);
        stickyListHeadersListView.setAdapter(headListViewAdapter);
        data = initData();
        leftAdapter = new LeftAdapter(data, getActivity());
        listView.setAdapter(leftAdapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initEvent();
    }

    private void initEvent() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                leftAdapter.changeBackgroundColor(position);
                Toast.makeText(getActivity(), "CLICK:" + position, Toast.LENGTH_SHORT).show();
                stickyListHeadersListView.setSelection(positionList.get(position));
                isScroll = false;
            }
        });


        stickyListHeadersListView.setOnScrollListener(this);


    }

    List<String> initData() {
        List<String> list = new ArrayList<>();
        positionList = new ArrayList<>();
        Map<String, Integer> maps = new HashMap<>();
        for (int i = 0; i < stringArray.length; i++) {
            char c = stringArray[i].subSequence(0, 1).charAt(0);
            String s = String.valueOf(c);

            if (list.contains(s)) {
                continue;
            } else {
                list.add(s);
                positionList.add(i);
            }
        }


        return list;
    }

    boolean isScroll = false;

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        System.out.println("scrollState:" + scrollState);
        isScroll = true;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (isScroll) {
            System.out.println("firstVisibleItem:" + firstVisibleItem);
            char c = stringArray[firstVisibleItem].subSequence(0, 1).charAt(0);
            String s = String.valueOf(c);
            System.out.println("s:" + s);
            int j = -1;
            for (int i = 0; i < positionList.size(); i++) {
                if (data.get(i).equals(s)) {
                    j = i;
                }
            }
            leftAdapter.changeBackgroundColor(j);

            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            System.out.println("J:" + j);
            System.out.println("firstVisiblePosition：" + firstVisiblePosition);
            System.out.println("lastVisiblePosition：" + lastVisiblePosition);
            if (j > lastVisiblePosition || j < firstVisiblePosition) {
                listView.setSelection(j);
            }


        }

    }
}
