package com.editlike.app;

import android.app.*;
import android.content.*;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.*;
import android.net.*;
import android.util.*;
import android.view.*;
import android.view.inputmethod.*;
import android.widget.*;
import android.os.Looper;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;
import java.util.*;

public class AppUtil {

  public static int getLocationX(View view) {
    int location[] = new int[2];
    view.getLocationInWindow(location);
    return location[0];
  }

  public static int getLocationY(View view) {
    int location[] = new int[2];
    view.getLocationInWindow(location);
    return location[1];
  }

  public static void showKeyboard(Context context) {
    InputMethodManager inputMethodManager =
        (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
  }

  public static void hideKeyboard(Context context) {
    InputMethodManager inputMethodManager =
        (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
  }

  public static void TimeAndDate(TextView view, TextView view1) {
    Timer timer = new Timer();
    TimerTask settimer;
    settimer =
        new TimerTask() {
          @Override
          public void run() {
            new Handler(Looper.getMainLooper())
                .post(
                    new Runnable() {
                      @Override
                      public void run() {
                        Calendar cal = Calendar.getInstance();
                        view.setText(new SimpleDateFormat("hh:mm a").format(cal.getTime()));
                        view1.setText(
                            new SimpleDateFormat("dd MMM yy").format(cal.getTime()) + " •");
                      }
                    });
          }
        };
    timer.scheduleAtFixedRate(settimer, (int) (0), (int) (1000));
  }

  public static void viewToImage(
      final View view, final VideoView videoview, final String _storage_place) {
    view.destroyDrawingCache();
    view.setDrawingCacheEnabled(true);
    Bitmap b = view.getDrawingCache();
    try {
      java.io.File file = new java.io.File(_storage_place);
      java.io.OutputStream out = new java.io.FileOutputStream(file);
      b.compress(Bitmap.CompressFormat.PNG, 100, out);
      out.flush();
      out.close();
      videoview.setBackgroundColor(Color.TRANSPARENT);
    } catch (Exception e) {
    }
  }

  public static void ChangeViewSize(final View view, final double w) {
    view.getLayoutParams().width = (int) w;
    view.requestLayout();
  }
}
