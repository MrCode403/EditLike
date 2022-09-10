package com.editlike.app;

import android.app.*;
import android.content.*;
import android.graphics.drawable.*;
import android.net.*;
import android.util.*;
import android.view.*;
import android.view.inputmethod.*;
import android.widget.*;

import java.io.*;
import java.util.*;

public class Util {

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
}

