// Generated by view binder compiler. Do not edit!
package com.editlike.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.editlike.app.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class VideosizeviewBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imageview6;

  @NonNull
  public final ImageView imageview7;

  @NonNull
  public final ImageView imageview8;

  @NonNull
  public final ImageView imageview9;

  @NonNull
  public final LinearLayout linear0;

  @NonNull
  public final LinearLayout replacebutton;

  @NonNull
  public final LinearLayout soundbutton;

  @NonNull
  public final TextView textview10;

  @NonNull
  public final TextView textview11;

  @NonNull
  public final TextView textview8;

  @NonNull
  public final TextView textview9;

  @NonNull
  public final LinearLayout trimbarbackground;

  @NonNull
  public final LinearLayout trimbarview;

  @NonNull
  public final LinearLayout trimbutton;

  @NonNull
  public final LinearLayout videosizebackground;

  @NonNull
  public final LinearLayout videosizebutton;

  @NonNull
  public final SeekBar videosizeseekbar;

  private VideosizeviewBinding(@NonNull LinearLayout rootView, @NonNull ImageView imageview6,
      @NonNull ImageView imageview7, @NonNull ImageView imageview8, @NonNull ImageView imageview9,
      @NonNull LinearLayout linear0, @NonNull LinearLayout replacebutton,
      @NonNull LinearLayout soundbutton, @NonNull TextView textview10, @NonNull TextView textview11,
      @NonNull TextView textview8, @NonNull TextView textview9,
      @NonNull LinearLayout trimbarbackground, @NonNull LinearLayout trimbarview,
      @NonNull LinearLayout trimbutton, @NonNull LinearLayout videosizebackground,
      @NonNull LinearLayout videosizebutton, @NonNull SeekBar videosizeseekbar) {
    this.rootView = rootView;
    this.imageview6 = imageview6;
    this.imageview7 = imageview7;
    this.imageview8 = imageview8;
    this.imageview9 = imageview9;
    this.linear0 = linear0;
    this.replacebutton = replacebutton;
    this.soundbutton = soundbutton;
    this.textview10 = textview10;
    this.textview11 = textview11;
    this.textview8 = textview8;
    this.textview9 = textview9;
    this.trimbarbackground = trimbarbackground;
    this.trimbarview = trimbarview;
    this.trimbutton = trimbutton;
    this.videosizebackground = videosizebackground;
    this.videosizebutton = videosizebutton;
    this.videosizeseekbar = videosizeseekbar;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static VideosizeviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static VideosizeviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.videosizeview, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static VideosizeviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageview6;
      ImageView imageview6 = ViewBindings.findChildViewById(rootView, id);
      if (imageview6 == null) {
        break missingId;
      }

      id = R.id.imageview7;
      ImageView imageview7 = ViewBindings.findChildViewById(rootView, id);
      if (imageview7 == null) {
        break missingId;
      }

      id = R.id.imageview8;
      ImageView imageview8 = ViewBindings.findChildViewById(rootView, id);
      if (imageview8 == null) {
        break missingId;
      }

      id = R.id.imageview9;
      ImageView imageview9 = ViewBindings.findChildViewById(rootView, id);
      if (imageview9 == null) {
        break missingId;
      }

      id = R.id.linear0;
      LinearLayout linear0 = ViewBindings.findChildViewById(rootView, id);
      if (linear0 == null) {
        break missingId;
      }

      id = R.id.replacebutton;
      LinearLayout replacebutton = ViewBindings.findChildViewById(rootView, id);
      if (replacebutton == null) {
        break missingId;
      }

      id = R.id.soundbutton;
      LinearLayout soundbutton = ViewBindings.findChildViewById(rootView, id);
      if (soundbutton == null) {
        break missingId;
      }

      id = R.id.textview10;
      TextView textview10 = ViewBindings.findChildViewById(rootView, id);
      if (textview10 == null) {
        break missingId;
      }

      id = R.id.textview11;
      TextView textview11 = ViewBindings.findChildViewById(rootView, id);
      if (textview11 == null) {
        break missingId;
      }

      id = R.id.textview8;
      TextView textview8 = ViewBindings.findChildViewById(rootView, id);
      if (textview8 == null) {
        break missingId;
      }

      id = R.id.textview9;
      TextView textview9 = ViewBindings.findChildViewById(rootView, id);
      if (textview9 == null) {
        break missingId;
      }

      id = R.id.trimbarbackground;
      LinearLayout trimbarbackground = ViewBindings.findChildViewById(rootView, id);
      if (trimbarbackground == null) {
        break missingId;
      }

      id = R.id.trimbarview;
      LinearLayout trimbarview = ViewBindings.findChildViewById(rootView, id);
      if (trimbarview == null) {
        break missingId;
      }

      id = R.id.trimbutton;
      LinearLayout trimbutton = ViewBindings.findChildViewById(rootView, id);
      if (trimbutton == null) {
        break missingId;
      }

      id = R.id.videosizebackground;
      LinearLayout videosizebackground = ViewBindings.findChildViewById(rootView, id);
      if (videosizebackground == null) {
        break missingId;
      }

      id = R.id.videosizebutton;
      LinearLayout videosizebutton = ViewBindings.findChildViewById(rootView, id);
      if (videosizebutton == null) {
        break missingId;
      }

      id = R.id.videosizeseekbar;
      SeekBar videosizeseekbar = ViewBindings.findChildViewById(rootView, id);
      if (videosizeseekbar == null) {
        break missingId;
      }

      return new VideosizeviewBinding((LinearLayout) rootView, imageview6, imageview7, imageview8,
          imageview9, linear0, replacebutton, soundbutton, textview10, textview11, textview8,
          textview9, trimbarbackground, trimbarview, trimbutton, videosizebackground,
          videosizebutton, videosizeseekbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
