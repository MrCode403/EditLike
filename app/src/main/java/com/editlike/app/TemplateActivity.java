package com.editlike.app;

import android.Manifest;
import android.R;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.*;
import android.os.Bundle;
import android.Manifest;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.editlike.app.TemplateActivity;
import com.editlike.app.databinding.TemplateBinding;
import io.michaelrocks.paranoid.Obfuscate;

@Obfuscate
public class TemplateActivity extends AppCompatActivity {

  private TemplateBinding binding;
  private boolean template1clicked = false;
  private boolean template2clicked = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = TemplateBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    binding.template1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            template1clicked = true;
            template2clicked = false;
            Permission();
          }
        });
    binding.template2.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            template2clicked = true;
            template1clicked = false;
            Permission();
          }
        });
  }

  @Override
  public void onStart() {
    super.onStart();
    Window window = this.getWindow();
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
    window.setStatusBarColor(Color.parseColor("#7289DA"));
    window.setNavigationBarColor(Color.parseColor("#353c57"));
    GradientDrawable gd001 =
        new GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM, new int[] {0xFF7289DA, 0xFF353c57});
    gd001.setCornerRadius(0f);
    binding.base.setBackgroundDrawable(gd001);
  }

  @Override
  public void onBackPressed() {
    finishAffinity();
  }

  public void Permission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      // IF ANDROID VERSION IS GREATER OR EQUAL TO ANDROID 9 (API 29) ~~
      if (template1clicked) {
        final Intent MainPage = new Intent();
        MainPage.setClass(getApplicationContext(), MainActivity.class);
        MainPage.putExtra("TEMPLATE", "TEMPLATE1");
        MainPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(MainPage);
      } else if (template2clicked) {
        final Intent MainPage = new Intent();
        MainPage.setClass(getApplicationContext(), MainActivity.class);
        MainPage.putExtra("TEMPLATE", "TEMPLATE2");
        MainPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(MainPage);
      }
    } else {
      // IF ANDROID VERSION IS LESS THAN ANDROID 9 (API 29) ~~
      if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
              == PackageManager.PERMISSION_DENIED
          || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
              == PackageManager.PERMISSION_DENIED) {
        if (template1clicked) {
          final Intent PermissionPage = new Intent();
          PermissionPage.setClass(getApplicationContext(), MainActivity.class);
          PermissionPage.putExtra("TEMPLATE", "TEMPLATE1");
          PermissionPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
          startActivity(PermissionPage);
        } else if (template2clicked) {
          final Intent PermissionPage = new Intent();
          PermissionPage.setClass(getApplicationContext(), MainActivity.class);
          PermissionPage.putExtra("TEMPLATE", "TEMPLATE2");
          PermissionPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
          startActivity(PermissionPage);
        }
      } else {
        if (template1clicked) {
          final Intent MainPage = new Intent();
          MainPage.setClass(getApplicationContext(), MainActivity.class);
          MainPage.putExtra("TEMPLATE", "TEMPLATE1");
          MainPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
          startActivity(MainPage);
        } else if (template2clicked) {
          final Intent MainPage = new Intent();
          MainPage.setClass(getApplicationContext(), MainActivity.class);
          MainPage.putExtra("TEMPLATE", "TEMPLATE2");
          MainPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
          startActivity(MainPage);
        }
      }
    }
  }
}

