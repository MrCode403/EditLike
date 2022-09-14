package com.editlike.app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.*;
import android.os.Bundle;
import android.Manifest;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.editlike.app.databinding.TemplateBinding;
import io.michaelrocks.paranoid.Obfuscate;

@Obfuscate
public class TemplateActivity extends AppCompatActivity {

  private TemplateBinding binding;
  private boolean template1clicked = false;
  private boolean template2clicked = false;
  public final int REQ_CD_PICKVIDEO = 101;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // LogSender.startLogging(this);
    binding = TemplateBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    binding.template1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            template1clicked = true;
            template2clicked = false;
            if (isStoragePermissionGranted()) {
              onStorageAlreadyGranted();
            } else {
              onStorageDenied();
            }
          }
        });
    binding.template2.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            template2clicked = true;
            template1clicked = false;
            if (isStoragePermissionGranted()) {
              onStorageAlreadyGranted();
            } else {
              onStorageDenied();
            }
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
    binding.base.setBackgroundDrawable(gd001);
  }

  @Override
  public void onBackPressed() {
    finishAffinity();
  }

  public boolean isStoragePermissionGranted() {
    return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED
        && ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED;
  }

  protected void onStorageAlreadyGranted() {
    if (template1clicked) {
      final Intent MainPage = new Intent();
      MainPage.setClass(getApplicationContext(), MainActivity.class);
      MainPage.putExtra("TEMPLATE", "TEMPLATE1");
      MainPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
      startActivity(MainPage);
    } else if (template2clicked) {
      final Intent PICKVIDEO =
          new Intent(
              Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
      PICKVIDEO.setType("video/*");
      startActivityForResult(PICKVIDEO, REQ_CD_PICKVIDEO);
    }
  }

  protected void onStorageDenied() {
    if (template1clicked) {
      final Intent MainPage = new Intent();
      MainPage.setClass(getApplicationContext(), PermissionsActivity.class);
      MainPage.putExtra("TEMPLATE", "TEMPLATE1");
      MainPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
      startActivity(MainPage);
    } else if (template2clicked) {
      final Intent MainPage = new Intent();
      MainPage.setClass(getApplicationContext(), PermissionsActivity.class);
      MainPage.putExtra("TEMPLATE", "TEMPLATE2");
      MainPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
      startActivity(MainPage);
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
      case REQ_CD_PICKVIDEO:
        final Intent MainPage = new Intent();
        MainPage.setClass(getApplicationContext(), MainActivity.class);
        MainPage.putExtra("TEMPLATE", "TEMPLATE2");
        MainPage.putExtra("VIDEOURI", data.getData().toString());
        MainPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(MainPage);
        break;
    }
  }
}

