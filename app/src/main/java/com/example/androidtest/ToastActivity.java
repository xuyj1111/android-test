package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    private Button toastBtn1, toastBtn2, toastBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        toastBtn1 = findViewById(R.id.btn_toast1);
        toastBtn2 = findViewById(R.id.btn_toast2);
        toastBtn3 = findViewById(R.id.btn_toast3);
        OnClick onClick = new OnClick();
        toastBtn1.setOnClickListener(onClick);
        toastBtn2.setOnClickListener(onClick);
        toastBtn3.setOnClickListener(onClick);
    }

    class OnClick implements  View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_toast1:
                    Toast.makeText(ToastActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_toast2:
                    Toast toast = Toast.makeText(ToastActivity.this, "Toast", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0,0);
                    toast.show();
                    break;
                case R.id.btn_toast3:
                    break;
                default:
                    break;
            }
        }
    }
}