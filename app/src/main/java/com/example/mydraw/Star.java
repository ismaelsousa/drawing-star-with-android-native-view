package com.example.mydraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class Star extends View {
    public Star(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();

        float centerX = width / 2f;
        float centerY = height / 2f;

        float radius = Math.min(width, height) / 2f;

        // Create a path for the star shape
        Path path = new Path();
        float degreesPerPoint = 360f / 5f; // 5 points in a star
        float angle = -90; // Start at the top
        for (int i = 0; i < 5; i++) {
            float x = centerX + radius * (float) Math.cos(Math.toRadians(angle));
            float y = centerY + radius * (float) Math.sin(Math.toRadians(angle));
            if (i == 0) {
                path.moveTo(x, y); // Move to the first point
            } else {
                path.lineTo(x, y); // Draw a line to the next point
            }
            angle += degreesPerPoint;
        }
        path.close(); // Connect the last point to the first point to complete the star

        // Create a paint object with the desired color and stroke width
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.FILL);

        // Draw the star shape with the paint object
        canvas.drawPath(path, paint);
    }
}
