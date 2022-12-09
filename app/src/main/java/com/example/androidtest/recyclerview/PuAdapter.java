package com.example.androidtest.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtest.R;

public class PuAdapter extends RecyclerView.Adapter<PuAdapter.LinearViewHolder> {

    private Context context;
    private OnItemClickListener listener;

    public PuAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PuAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_pu_recyclerview_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PuAdapter.LinearViewHolder viewHolder, int i) {
        if (i % 2 == 0) {
            viewHolder.imageView.setImageResource(R.drawable.warning);
        } else {
            viewHolder.imageView.setImageResource(R.drawable.boy);
        }
        viewHolder.itemView.setOnClickListener(v -> listener.onclick(i));
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener {
        void onclick(int pos);
    }
}
