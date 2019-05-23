package com.example.customviewtest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TestTextView extends android.support.v7.widget.AppCompatTextView {
    public TestTextView(Context context) {
        super(context);
    }

    public TestTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTextColor(getContext().getResources().getColor(R.color.colorAccent));
    }
}
