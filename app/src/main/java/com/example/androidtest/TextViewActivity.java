package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private TextView tvDeleteline;
    private TextView tvUnderline;
    private TextView tvHtml;
    private TextView tvMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        tvDeleteline = findViewById(R.id.tv_deleteline);
        tvDeleteline.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        tvUnderline = findViewById(R.id.tv_underline);
        tvUnderline.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        tvHtml = findViewById(R.id.tv_html);
        tvHtml.setText(Html.fromHtml("<u>使用html标签</u>"));

        tvMove = findViewById(R.id.tv_move);
//        textView5.setSelected(true);
    }
}