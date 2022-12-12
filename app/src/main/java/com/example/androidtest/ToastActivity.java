package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidtest.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private Button toastBtn1, toastBtn2, toastBtn3, toastBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        toastBtn1 = findViewById(R.id.btn_toast1);
        toastBtn2 = findViewById(R.id.btn_toast2);
        toastBtn3 = findViewById(R.id.btn_toast3);
        toastBtn4 = findViewById(R.id.btn_toast4);
        OnClick onClick = new OnClick();
        toastBtn1.setOnClickListener(onClick);
        toastBtn2.setOnClickListener(onClick);
        toastBtn3.setOnClickListener(onClick);
        toastBtn4.setOnClickListener(onClick);
    }

    class OnClick implements  View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_toast1:
                    Toast.makeText(ToastActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_toast2:
                    Toast toast = Toast.makeText(ToastActivity.this, "Toast", Toast.LENGTH_SHORT);
                    // sdk版本30以下才支持
                    toast.setGravity(Gravity.CENTER, 0,0);
                    toast.show();
                    break;
                case R.id.btn_toast3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View view = inflater.inflate(R.layout.layout_toast, null);
                    ImageView imageView = view.findViewById(R.id.iv_toast);
                    TextView textView = view.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.chips);
                    textView.setText("自定义");
                    toastCustom.setView(view);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.btn_toast4:
                    // 连续点击，会抵消之前的弹窗，理论上"showMsg"应该写成单例模式
                    ToastUtil.showMsg(getApplicationContext(), "包装的Toast");
                    break;
                default:
                    break;
            }
        }
    }
}