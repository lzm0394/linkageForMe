package com.lzm.meandmybreakheart.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lzm.meandmybreakheart.R;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by luzhiming on 2017/3/9.
 */

public class HeadListViewAdapter extends BaseAdapter implements StickyListHeadersAdapter {
    Context mContext;
    String[] countries;

    public HeadListViewAdapter(Context mContext, String[] countries) {
        this.mContext = mContext;
        this.countries = countries;
    }

    @Override
    public int getCount() {
        return countries.length;
    }

    @Override
    public Object getItem(int position) {
        return countries[position];
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
            convertView = View.inflate(mContext, R.layout.item, null);

            holder.textView = (TextView) convertView.findViewById(R.id.text_view);
            convertView.setTag(holder);
        } else {
            holder = (HeaderHolder) convertView.getTag();
        }

        holder.textView.setText(countries[position]);

        return convertView;

    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderHolder holder;

        if (convertView == null) {
            holder = new HeaderHolder();
            convertView = View.inflate(mContext, R.layout.header, null);

            holder.textView = (TextView) convertView.findViewById(R.id.text_view);
            convertView.setTag(holder);
        } else {
            holder = (HeaderHolder) convertView.getTag();
        }
        String headerText = "" + countries[position].subSequence(0, 1).charAt(0);
        holder.textView.setText(headerText);

        return convertView;
    }

    @Override
    public long getHeaderId(int position) {

        return countries[position].subSequence(0, 1).charAt(0);
    }

    class HeaderHolder {

        TextView textView;
    }

    class ItemHolder {
        TextView textView;
    }

}
