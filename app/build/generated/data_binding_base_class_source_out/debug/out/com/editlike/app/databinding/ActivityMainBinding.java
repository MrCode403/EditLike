// Generated by view binder compiler. Do not edit!
package com.editlike.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.editlike.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final CoordinatorLayout Coordinator;

  @NonNull
  public final LinearLayout background;

  @NonNull
  public final LinearLayout backgroundbutton;

  @NonNull
  public final LinearLayout bottombackground;

  @NonNull
  public final LinearLayout bottombar;

  @NonNull
  public final LinearLayout bottommainbar;

  @NonNull
  public final LinearLayout descriptionbutton;

  @NonNull
  public final FloatingActionButton expandfab;

  @NonNull
  public final ImageView imageview10;

  @NonNull
  public final ImageView imageview6;

  @NonNull
  public final ImageView imageview7;

  @NonNull
  public final ImageView imageview8;

  @NonNull
  public final ImageView imageview9;

  @NonNull
  public final FloatingActionButton savefab;

  @NonNull
  public final LinearLayout statusbarbutton;

  @NonNull
  public final TextView textview10;

  @NonNull
  public final TextView textview11;

  @NonNull
  public final TextView textview12;

  @NonNull
  public final TextView textview8;

  @NonNull
  public final TextView textview9;

  @NonNull
  public final LinearLayout toolbarbutton;

  @NonNull
  public final LinearLayout videobutton;

  @NonNull
  public final RelativeLayout viewcontainer;

  private ActivityMainBinding(@NonNull CoordinatorLayout rootView,
      @NonNull CoordinatorLayout Coordinator, @NonNull LinearLayout background,
      @NonNull LinearLayout backgroundbutton, @NonNull LinearLayout bottombackground,
      @NonNull LinearLayout bottombar, @NonNull LinearLayout bottommainbar,
      @NonNull LinearLayout descriptionbutton, @NonNull FloatingActionButton expandfab,
      @NonNull ImageView imageview10, @NonNull ImageView imageview6, @NonNull ImageView imageview7,
      @NonNull ImageView imageview8, @NonNull ImageView imageview9,
      @NonNull FloatingActionButton savefab, @NonNull LinearLayout statusbarbutton,
      @NonNull TextView textview10, @NonNull TextView textview11, @NonNull TextView textview12,
      @NonNull TextView textview8, @NonNull TextView textview9, @NonNull LinearLayout toolbarbutton,
      @NonNull LinearLayout videobutton, @NonNull RelativeLayout viewcontainer) {
    this.rootView = rootView;
    this.Coordinator = Coordinator;
    this.background = background;
    this.backgroundbutton = backgroundbutton;
    this.bottombackground = bottombackground;
    this.bottombar = bottombar;
    this.bottommainbar = bottommainbar;
    this.descriptionbutton = descriptionbutton;
    this.expandfab = expandfab;
    this.imageview10 = imageview10;
    this.imageview6 = imageview6;
    this.imageview7 = imageview7;
    this.imageview8 = imageview8;
    this.imageview9 = imageview9;
    this.savefab = savefab;
    this.statusbarbutton = statusbarbutton;
    this.textview10 = textview10;
    this.textview11 = textview11;
    this.textview12 = textview12;
    this.textview8 = textview8;
    this.textview9 = textview9;
    this.toolbarbutton = toolbarbutton;
    this.videobutton = videobutton;
    this.viewcontainer = viewcontainer;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CoordinatorLayout Coordinator = (CoordinatorLayout) rootView;

      id = R.id.background;
      LinearLayout background = ViewBindings.findChildViewById(rootView, id);
      if (background == null) {
        break missingId;
      }

      id = R.id.backgroundbutton;
      LinearLayout backgroundbutton = ViewBindings.findChildViewById(rootView, id);
      if (backgroundbutton == null) {
        break missingId;
      }

      id = R.id.bottombackground;
      LinearLayout bottombackground = ViewBindings.findChildViewById(rootView, id);
      if (bottombackground == null) {
        break missingId;
      }

      id = R.id.bottombar;
      LinearLayout bottombar = ViewBindings.findChildViewById(rootView, id);
      if (bottombar == null) {
        break missingId;
      }

      id = R.id.bottommainbar;
      LinearLayout bottommainbar = ViewBindings.findChildViewById(rootView, id);
      if (bottommainbar == null) {
        break missingId;
      }

      id = R.id.descriptionbutton;
      LinearLayout descriptionbutton = ViewBindings.findChildViewById(rootView, id);
      if (descriptionbutton == null) {
        break missingId;
      }

      id = R.id.expandfab;
      FloatingActionButton expandfab = ViewBindings.findChildViewById(rootView, id);
      if (expandfab == null) {
        break missingId;
      }

      id = R.id.imageview10;
      ImageView imageview10 = ViewBindings.findChildViewById(rootView, id);
      if (imageview10 == null) {
        break missingId;
      }

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

      id = R.id.savefab;
      FloatingActionButton savefab = ViewBindings.findChildViewById(rootView, id);
      if (savefab == null) {
        break missingId;
      }

      id = R.id.statusbarbutton;
      LinearLayout statusbarbutton = ViewBindings.findChildViewById(rootView, id);
      if (statusbarbutton == null) {
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

      id = R.id.textview12;
      TextView textview12 = ViewBindings.findChildViewById(rootView, id);
      if (textview12 == null) {
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

      id = R.id.toolbarbutton;
      LinearLayout toolbarbutton = ViewBindings.findChildViewById(rootView, id);
      if (toolbarbutton == null) {
        break missingId;
      }

      id = R.id.videobutton;
      LinearLayout videobutton = ViewBindings.findChildViewById(rootView, id);
      if (videobutton == null) {
        break missingId;
      }

      id = R.id.viewcontainer;
      RelativeLayout viewcontainer = ViewBindings.findChildViewById(rootView, id);
      if (viewcontainer == null) {
        break missingId;
      }

      return new ActivityMainBinding((CoordinatorLayout) rootView, Coordinator, background,
          backgroundbutton, bottombackground, bottombar, bottommainbar, descriptionbutton,
          expandfab, imageview10, imageview6, imageview7, imageview8, imageview9, savefab,
          statusbarbutton, textview10, textview11, textview12, textview8, textview9, toolbarbutton,
          videobutton, viewcontainer);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
