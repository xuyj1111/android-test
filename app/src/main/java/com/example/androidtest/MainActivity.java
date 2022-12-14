package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidtest.gridview.GridViewActivity;
import com.example.androidtest.recyclerview.RecyclerActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnTextView;
    private Button btnButton;
    private Button btnEditText;
    private Button btnRadioButton;
    private Button btnCheckBox;
    private Button btnImageView;
    private Button btnGridView;
    private Button btnRecyclerView;
    private Button btnToast;
    private Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTextView = findViewById(R.id.btn_textView);
        btnButton = findViewById(R.id.btn_button);
        btnEditText = findViewById(R.id.btn_editText);
        btnRadioButton = findViewById(R.id.btn_radioButton);
        btnCheckBox = findViewById(R.id.btn_checkBox);
        btnImageView = findViewById(R.id.btn_imageView);
        btnGridView = findViewById(R.id.btn_gridView);
        btnRecyclerView = findViewById(R.id.btn_recyclerview);
        btnToast = findViewById(R.id.btn_toast);
        btnDialog = findViewById(R.id.btn_dialog);

        OnClick onClick = new OnClick();
        btnTextView.setOnClickListener(onClick);
        btnButton.setOnClickListener(onClick);
        btnEditText.setOnClickListener(onClick);
        btnRadioButton.setOnClickListener(onClick);
        btnCheckBox.setOnClickListener(onClick);
        btnImageView.setOnClickListener(onClick);
        btnGridView.setOnClickListener(onClick);
        btnRecyclerView.setOnClickListener(onClick);
        btnToast.setOnClickListener(onClick);
        btnDialog.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_textView:
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_editText:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radioButton:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkBox:
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageView:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_gridView:
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    intent = new Intent(MainActivity.this, RecyclerActivity.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent = new Intent(MainActivity.this, DialogActivity.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }
}