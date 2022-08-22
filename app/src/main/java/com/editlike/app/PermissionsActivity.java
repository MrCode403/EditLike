package com.editlike.app;

import android.os.Bundle;
import android.app.*;
import android.os.*;
import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.editlike.app.databinding.PermissionsBinding;

public class PermissionsActivity extends AppCompatActivity {

  private PermissionsBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = PermissionsBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    binding.allow.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Permission();
          }
        });
  }

  public void Permission() {
    // IF ANDROID VERSION IS LESS THAN ANDROID 9 (API 29) ~~
    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_DENIED
        || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_DENIED) {
      ActivityCompat.requestPermissions(
          this,
          new String[] {
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
          },
          1000);
    }
  }

  @Override
  public void onRequestPermissionsResult(
      int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == 1000) {
      if (requestCode == Activity.RESULT_OK) {
        final Intent MainPage = new Intent();
        MainPage.setClass(getApplicationContext(), MainActivity.class);
        MainPage.putExtra("TEMPLATE", getIntent().getStringExtra("TEMPLATE"));
        MainPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(MainPage);
        finish();
      } else {
        Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
      }
    }
  }
}

