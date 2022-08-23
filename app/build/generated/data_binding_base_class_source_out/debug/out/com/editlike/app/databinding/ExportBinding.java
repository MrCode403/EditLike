// Generated by view binder compiler. Do not edit!
package com.editlike.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.editlike.app.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ExportBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout banneradview;

  @NonNull
  public final LinearLayout exportingview;

  @NonNull
  public final ImageView imageview2;

  @NonNull
  public final ImageView imageview3;

  @NonNull
  public final ImageView imageview4;

  @NonNull
  public final LinearLayout linear2;

  @NonNull
  public final LinearLayout linear5;

  @NonNull
  public final LinearLayout linear6;

  @NonNull
  public final LinearLayout linear8;

  @NonNull
  public final LinearLayout linear9;

  @NonNull
  public final ProgressBar progressbar1;

  @NonNull
  public final LinearLayout savedview;

  @NonNull
  public final LinearLayout sharebutton;

  @NonNull
  public final TextView textview1;

  @NonNull
  public final TextView textview3;

  @NonNull
  public final TextView textview4;

  @NonNull
  public final TextView textview5;

  private ExportBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout banneradview,
      @NonNull LinearLayout exportingview, @NonNull ImageView imageview2,
      @NonNull ImageView imageview3, @NonNull ImageView imageview4, @NonNull LinearLayout linear2,
      @NonNull LinearLayout linear5, @NonNull LinearLayout linear6, @NonNull LinearLayout linear8,
      @NonNull LinearLayout linear9, @NonNull ProgressBar progressbar1,
      @NonNull LinearLayout savedview, @NonNull LinearLayout sharebutton,
      @NonNull TextView textview1, @NonNull TextView textview3, @NonNull TextView textview4,
      @NonNull TextView textview5) {
    this.rootView = rootView;
    this.banneradview = banneradview;
    this.exportingview = exportingview;
    this.imageview2 = imageview2;
    this.imageview3 = imageview3;
    this.imageview4 = imageview4;
    this.linear2 = linear2;
    this.linear5 = linear5;
    this.linear6 = linear6;
    this.linear8 = linear8;
    this.linear9 = linear9;
    this.progressbar1 = progressbar1;
    this.savedview = savedview;
    this.sharebutton = sharebutton;
    this.textview1 = textview1;
    this.textview3 = textview3;
    this.textview4 = textview4;
    this.textview5 = textview5;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ExportBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ExportBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.export, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ExportBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.banneradview;
      LinearLayout banneradview = ViewBindings.findChildViewById(rootView, id);
      if (banneradview == null) {
        break missingId;
      }

      id = R.id.exportingview;
      LinearLayout exportingview = ViewBindings.findChildViewById(rootView, id);
      if (exportingview == null) {
        break missingId;
      }

      id = R.id.imageview2;
      ImageView imageview2 = ViewBindings.findChildViewById(rootView, id);
      if (imageview2 == null) {
        break missingId;
      }

      id = R.id.imageview3;
      ImageView imageview3 = ViewBindings.findChildViewById(rootView, id);
      if (imageview3 == null) {
        break missingId;
      }

      id = R.id.imageview4;
      ImageView imageview4 = ViewBindings.findChildViewById(rootView, id);
      if (imageview4 == null) {
        break missingId;
      }

      id = R.id.linear2;
      LinearLayout linear2 = ViewBindings.findChildViewById(rootView, id);
      if (linear2 == null) {
        break missingId;
      }

      id = R.id.linear5;
      LinearLayout linear5 = ViewBindings.findChildViewById(rootView, id);
      if (linear5 == null) {
        break missingId;
      }

      id = R.id.linear6;
      LinearLayout linear6 = ViewBindings.findChildViewById(rootView, id);
      if (linear6 == null) {
        break missingId;
      }

      id = R.id.linear8;
      LinearLayout linear8 = ViewBindings.findChildViewById(rootView, id);
      if (linear8 == null) {
        break missingId;
      }

      id = R.id.linear9;
      LinearLayout linear9 = ViewBindings.findChildViewById(rootView, id);
      if (linear9 == null) {
        break missingId;
      }

      id = R.id.progressbar1;
      ProgressBar progressbar1 = ViewBindings.findChildViewById(rootView, id);
      if (progressbar1 == null) {
        break missingId;
      }

      id = R.id.savedview;
      LinearLayout savedview = ViewBindings.findChildViewById(rootView, id);
      if (savedview == null) {
        break missingId;
      }

      id = R.id.sharebutton;
      LinearLayout sharebutton = ViewBindings.findChildViewById(rootView, id);
      if (sharebutton == null) {
        break missingId;
      }

      id = R.id.textview1;
      TextView textview1 = ViewBindings.findChildViewById(rootView, id);
      if (textview1 == null) {
        break missingId;
      }

      id = R.id.textview3;
      TextView textview3 = ViewBindings.findChildViewById(rootView, id);
      if (textview3 == null) {
        break missingId;
      }

      id = R.id.textview4;
      TextView textview4 = ViewBindings.findChildViewById(rootView, id);
      if (textview4 == null) {
        break missingId;
      }

      id = R.id.textview5;
      TextView textview5 = ViewBindings.findChildViewById(rootView, id);
      if (textview5 == null) {
        break missingId;
      }

      return new ExportBinding((LinearLayout) rootView, banneradview, exportingview, imageview2,
          imageview3, imageview4, linear2, linear5, linear6, linear8, linear9, progressbar1,
          savedview, sharebutton, textview1, textview3, textview4, textview5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
