package com.example.androidtest.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.androidtest.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        recyclerView = findViewById(R.id.rv_grid);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(new GridAdapter(this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onclick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "click:" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}