package com.example.androidtest.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidtest.R;

public class RecyclerActivity extends AppCompatActivity {

    private Button linearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        linearBtn = findViewById(R.id.btn_linear);
        linearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerActivity.this, LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}