package com.example.androidtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidtest.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button btnDialog1, btnDialog2, btnDialog3, btnDialog4, btnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        btnDialog1 = findViewById(R.id.btn_dialog1);
        btnDialog2 = findViewById(R.id.btn_dialog2);
        btnDialog3 = findViewById(R.id.btn_dialog3);
        btnDialog4 = findViewById(R.id.btn_dialog4);
        btnDialog5 = findViewById(R.id.btn_dialog5);
        OnClick onClick = new OnClick();
        btnDialog1.setOnClickListener(onClick);
        btnDialog2.setOnClickListener(onClick);
        btnDialog3.setOnClickListener(onClick);
        btnDialog4.setOnClickListener(onClick);
        btnDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String[] arr = new String[]{"男", "女"};
            switch (v.getId()) {
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogActivity.this);
                    builder1.setTitle("请回答")
                            .setIcon(R.drawable.boy)
                            .setMessage("你觉得今天天气怎么样？")
                            .setPositiveButton("好", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ToastUtil.showMsg(DialogActivity.this, "哦");
                                }
                            })
                            .setNeutralButton("一般", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ToastUtil.showMsg(DialogActivity.this, "哦");
                                }
                            })
                            .setNegativeButton("不好", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ToastUtil.showMsg(DialogActivity.this, "哦");
                                }
                            }).show();
                    break;
                case R.id.btn_dialog2:
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别").setItems(arr, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this, arr[i]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    // "setCancelable(false)"点击对话框之外位置，不会让对话框消失
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("选择性别").setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this, arr[i]);
                            // 对话框消失
                            dialogInterface.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog4:
                    String[] arr2 = new String[]{"唱歌", "跳舞", "篮球"};
                    boolean[] isSelected = new boolean[]{false, true, true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(arr2, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            ToastUtil.showMsg(DialogActivity.this, arr2[i] + ":" + b);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog, null);
                    EditText username = view.findViewById(R.id.et_dialog_username);
                    EditText password = view.findViewById(R.id.et_dialog_password);
                    Button login = view.findViewById(R.id.btn_dialog_login);
                    login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                    builder5.setTitle("请先登录").setView(view).show();
                    break;
                default:
                    break;
            }
        }
    }
}