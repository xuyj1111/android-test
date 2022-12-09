package com.example.androidtest.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtest.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        recyclerView.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this));
        // 分割线，是activity_linear_recycler_view.xml的背景色
        recyclerView.addItemDecoration(new MyDecoration());
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0, 10);
        }

        @Override
        public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDraw(c, parent, state);

            // 设置画笔颜色
            Paint mPaint = new Paint();
            mPaint.setColor(Color.RED);

            // 获取RecyclerView的Child view的个数
            int childCount = parent.getChildCount();

            // 遍历每个Item，分别获取它们的位置信息，然后再绘制对应的分割线
            for (int i = 0; i < childCount; i++) {
                // 获取每个Item的位置
                final View child = parent.getChildAt(i);

//                // 获取布局参数
//                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
//                        .getLayoutParams();

                // 矩形左上顶点 = (ItemView的左边界,ItemView的下边界)
                // ItemView的左边界 = RecyclerView 的左边界 + paddingLeft距离 后的位置
                final int left = parent.getPaddingLeft();

                // ItemView的下边界：ItemView 的 bottom坐标
                final int top = child.getBottom();

                // ItemView的右边界 = RecyclerView 的右边界减去 paddingRight 后的坐标位置
                final int right = parent.getWidth() - parent.getPaddingRight();

                // 绘制分割线的下边界 = ItemView的下边界+分割线的高度
                final int bottom = top + 10;

                // 通过Canvas绘制矩形（分割线）
                c.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }
}