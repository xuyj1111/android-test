package com.example.androidtest.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.androidtest.R;

public class PuRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        recyclerView = findViewById(R.id.rv_pu);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new PuAdapter(this, new PuAdapter.OnItemClickListener() {

            @Override
            public void onclick(int pos) {
                Toast.makeText(PuRecyclerViewActivity.this, "click:" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}