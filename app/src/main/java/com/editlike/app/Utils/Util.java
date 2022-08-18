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
}
