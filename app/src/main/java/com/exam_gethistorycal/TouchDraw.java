package com.exam_gethistorycal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TouchDraw extends View {
    Paint paint;
    private List<PointF> get;
    private List<PointF> getHistorical;

    public TouchDraw(Context context) {
        super(context);
        paint = new Paint();
        get = new ArrayList<>();
        getHistorical = new ArrayList<>();
    }

    int margin = 100;
    @Override
    protected void onDraw(Canvas canvas) {
        for (PointF val: get) {
            canvas.drawCircle(val.x, val.y + margin, 5f, paint);
        }
        for (PointF val: getHistorical) {
            canvas.drawCircle(val.x, val.y - margin, 5f, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                get = new ArrayList<>();
                getHistorical = new ArrayList<>();
                get.add(new PointF(event.getX(), event.getY()));
                getHistorical.add(new PointF(event.getX(), event.getY()));
                break;
            case MotionEvent.ACTION_MOVE:
                int historySize = event.getHistorySize();
                for (int i = 0; i < historySize; i++) {
                    getHistorical.add(new PointF(event.getHistoricalX(i), event.getHistoricalY(i)));
                }
                get.add(new PointF(event.getX(), event.getY()));
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }
}
