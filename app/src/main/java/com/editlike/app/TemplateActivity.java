package com.editlike.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.widget.LinearLayout;
import android.os.*;
import android.graphics.Color;
import android.view.*;
import android.view.View.*;
import android.content.Intent;
import com.editlike.app.TemplateActivity;
import io.michaelrocks.paranoid.Obfuscate;
import com.editlike.app.databinding.TemplateBinding;

@Obfuscate
public class TemplateActivity extends AppCompatActivity {

  private TemplateBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    binding = TemplateBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    // template1 button on clicked
    binding.template1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            final Intent MainPage = new Intent();
            MainPage.setClass(getApplicationContext(), MainActivity.class);
            MainPage.putExtra("TEMPLATE", "TEMPLATE1");
            MainPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(MainPage);
          }
        });

    // template2 buuton on clicked
    binding.template2.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            final Intent MainPage = new Intent();
            MainPage.setClass(getApplicationContext(), MainActivity.class);
            MainPage.putExtra("TEMPLATE", "TEMPLATE2");
            MainPage.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(MainPage);
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

    android.graphics.drawable.GradientDrawable gd001 =
        new android.graphics.drawable.GradientDrawable(
            android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM,
            new int[] {0xFF7289DA, 0xFF353c57});
    gd001.setCornerRadius(0f);
    binding.base.setBackgroundDrawable(gd001);
  }

  @Override
  public void onBackPressed() {
    finishAffinity();
  }
}

