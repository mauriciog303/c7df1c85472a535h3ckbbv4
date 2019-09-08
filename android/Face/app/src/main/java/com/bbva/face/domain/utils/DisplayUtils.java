package com.bbva.face.domain.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class DisplayUtils {

    public static void saveDisplaySize(Display display, Context context) {
        Point size = new Point();
        display.getSize(size);

        SharedPreferences displayPreferences = context.getSharedPreferences("displayPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = displayPreferences.edit();
        edit.putInt("width", size.x);
        edit.putInt("height", size.y);
        edit.apply();
    }

    public static int getWidth(Context context, double scale) {
        SharedPreferences displayPreferences = context.getSharedPreferences("displayPreferences", Context.MODE_PRIVATE);
        return Double.valueOf(displayPreferences.getInt("width", WindowManager.LayoutParams.MATCH_PARENT) * scale).intValue();

    }

    public static int getHeight(Context context, double scale) {
        SharedPreferences displayPreferences = context.getSharedPreferences("displayPreferences", Context.MODE_PRIVATE);
        return Double.valueOf(displayPreferences.getInt("height", WindowManager.LayoutParams.MATCH_PARENT) * scale).intValue();
    }
}