package com.project.sangjun.myapp.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.project.sangjun.myapp.R;

public class MyView extends View {
    private int color;
    private String[] attributes;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyView);
            color = array.getColor(R.styleable.MyView_customColor, Color.GRAY);
        }

        int size = attrs.getAttributeCount();
        attributes = new String[size];
        for (int i = 0; i < size; i++) {
            attributes[i] = attrs.getAttributeName(i) + " = " + attrs.getAttributeValue(i);
        }

    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(color);

        RectF rectF = new RectF(15,15,160,160);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        canvas.drawArc(rectF, 0, 360, false, paint);


        Paint textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(30);

        int y = 0;
        for (String attr : attributes) {
            canvas.drawText(attr, 50, 300 + y, textPaint);
            y += 20;
        }

        super.onDraw(canvas);
    }

    //뷰 내부에서 크기 결정

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(200, 200);//바깥 레이아웃 상관 없이 크기 고정

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //layout의 사이즈 조건에 따른 뷰 크기 초기화 설정
        int resultWidth = 0;
        int resultHeight = 0;

        if (widthMode == MeasureSpec.AT_MOST) {//wrap_content 설정시
            resultWidth = 200;
        } else if(widthMode == MeasureSpec.EXACTLY) {//match_parent, px 설정시
            resultWidth = widthSize;
        }

        if (heightMode == MeasureSpec.AT_MOST) {//wrap_content 설정시
            resultHeight = 200;
        } else if(heightMode == MeasureSpec.EXACTLY) {//match_parent, px 설정시
            resultHeight = heightSize;
        }


        setMeasuredDimension(resultWidth, resultHeight);
    }
}
