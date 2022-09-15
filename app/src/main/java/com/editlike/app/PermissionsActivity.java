package com.editlike.app;

import android.Manifest;
import android.app.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.provider.Settings;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.editlike.app.databinding.PermissionsBinding;
import androidx.annotation.NonNull;

public class PermissionsActivity extends AppCompatActivity {

  private PermissionsBinding binding;
  public final int REQ_CD_PICKVIDEO = 101;
  public static final int REQCODE_STORAGE = 1009;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = PermissionsBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    binding.allow.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            requestStorage();
          }
        });
  }

  @Override
  public void onResume() {
    super.onResume();
    if (isStoragePermissionGranted()) {
      onStorageGranted();
    }
  }

  protected void requestStorage() {
    ActivityCompat.requestPermissions(
        this,
        new String[] {
          Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
        },
        REQCODE_STORAGE);
  }

  protected void onStorageGranted() {
    if (getIntent().getStringExtra("TEMPLATE").equals("TEMPLATE1")) {
      final Intent MainPage = new Intent();
      MainPage.setClass(getApplicationContext(), MainActivity.class);
      MainPage.putExtra("TEMPLATE", "TEMPLATE1");
      MainPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
      startActivity(MainPage);
    } else if (getIntent().getStringExtra("TEMPLATE").equals("TEMPLATE2")) {
      final Intent PICKVIDEO =
          new Intent(
              Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
      PICKVIDEO.setType("video/*");
      startActivityForResult(PICKVIDEO, REQ_CD_PICKVIDEO);
    }
  }

  protected void onStorageDenied() {
    final Intent AppSettings =
        new Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
    AppSettings.addCategory(Intent.CATEGORY_DEFAULT);
    AppSettings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivityForResult(AppSettings, 50);
  }

  @Override
  public void onRequestPermissionsResult(
      int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == REQCODE_STORAGE) {
      if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        onStorageGranted();
      else onStorageDenied();
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

  protected boolean isStoragePermissionGranted() {
    return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED
        && ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED;
  }
}

