package com.lzm.meandmybreakheart.fragment.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lzm.meandmybreakheart.R;

import java.util.List;

/**
 * Created by luzhiming on 2017/3/9.
 */

public class LeftAdapter extends BaseAdapter {
    List<String> numbers;
    Context mContext;
    int selectPosition;

    public LeftAdapter(List<String> numbers, Context mCOntext) {
        this.numbers = numbers;
        this.mContext = mCOntext;
    }

    @Override
    public int getCount() {
        return numbers.size();
    }

    @Override
    public Object getItem(int position) {
        return numbers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HeaderHolder holder;

        if (convertView == null) {
            holder = new HeaderHolder();
            convertView = View.inflate(mContext, R.layout.header, null);

            holder.textView = (TextView) convertView.findViewById(R.id.text_view);

            convertView.setTag(holder);
        } else {
            holder = (HeaderHolder) convertView.getTag();
        }
        holder.textView.setText(numbers.get(position));
        if (selectPosition == position) {
            holder.textView.setBackgroundColor(Color.WHITE);
        } else {
            holder.textView.setBackgroundColor(mContext.getResources().getColor(R.color.luColor));
        }
        return convertView;
    }

    public void changeBackgroundColor(int selectPosition) {
        if (this.selectPosition == selectPosition) {
            return;
        }

        this.selectPosition = selectPosition;
        System.out.println("refreshing...");
        notifyDataSetChanged();
    }

    class HeaderHolder {
        TextView textView;
    }
}
