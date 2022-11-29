package com.example.androidtest.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androidtest.R;

public class MyGridViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public MyGridViewAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder {
        public ImageView imageView;
        public TextView textView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.layout_grid_item, null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.iv_grid);
            holder.textView = view.findViewById(R.id.tv_grid);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText("花");
        Glide.with(context).load("https://img2.baidu.com/it/" +
                "u=4192169457,1954533997&fm=253&app=138&size=w931&n=0&" +
                "f=JPEG&fmt=auto?sec=1669827600&t=61f8c5ebb021c93c7394a93ff6dc381a").into(holder.imageView);
        return view;
    }
}
