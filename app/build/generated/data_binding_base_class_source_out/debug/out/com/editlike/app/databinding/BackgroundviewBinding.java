// Generated by view binder compiler. Do not edit!
package com.editlike.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.editlike.app.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BackgroundviewBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout addbackgroundvideobutton;

  @NonNull
  public final LinearLayout choosecolorbutton;

  @NonNull
  public final ImageView imageview6;

  @NonNull
  public final ImageView imageview8;

  @NonNull
  public final LinearLayout linear1;

  @NonNull
  public final TextView textview10;

  @NonNull
  public final TextView textview8;

  private BackgroundviewBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout addbackgroundvideobutton, @NonNull LinearLayout choosecolorbutton,
      @NonNull ImageView imageview6, @NonNull ImageView imageview8, @NonNull LinearLayout linear1,
      @NonNull TextView textview10, @NonNull TextView textview8) {
    this.rootView = rootView;
    this.addbackgroundvideobutton = addbackgroundvideobutton;
    this.choosecolorbutton = choosecolorbutton;
    this.imageview6 = imageview6;
    this.imageview8 = imageview8;
    this.linear1 = linear1;
    this.textview10 = textview10;
    this.textview8 = textview8;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static BackgroundviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BackgroundviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.backgroundview, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BackgroundviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addbackgroundvideobutton;
      LinearLayout addbackgroundvideobutton = ViewBindings.findChildViewById(rootView, id);
      if (addbackgroundvideobutton == null) {
        break missingId;
      }

      id = R.id.choosecolorbutton;
      LinearLayout choosecolorbutton = ViewBindings.findChildViewById(rootView, id);
      if (choosecolorbutton == null) {
        break missingId;
      }

      id = R.id.imageview6;
      ImageView imageview6 = ViewBindings.findChildViewById(rootView, id);
      if (imageview6 == null) {
        break missingId;
      }

      id = R.id.imageview8;
      ImageView imageview8 = ViewBindings.findChildViewById(rootView, id);
      if (imageview8 == null) {
        break missingId;
      }

      id = R.id.linear1;
      LinearLayout linear1 = ViewBindings.findChildViewById(rootView, id);
      if (linear1 == null) {
        break missingId;
      }

      id = R.id.textview10;
      TextView textview10 = ViewBindings.findChildViewById(rootView, id);
      if (textview10 == null) {
        break missingId;
      }

      id = R.id.textview8;
      TextView textview8 = ViewBindings.findChildViewById(rootView, id);
      if (textview8 == null) {
        break missingId;
      }

      return new BackgroundviewBinding((LinearLayout) rootView, addbackgroundvideobutton,
          choosecolorbutton, imageview6, imageview8, linear1, textview10, textview8);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}