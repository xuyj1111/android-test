package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        textView2 = findViewById(R.id.txt_2);
        textView2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        textView3 = findViewById(R.id.txt_3);
        textView3.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        textView4 = findViewById(R.id.txt_4);
        textView4.setText(Html.fromHtml("<u>使用html标签</u>"));

        textView5 = findViewById(R.id.txt_5);
//        textView5.setSelected(true);
    }
}