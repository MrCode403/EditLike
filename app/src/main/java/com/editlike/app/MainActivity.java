package com.editlike.app;

import android.Manifest;
import android.app.Activity;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.graphics.*;
import android.graphics.drawable.*;
import android.content.res.*;
import android.net.Uri;
import android.app.*;
import android.content.*;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.flask.colorpicker.*;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import de.hdodenhof.circleimageview.*;
import io.michaelrocks.paranoid.Obfuscate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import android.view.ViewGroup;
import android.os.*;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import org.json.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import com.unity3d.services.banners.IUnityBannerListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.UnityBanners;

@Obfuscate
public class MainActivity extends AppCompatActivity {

  private RelativeLayout viewcontainer;
  private LinearLayout background;
  private LinearLayout bottombackground;
  private LinearLayout toolbar;
  private EditText description;
  private LinearLayout container;
  private LinearLayout statusbar;
  private CircleImageView profilephoto;
  private LinearLayout linear3;
  private ImageView dot3;
  private EditText name;
  private EditText username;
  private LinearLayout addfile;
  private VideoView videoview1;
  private ImageView imageview5;
  private TextView time;
  private TextView textview7;
  private TextView date;
  private TextView textview6;
  private LinearLayout bottommainbar;
  private LinearLayout bottombar;
  private LinearLayout toolbarbutton;
  private LinearLayout statusbarbutton;
  private LinearLayout backgroundbutton;
  private LinearLayout descriptionbutton;
  private LinearLayout videobutton;
  private ImageView imageview6;
  private TextView textview8;
  private ImageView imageview7;
  private TextView textview9;
  private ImageView imageview10;
  private TextView textview12;
  private ImageView imageview9;
  private TextView textview11;
  private ImageView imageview8;
  private TextView textview10;
  private RelativeLayout ground;
  private LinearLayout backgroundvideoview;

  private FloatingActionButton savefab;
  private FloatingActionButton expandfab;
  private LinearLayout toolbarview;
  private LinearLayout statusbarview;
  private LinearLayout backgroundview;
  private LinearLayout descriptionview;
  private LinearLayout videosizeview;
  private TrimTimelineView TrimView;
  private LinearLayout backgroundlayout;
  private VideoView vidview;

  private Timer timer1 = new Timer();
  private TimerTask settimer1;
  private MediaPlayer mp;

  private String STARTTIMEvar = "";
  private String ENDTIMEvar = "";
  private String STARTTIMEinmillivar = "";
  private String ENDTIMEinmillivar = "";

  private String videopath = "";
  private double containerheight = 0;
  private double containerwidth = 0;
  private boolean VIDEOTRIMMED = false;
  private boolean videomuted = false;
  public final int REQ_CD_PICKVIDEO = 101;
  public final int REQ_CD_PICKPROFILEPHOTO = 102;
  public final int REQ_CD_CROPPHOTO = 103;
  public final int REQ_CD_BACKGROUNDVIDEO = 104;
  public final int REQUEST_TRIM = 800;
  public String BOTTOMBARLAYOUT = "";

  private String GameID = "000000";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    /* APP LOGS GENERATOR (com.itsaky.androidide.logsender.LogSender) */

    /* SET XML LAYOUT - activity_main.xml (res/layout) */
    setContentView(R.layout.activity_main);

    /* SET XML LAYOUT INFLATOR - toolbarview.xml (res/layout) */
    toolbarview =
        (LinearLayout) this.getLayoutInflater().inflate(R.layout.toolbarview, bottommainbar, false);

    /* SET XML LAYOUT INFLATOR - statusbarview.xml (res/layout) */
    statusbarview =
        (LinearLayout)
            this.getLayoutInflater().inflate(R.layout.statusbarview, bottommainbar, false);

    /* SET XML LAYOUT INFLATOR - backgroundview.xml (res/layout) */
    backgroundview =
        (LinearLayout)
            this.getLayoutInflater().inflate(R.layout.backgroundview, bottommainbar, false);

    /* SET XML LAYOUT INFLATOR - descriptionview.xml (res/layout) */
    descriptionview =
        (LinearLayout)
            this.getLayoutInflater().inflate(R.layout.descriptionview, bottommainbar, false);

    /* SET XML LAYOUT INFLATOR - videosizeview.xml (res/layout) */
    videosizeview =
        (LinearLayout)
            this.getLayoutInflater().inflate(R.layout.videosizeview, bottommainbar, false);

    /**/
    backgroundlayout =
        (LinearLayout)
            this.getLayoutInflater().inflate(R.layout.backgroundlayout, background, false);

    // FIND VIEWS BY ID FROM XML LAYOUT - activity_main.xml (res/layout) ~~
    savefab = findViewById(R.id.savefab);
    expandfab = findViewById(R.id.expandfab);
    viewcontainer = findViewById(R.id.viewcontainer);
    background = findViewById(R.id.background);
    bottombackground = findViewById(R.id.bottombackground);
    bottommainbar = findViewById(R.id.bottommainbar);
    bottombar = findViewById(R.id.bottombar);
    toolbarbutton = findViewById(R.id.toolbarbutton);
    statusbarbutton = findViewById(R.id.statusbarbutton);
    backgroundbutton = findViewById(R.id.backgroundbutton);
    descriptionbutton = findViewById(R.id.descriptionbutton);
    videobutton = findViewById(R.id.videobutton);
    imageview6 = findViewById(R.id.imageview6);
    textview8 = findViewById(R.id.textview8);
    imageview7 = findViewById(R.id.imageview7);
    textview9 = findViewById(R.id.textview9);
    imageview10 = findViewById(R.id.imageview10);
    textview12 = findViewById(R.id.textview12);
    imageview9 = findViewById(R.id.imageview9);
    textview11 = findViewById(R.id.textview11);
    imageview8 = findViewById(R.id.imageview8);
    textview10 = findViewById(R.id.textview10);

    toolbar = (LinearLayout) backgroundlayout.findViewById(R.id.toolbar);
    description = (EditText) backgroundlayout.findViewById(R.id.description);
    container = (LinearLayout) backgroundlayout.findViewById(R.id.container);
    statusbar = (LinearLayout) backgroundlayout.findViewById(R.id.statusbar);
    profilephoto = (CircleImageView) backgroundlayout.findViewById(R.id.profilephoto);
    linear3 = (LinearLayout) backgroundlayout.findViewById(R.id.linear3);
    dot3 = (ImageView) backgroundlayout.findViewById(R.id.dot3);
    name = (EditText) backgroundlayout.findViewById(R.id.name);
    username = (EditText) backgroundlayout.findViewById(R.id.username);
    addfile = (LinearLayout) backgroundlayout.findViewById(R.id.addfile);
    videoview1 = (VideoView) backgroundlayout.findViewById(R.id.videoview1);
    imageview5 = (ImageView) backgroundlayout.findViewById(R.id.imageview5);
    time = (TextView) backgroundlayout.findViewById(R.id.time);
    date = (TextView) backgroundlayout.findViewById(R.id.date);
    textview7 = (TextView) backgroundlayout.findViewById(R.id.textview7);
    textview6 = (TextView) backgroundlayout.findViewById(R.id.textview6);
    ground = (RelativeLayout) backgroundlayout.findViewById(R.id.ground);
    backgroundvideoview = (LinearLayout) backgroundlayout.findViewById(R.id.backgroundvideoview);

    // FIND VIEW BY ID FROM XML LAYOUT - toolbar.xml (res/layout) ~~
    LinearLayout showhidetoolbar = (LinearLayout) toolbarview.findViewById(R.id.showhidetoolbar);
    LinearLayout showhide3dot = (LinearLayout) toolbarview.findViewById(R.id.showhide3dot);

    // FIND VIEW BY ID FROM XML LAYOUT - statusbarview.xml (res/layout) ~~
    LinearLayout showhidestatusbar =
        (LinearLayout) statusbarview.findViewById(R.id.showhidestatusbar);

    // FIND VIEW BY ID FROM XML LAYOUT - backgroundview.xml (res/layout) ~~
    LinearLayout choosecolorbutton =
        (LinearLayout) backgroundview.findViewById(R.id.choosecolorbutton);
    LinearLayout addbackgroundvideobutton =
        (LinearLayout) backgroundview.findViewById(R.id.addbackgroundvideobutton);

    // FIND VIEW BY ID FROM XML LAYOUT - descriptionview.xml (res/layout) ~~
    LinearLayout showhidedescriptionbutton =
        (LinearLayout) descriptionview.findViewById(R.id.showhidedescriptionbutton);

    // FIND VIEW BY ID FROM XML LAYOUT - videosizeview.xml (res/layout) ~~
    SeekBar videosizeseekbar = (SeekBar) videosizeview.findViewById(R.id.videosizeseekbar);
    LinearLayout trimbutton = (LinearLayout) videosizeview.findViewById(R.id.trimbutton);
    LinearLayout trimbarview = (LinearLayout) videosizeview.findViewById(R.id.trimbarview);
    LinearLayout trimbarbackground =
        (LinearLayout) videosizeview.findViewById(R.id.trimbarbackground);
    LinearLayout linear0 = (LinearLayout) videosizeview.findViewById(R.id.linear0);
    LinearLayout videosizebutton = (LinearLayout) videosizeview.findViewById(R.id.videosizebutton);
    LinearLayout videosizebackground =
        (LinearLayout) videosizeview.findViewById(R.id.videosizebackground);
    LinearLayout replacebutton = (LinearLayout) videosizeview.findViewById(R.id.replacebutton);
    LinearLayout soundbutton = (LinearLayout) videosizeview.findViewById(R.id.soundbutton);
    ImageView imageview9 = (ImageView) videosizeview.findViewById(R.id.imageview9);

    // EVERYTHING ON INITIALISE ~~
    if (getIntent().hasExtra("TEMPLATE")) {
      if (getIntent().getStringExtra("TEMPLATE").equals("TEMPLATE1")) {
        addbackgroundvideobutton.setVisibility(View.GONE);
      } else {
        addbackgroundvideobutton.setVisibility(View.VISIBLE);
        container.setVisibility(View.GONE);
      }
    } else {
      final Intent TEMPLATEPAGE = new Intent();
      TEMPLATEPAGE.setClass(getApplicationContext(), TemplateActivity.class);
      TEMPLATEPAGE.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
      startActivity(TEMPLATEPAGE);
    }

    imageview9.setTag("sound");
    MediaController videoview1_controller = new MediaController(this);
    videoview1.setMediaController(videoview1_controller);
    addfile.setVisibility(View.VISIBLE);
    videoview1.setVisibility(View.GONE);
    videoview1.setMediaController(null);
    bottombackground.setVisibility(View.GONE);
    linear0.setVisibility(View.VISIBLE);
    trimbarbackground.setVisibility(View.GONE);
    videosizebackground.setVisibility(View.GONE);
    videosizeseekbar
        .getProgressDrawable()
        .setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
    videosizeseekbar.getThumb().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);

    background.addView(backgroundlayout);

    UnityAds.initialize(this, GameID, false);

    // ASK/REQUEST PERMISSIONS ~~
    Permission();

    // SET TIME AND DATE ~~
    SETTIMEANDDATE();

    // VIDEO TRIM VIEW ~~
    TrimView = new TrimTimelineView(this);
    trimbarview.addView(TrimView);
    TrimView.setIconColors(0xFFFFB74D);
    TrimView.setTimelineColor(0xFFFFB74D);
    TrimView.setColor(0xFFFFB74D);
    TrimView.setRadius(10);
    TrimView.setPlayLineEnabled(false);
    TrimView.setListener(
        new TrimTimelineViewListener() {
          @Override
          public void onLeftProgressChanged(float progress) {
            STARTTIMEvar = ReadableDurationString((int) progress);
            STARTTIMEinmillivar = Float.toString(progress).replace(".0", "");
            videoview1.seekTo(Integer.parseInt(Float.toString(progress).replace(".0", "")));
            VIDEOTRIMMED = true;
          }

          @Override
          public void onRightProgressChanged(float progress) {
            ENDTIMEvar = ReadableDurationString((int) progress);
            ENDTIMEinmillivar = Float.toString(progress).replace(".0", "");
            VIDEOTRIMMED = true;
            HANDLESTOP();
          }
        });

    // SAVEFAB (FABVIEW) ON CLICKED ~~
    savefab.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (bottombackground.getVisibility() == View.VISIBLE) {
              FABTRANSITION();
            }
            final double videopositionY = container.getTop();
            final double videoscalex = videoview1.getWidth();
            final double videoscaley = videoview1.getHeight();
            final double backgroundheight = background.getWidth();
            final double backgroundwidth = background.getHeight();
            if (!(videopath.length() == 0)) {
              FileUtil.deleteFile("/storage/emulated/0/DCIM/save.png");
              videoview1.setBackgroundColor(0xFFFFFFFF);
              viewToImage(background, "/storage/emulated/0/DCIM/save.png");
              Intent EXPORTPAGE = new Intent();
              EXPORTPAGE.setClass(getApplicationContext(), ExportActivity.class);
              EXPORTPAGE.putExtra("VIDEOPATH", videopath);
              EXPORTPAGE.putExtra("VIDEOPOSITIONY", String.valueOf(videopositionY));
              EXPORTPAGE.putExtra("VIDEOSCALEX", String.valueOf(videoscalex));
              EXPORTPAGE.putExtra("VIDEOSCALEY", String.valueOf(videoscaley));
              EXPORTPAGE.putExtra("BACKGROUNDHEIGHT", String.valueOf(backgroundheight));
              EXPORTPAGE.putExtra("BACKGROUNDWIDTH", String.valueOf(backgroundwidth));
              EXPORTPAGE.putExtra("DURATION", String.valueOf(videoview1.getDuration()));
              if (VIDEOTRIMMED) {
                EXPORTPAGE.putExtra("STARTTIME", STARTTIMEvar);
              }
              if (VIDEOTRIMMED) {
                EXPORTPAGE.putExtra("ENDTIME", ENDTIMEvar);
              }
              EXPORTPAGE.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
              startActivity(EXPORTPAGE);
            } else {
              Toast.makeText(getApplicationContext(), "Must add video", Toast.LENGTH_SHORT).show();
            }
          }
        });

    // USERNAME (EDITTEXT) ON CLICKED ~~
    username.setOnFocusChangeListener(
        new OnFocusChangeListener() {
          @Override
          public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
              username.setHint("type a username here...");
            } else {
              username.setHint("@enterusername");
            }
          }
        });

    // NAME (EDITTEXT) ON CLICKED ~~
    name.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            name.setHint("type a name here...");
            name.setHintTextColor(0xFF9E9E9E);
          }
        });

    name.setOnFocusChangeListener(
        new OnFocusChangeListener() {
          @Override
          public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
              name.setHint("type a name here...");
              name.setHintTextColor(0xFF9E9E9E);
            } else {
              name.setHint("YOUR NAME");
              name.setHintTextColor(0xFF000000);
            }
          }
        });

    // DESCRIPTION (EDITTEXT) ON CLICKED ~~
    description.setOnFocusChangeListener(
        new OnFocusChangeListener() {
          @Override
          public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
              description.setHint("type description here...");
              description.setHintTextColor(0xFF9E9E9E);
            } else {
              description.setHint("Write description here");
              description.setHintTextColor(0xFF000000);
            }
          }
        });

    // ADDFILE (LINEARLAYOUT) ON CLICKED ~~
    addfile.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            // SELECT VIDEO
            containerheight = container.getHeight();
            containerwidth = container.getWidth();
            Intent PICKVIDEO =
                new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            PICKVIDEO.setType("video/*");
            startActivityForResult(PICKVIDEO, REQ_CD_PICKVIDEO);
          }
        });

    // PROFILEPHOTO (IMAGEVIEW) ON CLICKED ~~
    profilephoto.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            // SELECT PROFILEPHOTO IMAGE
            Intent PICKPROFILEPHOTO =
                new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            PICKPROFILEPHOTO.setType("image/*");
            startActivityForResult(PICKPROFILEPHOTO, REQ_CD_PICKPROFILEPHOTO);
          }
        });

    // EXPANDFAB (FABVIEW) ON CLICKED ~~
    expandfab.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            FABTRANSITION();
          }
        });

    // TOOLBAR (LINEARLAYOUT) ON CLICKED ~~
    toolbarbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            bottommainbar.removeView(bottombar);
            bottommainbar.addView(toolbarview);
            BOTTOMBARLAYOUT = "TOOLBAR";
          }
        });

    // STATUSBAR BUTTON (LINEARLAYOUT) ON CLICKED ~~
    statusbarbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            bottommainbar.removeView(bottombar);
            bottommainbar.addView(statusbarview);
            BOTTOMBARLAYOUT = "STATUSBAR";
          }
        });

    // BACKGROUND BUTTON (LINEARLAYOUT) ON CLICKED ~~
    backgroundbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            bottommainbar.removeView(bottombar);
            bottommainbar.addView(backgroundview);
            BOTTOMBARLAYOUT = "BACKGROUND";
          }
        });

    // DESCRIPTION BUTTON (LINEARLAYOUT) ON CLICKED ~~
    descriptionbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            bottommainbar.removeView(bottombar);
            bottommainbar.addView(descriptionview);
            BOTTOMBARLAYOUT = "DESCRIPTION";
          }
        });

    // VIDEOSIZE BUTTON (LINEARLAYOUT) ON CLICKED ~~
    videobutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            bottommainbar.removeView(bottombar);
            bottommainbar.addView(videosizeview);
            BOTTOMBARLAYOUT = "VIDEO";
          }
        });

    // SHOW/HIDE TOOLBAR (LINEARLAYOUT) [toolbarview.xml] ON CLICKED ~~
    showhidetoolbar.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (toolbar.getVisibility() == View.VISIBLE) {
              toolbar.setVisibility(View.GONE);
            } else {
              toolbar.setVisibility(View.VISIBLE);
            }
          }
        });

    // SHOW/HIDE 3 DOT (LINEARLAYOUT) [toolbarview.xml] OM CLICKED ~~
    showhide3dot.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (dot3.getVisibility() == View.VISIBLE) {
              dot3.setVisibility(View.GONE);
            } else {
              dot3.setVisibility(View.VISIBLE);
            }
          }
        });

    // SHOW/HIDE STATUSBAR (LINEARLAYOUT) [statusbarview.xml] ON CLICKED ~~
    showhidestatusbar.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (statusbar.getVisibility() == View.VISIBLE) {
              statusbar.setVisibility(View.GONE);
            } else {
              statusbar.setVisibility(View.VISIBLE);
            }
          }
        });

    // CHANGE BACKGROUND COLOR (LINEARLAYOUT) [backgroundview.xml] ON CLICKED ~~
    choosecolorbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            ColorPickerDialogBuilder.with(MainActivity.this)
                .setTitle(R.string.color_chooser_dialog_title)
                .initialColor(0xFFFFFFFF)
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(15)
                .setOnColorSelectedListener(
                    new OnColorSelectedListener() {
                      @Override
                      public void onColorSelected(int selectedColor) {}
                    })
                .setPositiveButton(
                    "OK",
                    new ColorPickerClickListener() {
                      @Override
                      public void onClick(
                          DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        ground.setBackgroundColor(selectedColor);
                      }
                    })
                .setNegativeButton(
                    "CANCEL",
                    new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {}
                    })
                .build()
                .show();
          }
        });

    addbackgroundvideobutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent BACKGROUNDVIDEO =
                new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            BACKGROUNDVIDEO.setType("video/*");
            startActivityForResult(BACKGROUNDVIDEO, REQ_CD_BACKGROUNDVIDEO);
          }
        });

    // SHOW/HIDE DESCRIPTION (LINEARLAYOUT) [descriptionview.xml] ON CLICKED ~~
    showhidedescriptionbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (description.getVisibility() == View.VISIBLE) {
              description.setVisibility(View.GONE);
            } else {
              description.setVisibility(View.VISIBLE);
            }
          }
        });

    // TRIM (LINEARLAYOUT) [videosizeview.xml] ON CLICKED ~~
    trimbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            linear0.setVisibility(View.GONE);
            videosizebackground.setVisibility(View.GONE);
            trimbarbackground.setVisibility(View.VISIBLE);
          }
        });

    videosizebutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            linear0.setVisibility(View.GONE);
            trimbarbackground.setVisibility(View.GONE);
            videosizebackground.setVisibility(View.VISIBLE);
          }
        });

    replacebutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            // SELECT VIDEO
            Intent REPLACEVIDEO =
                new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            REPLACEVIDEO.setType("video/*");
            startActivityForResult(REPLACEVIDEO, REQ_CD_PICKVIDEO);
          }
        });

    soundbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {

            if (imageview9.getTag() != null && imageview9.getTag().toString().equals("sound")) {
              imageview9.setImageResource(R.drawable.speakermuteicon);
              imageview9.setTag("mute");
              mp.setVolume(0f, 0f);
            } else {
              imageview9.setImageResource(R.drawable.speakericon);
              imageview9.setTag("sound");
              mp.setVolume(1f, 1f);
            }
          }
        });

    // VIDEOSIZESEEKBAR (SEEKBAR) CHANGED ~~
    videosizeseekbar.setOnSeekBarChangeListener(
        new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
            final int progressValue = _param2;
            ChangeViewSize(videoview1, progressValue);
          }

          @Override
          public void onStartTrackingTouch(SeekBar _param1) {}

          @Override
          public void onStopTrackingTouch(SeekBar _param2) {}
        });

    videoview1.setOnPreparedListener(
        new MediaPlayer.OnPreparedListener() {
          @Override
          public void onPrepared(MediaPlayer np) {

            mp = np;
          }
        });

    // VIDEOVIEW1 (VIDEOVIEW) ON COMPLETED ~~
    videoview1.setOnCompletionListener(
        new MediaPlayer.OnCompletionListener() {
          @Override
          public void onCompletion(MediaPlayer mediaPlayer) {
            if (VIDEOTRIMMED) {
              videoview1.seekTo(Integer.parseInt(STARTTIMEinmillivar));
              videoview1.start();
            } else {
              videoview1.start();
            }
          }
        });
  }
  /*«««««««««««««««««««« [ CLOSES ON CREATE ] »»»»»»»»»»»»»»»»»»»»»*/
  /*«««««««««««««««««««« [ CLOSES ON CREATE ] »»»»»»»»»»»»»»»»»»»»»*/
  /*«««««««««««««««««««« [ CLOSES ON CREATE ] »»»»»»»»»»»»»»»»»»»»»*/
  /*«««««««««««««««««««« [ CLOSES ON CREATE ] »»»»»»»»»»»»»»»»»»»»»*/
  /*«««««««««««««««««««« [ CLOSES ON CREATE ] »»»»»»»»»»»»»»»»»»»»»*/

  // ON ACTIVITY RESUMED
  @Override
  public void onResume() {
    super.onResume();
    videoview1.setBackgroundColor(Color.TRANSPARENT);
    if (videoview1 != null) {
      if (VIDEOTRIMMED) {
        videoview1.seekTo(Integer.parseInt(STARTTIMEinmillivar));
        videoview1.start();
      } else {
        videoview1.start();
      }
    }
  }
  
  @Override
  public void onPause() {
      super.onPause();
      videoview1.pause();
  }

  // ON BACK BUTTON PRESSED
  @Override
  public void onBackPressed() {
    switch (BOTTOMBARLAYOUT) {
      case "BOTTOMBAR":
        FABTRANSITION();
        break;
      case "TOOLBAR":
        bottommainbar.removeAllViews();
        bottommainbar.addView(bottombar);
        BOTTOMBARLAYOUT = "BOTTOMBAR";
        break;
      case "STATUSBAR":
        bottommainbar.removeAllViews();
        bottommainbar.addView(bottombar);
        BOTTOMBARLAYOUT = "BOTTOMBAR";
        break;
      case "BACKGROUND":
        bottommainbar.removeAllViews();
        bottommainbar.addView(bottombar);
        BOTTOMBARLAYOUT = "BOTTOMBAR";
        break;
      case "DESCRIPTION":
        bottommainbar.removeAllViews();
        bottommainbar.addView(bottombar);
        BOTTOMBARLAYOUT = "BOTTOMBAR";
        break;
      case "VIDEO":
        LinearLayout trimbarbackground =
            (LinearLayout) videosizeview.findViewById(R.id.trimbarbackground);
        LinearLayout linear0 = (LinearLayout) videosizeview.findViewById(R.id.linear0);
        LinearLayout videosizebackground =
            (LinearLayout) videosizeview.findViewById(R.id.videosizebackground);
        if (linear0.getVisibility() == View.VISIBLE) {
          bottommainbar.removeAllViews();
          bottommainbar.addView(bottombar);
          BOTTOMBARLAYOUT = "BOTTOMBAR";
        } else {
          linear0.setVisibility(View.VISIBLE);
          trimbarbackground.setVisibility(View.GONE);
          videosizebackground.setVisibility(View.GONE);
        }
        break;
      default:
        finish();
        break;
    }
  }

  // PERMISSIONS GRANTED/NOT GRANTED RESULTS
  @Override
  public void onRequestPermissionsResult(
      int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }

  // DEFINING VIEWTOIMAGE TO SAVE VIEWS AS IMAGES
  public void viewToImage(final View view, final String _storage_place) {
    view.destroyDrawingCache();
    view.setDrawingCacheEnabled(true);
    Bitmap b = view.getDrawingCache();
    try {
      java.io.File file = new java.io.File(_storage_place);
      java.io.OutputStream out = new java.io.FileOutputStream(file);
      b.compress(Bitmap.CompressFormat.PNG, 100, out);
      out.flush();
      out.close();
      videoview1.setBackgroundColor(Color.TRANSPARENT);
    } catch (Exception e) {
    }
  }

  // FILES PICKED ONACTIVITYRESULT
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
        // ON PROFILEPHOTO PICKED
      case REQ_CD_PICKPROFILEPHOTO:
        if (resultCode == Activity.RESULT_OK) {
          Uri imageUri = data.getData();
          Intent CROPPROFILEPHOTO =
              CropImage.activity(imageUri)
                  .setAspectRatio(1, 1)
                  .setFixAspectRatio(true)
                  .setGuidelines(CropImageView.Guidelines.OFF)
                  .setCropShape(CropImageView.CropShape.OVAL)
                  .setScaleType(CropImageView.ScaleType.FIT_CENTER)
                  .setAutoZoomEnabled(true)
                  .getIntent(getApplicationContext());
          startActivityForResult(CROPPROFILEPHOTO, REQ_CD_CROPPHOTO);
        }
        break;
        // ON VIDEO PICKED
      case REQ_CD_PICKVIDEO:
        if (resultCode == Activity.RESULT_OK) {
          ArrayList<String> _filePath = new ArrayList<>();
          if (data != null) {
            if (data.getClipData() != null) {
              for (int _index = 0; _index < data.getClipData().getItemCount(); _index++) {
                ClipData.Item _item = data.getClipData().getItemAt(_index);
                _filePath.add(
                    FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
              }
            } else {
              _filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), data.getData()));
            }
          }
          // ON FILES PICKED
          videopath = _filePath.get((int) (0));
          Uri VIDEOURI = data.getData();
          // CHECK IF PATH(videopath) is a video file or not
          if (videopath.endsWith(".mp4")) {
            videoview1.setVideoURI(VIDEOURI);
            addfile.setVisibility(View.GONE);
            videoview1.setVisibility(View.VISIBLE);
            videoview1.start();
            TrimView.setVideoPath(videopath);
            SeekBar videosizeseekbar = (SeekBar) videosizeview.findViewById(R.id.videosizeseekbar);
            videosizeseekbar.setMax((int) containerwidth);
            container.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
            container.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            videosizeseekbar.setProgress((int) (videosizeseekbar.getMax() / 1.5));
            VIDEOTRIMMED = false;
          }
        }
        break;
        // ON CROPPED
      case REQ_CD_CROPPHOTO:
        if (resultCode == RESULT_OK) {
          CropImage.ActivityResult resultdata = CropImage.getActivityResult(data);
          Uri resultUria = resultdata.getUri();
          profilephoto.setImageURI(resultUria);
        }
        break;
      case REQ_CD_BACKGROUNDVIDEO:
        if (resultCode == Activity.RESULT_OK) {
          vidview = new VideoView(this);
          vidview.setLayoutParams(
              new LinearLayout.LayoutParams(
                  LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
          backgroundvideoview.addView(vidview);
          vidview.setVideoURI(data.getData());
        }
        break;
      default:
        break;
    }
  }

  public void FABTRANSITION() {
    if (bottombackground.getVisibility() == View.VISIBLE) {
      expandfab.setTranslationY((float) (0));
      savefab.setTranslationY((float) (0));
      bottombackground.setVisibility(View.GONE);
      if (BOTTOMBARLAYOUT.equals("BOTTOMBAR")) {
        BOTTOMBARLAYOUT = "";
      }
    } else {
      expandfab.setTranslationY((float) (-130));
      savefab.setTranslationY((float) (-130));
      bottombackground.setVisibility(View.VISIBLE);
      if (BOTTOMBARLAYOUT.equals("")) {
        BOTTOMBARLAYOUT = "BOTTOMBAR";
      }
    }
  }

  // DEFINING CHANGEVIEWSIZE
  public void ChangeViewSize(final View view, final double w) {
    view.getLayoutParams().width = (int) w;
    view.requestLayout();
  }

  // ASK PERMISSION
  public void Permission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      // IF ANDROID VERSION IS GREATER OR EQUAL TO ANDROID 9 (API 29) ~~
      if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
          == PackageManager.PERMISSION_DENIED) {
        ActivityCompat.requestPermissions(
            this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
      }
    } else {
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
  }

  // SET TIME AND DATE
  public void SETTIMEANDDATE() {
    Timer timer = new Timer();
    TimerTask settimer;
    settimer =
        new TimerTask() {
          @Override
          public void run() {
            runOnUiThread(
                new Runnable() {
                  @Override
                  public void run() {
                    Calendar cal = Calendar.getInstance();
                    time.setText(new SimpleDateFormat("hh:mm a").format(cal.getTime()));
                    date.setText(new SimpleDateFormat("dd MMM yy").format(cal.getTime()) + " •");
                  }
                });
          }
        };
    timer.scheduleAtFixedRate(settimer, (int) (0), (int) (1000));
  }

  public void HANDLESTOP() {
    settimer1 =
        new TimerTask() {
          @Override
          public void run() {
            runOnUiThread(
                new Runnable() {
                  @Override
                  public void run() {
                    if (VIDEOTRIMMED) {
                      if (videoview1.getCurrentPosition()
                          >= Double.parseDouble(ENDTIMEinmillivar)) {
                        videoview1.pause();
                        videoview1.seekTo(Integer.parseInt(STARTTIMEinmillivar));
                        videoview1.start();
                      }
                    }
                  }
                });
          }
        };
    timer1.scheduleAtFixedRate(settimer1, (int) (0), (int) (100));
  }

  public String ReadableDurationString(double num) {
    long timeInMillisecond = Long.valueOf((int) num);
    return String.format(
        Locale.US,
        "%02d:%02d:%02d.%02d",
        java.util.concurrent.TimeUnit.MILLISECONDS.toHours(timeInMillisecond),
        java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(timeInMillisecond)
            % java.util.concurrent.TimeUnit.HOURS.toMinutes(1),
        java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(timeInMillisecond)
            % java.util.concurrent.TimeUnit.MINUTES.toSeconds(1),
        java.util.concurrent.TimeUnit.MILLISECONDS.toMillis(timeInMillisecond)
            % java.util.concurrent.TimeUnit.SECONDS.toMillis(1));
  }

  public static class VideoFrameDecoder extends AsyncTask<Integer, Integer, Bitmap> {
    interface VideoFrameDecoderListener {
      void frameDecoded(Bitmap frame, int frameNumber);
    }

    VideoFrameDecoder(TrimTimelineView view, VideoFrameDecoderListener listener) {
      this.mediaMetadataRetriever = view.mediaMetadataRetriever;
      this.listener = listener;
      this.utils = view.utils;
    }

    private VideoFrameDecoderUtils utils;
    private VideoFrameDecoderListener listener;
    private MediaMetadataRetriever mediaMetadataRetriever;

    int frameNum;

    @Override
    protected Bitmap doInBackground(Integer... objects) {
      frameNum = objects[0];
      Bitmap bitmap = null;
      if (isCancelled()) {
        return null;
      }
      try {
        bitmap =
            mediaMetadataRetriever.getFrameAtTime(
                utils.frameTimeOffset * frameNum * 1000,
                MediaMetadataRetriever.OPTION_CLOSEST_SYNC);
        if (isCancelled()) {
          return null;
        }
        if (bitmap != null) {
          bitmap = utils.prepareFrame(bitmap);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
      if (!isCancelled() && listener != null) {
        listener.frameDecoded(bitmap, frameNum);
      }
    }
  }

  public static class VideoFrameDecoderUtils {

    long frameTimeOffset;
    int frameWidth;
    int frameHeight;
    int framesToLoad;

    public void load(TrimTimelineView view) {
      if (view.isRoundFrames()) {
        frameHeight = frameWidth = view.dp(56);
        framesToLoad =
            (int) Math.ceil((view.getMeasuredWidth() - view.dp(16)) / (frameHeight / 2.0f));
      } else {
        frameHeight = view.dp(40);
        framesToLoad = (view.getMeasuredWidth() - view.dp(16)) / frameHeight;
        frameWidth =
            (int) Math.ceil((float) (view.getMeasuredWidth() - view.dp(16)) / (float) framesToLoad);
      }
      frameTimeOffset = view.videoLength / framesToLoad;
    }

    public Bitmap prepareFrame(Bitmap bitmap) {
      Bitmap result = Bitmap.createBitmap(frameWidth, frameHeight, bitmap.getConfig());
      Canvas canvas = new Canvas(result);
      float scaleX = (float) frameWidth / (float) bitmap.getWidth();
      float scaleY = (float) frameHeight / (float) bitmap.getHeight();
      float scale = scaleX > scaleY ? scaleX : scaleY;
      int w = (int) (bitmap.getWidth() * scale);
      int h = (int) (bitmap.getHeight() * scale);
      Rect srcRect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
      Rect destRect = new Rect((frameWidth - w) / 2, (frameHeight - h) / 2, w, h);
      canvas.drawBitmap(bitmap, srcRect, destRect, null);
      bitmap.recycle();
      return result;
    }
  }

  public static interface TrimTimelineViewListener {
    void onLeftProgressChanged(float progress);

    void onRightProgressChanged(float progress);
  }

  public static class TrimTimelineView extends View {

    long videoLength;

    private boolean playEnabled = true;
    private Paint paint;
    private Paint paint2;
    private boolean pressedLeft;
    private boolean pressedRight;
    private boolean pressedPlay;
    private Drawable drawableLeft;
    private Drawable drawableRight;
    private Rect rect1;
    private Rect rect2;
    private RectF rect3 = new RectF();
    private int lastWidth;
    private float radius;

    // progress
    private float maxProgressDiff = 1.0f;
    private float minProgressDiff = 0.0f;
    private float progressLeft;
    private float progressRight = 1;
    private float playProgress = 0.5f;
    private float pressDx;

    // frames
    private boolean isRoundFrames;
    MediaMetadataRetriever mediaMetadataRetriever;
    public ArrayList<Bitmap> frames = new ArrayList<>();
    private VideoFrameDecoder currentTask;
    private static final Object sync = new Object();
    VideoFrameDecoderUtils utils;

    private TrimTimelineViewListener listener;

    public TrimTimelineView(Context context) {
      super(context);
      init(null);
    }

    public TrimTimelineView(Context context, AttributeSet attrs) {
      super(context, attrs);
      init(attrs);
    }

    public TrimTimelineView(Context context, AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);
      init(attrs);
    }

    private float density = 1;

    int dp(float value) {
      if (value == 0) {
        return 0;
      }
      return (int) Math.ceil(density * value);
    }

    private int getTimelineColor(int color) {
      return Color.argb(127, Color.red(color), Color.green(color), Color.blue(color));
    }

    private void init(AttributeSet attrs) {
      density = getContext().getResources().getDisplayMetrics().density;
      utils = new VideoFrameDecoderUtils();
      paint = new Paint(Paint.ANTI_ALIAS_FLAG);
      paint2 = new Paint();
      drawableLeft = getContext().getResources().getDrawable(R.drawable.video_cropleft);
      drawableRight = getContext().getResources().getDrawable(R.drawable.video_cropright);

      int color = Color.WHITE;
      int iconColor = Color.WHITE;
      int timelineColor = Color.BLACK;

      paint.setColor(color);
      paint2.setColor(getTimelineColor(timelineColor));
      drawableRight.setColorFilter(new PorterDuffColorFilter(iconColor, PorterDuff.Mode.MULTIPLY));
      drawableLeft.setColorFilter(new PorterDuffColorFilter(iconColor, PorterDuff.Mode.MULTIPLY));
      radius = dp(2);
    }

    public void setPlayLineEnabled(boolean playEnabled) {
      this.playEnabled = playEnabled;
    }

    public boolean isPlayLineEnabled() {
      return playEnabled;
    }

    public void setIconColors(int Color) {
      drawableLeft.setColorFilter(new PorterDuffColorFilter(Color, PorterDuff.Mode.MULTIPLY));
      drawableRight.setColorFilter(new PorterDuffColorFilter(Color, PorterDuff.Mode.MULTIPLY));
    }

    public void setTimelineColor(int Color) {
      paint2.setColor(getTimelineColor(Color));
    }

    public float getPlayProgress() {
      return playProgress;
    }

    public float getLeftProgress() {
      return progressLeft;
    }

    public float getRightProgress() {
      return progressRight;
    }

    public void setMinProgressDiff(float value) {
      minProgressDiff = value;
    }

    public void setMaxProgressDiff(float value) {
      maxProgressDiff = value;
      if (progressRight - progressLeft > maxProgressDiff) {
        progressRight = progressLeft + maxProgressDiff;
        invalidate();
      }
    }

    public void setRoundFrames(boolean value) {
      isRoundFrames = value;
      if (isRoundFrames) {
        rect1 = new Rect(dp(14), dp(14), dp(14 + 28), dp(14 + 28));
        rect2 = new Rect();
      }
    }

    public boolean isRoundFrames() {
      return isRoundFrames;
    }

    public int getFrameWidth() {
      return utils.frameWidth;
    }

    public int getFrameHeight() {
      return utils.frameHeight;
    }

    public long getFrameTimeOffset() {
      return utils.frameTimeOffset;
    }

    public void setColor(int color) {
      paint.setColor(color);
    }

    public void setRadius(int radius) {
      this.radius = radius;
    }

    public void setListener(TrimTimelineViewListener listener) {
      this.listener = listener;
    }

    public long getVideoDuration() {
      return videoLength;
    }

    public long getCroppedDuration() {
      float time = getRightProgress() - getLeftProgress();
      return (long) (getVideoDuration() * time);
    }

    public long getStartTime() {
      return (long) (getVideoDuration() * getLeftProgress());
    }

    public long getEndTime() {
      return (long) (getVideoDuration() * getRightProgress());
    }

    public boolean isPlayDragging() {
      return pressedPlay;
    }

    public boolean isLeftDragging() {
      return pressedLeft;
    }

    public boolean isRightDragging() {
      return pressedRight;
    }

    public boolean isDragging() {
      if (pressedPlay || pressedLeft || pressedRight) return true;
      return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
      if (event == null) {
        return false;
      }
      float x = event.getX();
      float y = event.getY();

      int width = getMeasuredWidth() - dp(32);
      int startX = (int) (width * progressLeft) + dp(16);
      int playX =
          (int) (width * (progressLeft + (progressRight - progressLeft) * playProgress)) + dp(16);
      int endX = (int) (width * progressRight) + dp(16);

      if (event.getAction() == MotionEvent.ACTION_DOWN) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (mediaMetadataRetriever == null) {
          return false;
        }
        int additionWidth = dp(12);
        int additionWidthPlay = dp(8);
        if (playEnabled
            && playX - additionWidthPlay <= x
            && x <= playX + additionWidthPlay
            && y >= 0
            && y <= getMeasuredHeight()) {
          pressedPlay = true;
          if (listener != null) pressDx = (int) (x - playX);
          invalidate();
          return true;
        } else if (startX - additionWidth <= x
            && x <= startX + additionWidth
            && y >= 0
            && y <= getMeasuredHeight()) {
          pressedLeft = true;
          if (listener != null) pressDx = (int) (x - startX);
          invalidate();
          return true;
        } else if (endX - additionWidth <= x
            && x <= endX + additionWidth
            && y >= 0
            && y <= getMeasuredHeight()) {
          pressedRight = true;
          if (listener != null) pressDx = (int) (x - endX);
          invalidate();
          return true;
        }
      } else if (event.getAction() == MotionEvent.ACTION_UP
          || event.getAction() == MotionEvent.ACTION_CANCEL) {
        if (pressedLeft) {
          pressedLeft = false;
          if (listener != null) return true;
        } else if (pressedRight) {
          pressedRight = false;
          if (listener != null) return true;
        } else if (pressedPlay) {
          pressedPlay = false;
          if (listener != null) return true;
        }
      } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
        if (pressedPlay && playEnabled) {
          playX = (int) (x - pressDx);
          playProgress = (float) (playX - dp(16)) / (float) width;
          if (playProgress < progressLeft) {
            playProgress = progressLeft;
          } else if (playProgress > progressRight) {
            playProgress = progressRight;
          }
          playProgress = (playProgress - progressLeft) / (progressRight - progressLeft);
          if (listener != null) {}
          invalidate();
          return true;
        } else if (pressedLeft) {
          startX = (int) (x - pressDx);
          if (startX < dp(16)) {
            startX = dp(16);
          } else if (startX > endX) {
            startX = endX;
          }
          progressLeft = (float) (startX - dp(16)) / (float) width;
          if (progressRight - progressLeft > maxProgressDiff) {
            progressRight = progressLeft + maxProgressDiff;
          } else if (minProgressDiff != 0 && progressRight - progressLeft < minProgressDiff) {
            progressLeft = progressRight - minProgressDiff;
            if (progressLeft < 0) {
              progressLeft = 0;
            }
          }
          if (listener != null) {
            listener.onLeftProgressChanged(getStartTime());
            listener.onRightProgressChanged(getEndTime());
          }
          invalidate();
          return true;
        } else if (pressedRight) {
          endX = (int) (x - pressDx);
          if (endX < startX) {
            endX = startX;
          } else if (endX > width + dp(16)) {
            endX = width + dp(16);
          }
          progressRight = (float) (endX - dp(16)) / (float) width;
          if (progressRight - progressLeft > maxProgressDiff) {
            progressLeft = progressRight - maxProgressDiff;
          } else if (minProgressDiff != 0 && progressRight - progressLeft < minProgressDiff) {
            progressRight = progressLeft + minProgressDiff;
            if (progressRight > 1.0f) {
              progressRight = 1.0f;
            }
          }
          if (listener != null) {
            listener.onLeftProgressChanged(getStartTime());
            listener.onRightProgressChanged(getEndTime());
          }
          invalidate();
          return true;
        }
      }
      return false;
    }

    public void setVideoPath(java.io.File file) {
      destroy();
      mediaMetadataRetriever = new MediaMetadataRetriever();
      progressLeft = 0.0f;
      progressRight = 1.0f;
      try {
        java.io.FileInputStream inputStream = new java.io.FileInputStream(file.getAbsolutePath());
        mediaMetadataRetriever.setDataSource(inputStream.getFD());
        String duration =
            mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        videoLength = Long.parseLong(duration);
      } catch (Exception e) {
        e.printStackTrace();
      }
      invalidate();
    }

    public void setVideoPath(String path) {
      setVideoPath(new java.io.File(path));
    }

    private void reloadFrames(int frameNum) {
      if (mediaMetadataRetriever == null) {
        return;
      }
      if (frameNum == 0) {
        utils.load(this);
      }
      currentTask =
          new VideoFrameDecoder(
              this,
              new VideoFrameDecoder.VideoFrameDecoderListener() {
                @Override
                public void frameDecoded(Bitmap frame, int frameNumber) {
                  frames.add(frame);
                  invalidate();
                  if (frameNumber < utils.framesToLoad) {
                    reloadFrames(frameNumber + 1);
                  }
                }
              });
      currentTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, frameNum, null, null);
    }

    public void reloadFrames() {
      reloadFrames(0);
    }

    public void destroy() {
      synchronized (sync) {
        try {
          if (mediaMetadataRetriever != null) {
            mediaMetadataRetriever.release();
            mediaMetadataRetriever = null;
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      clearListFrames();
    }

    public void setProgress(float value) {
      if (!playEnabled) return;
      playProgress = value;
      invalidate();
    }

    public void clearFrames() {
      clearListFrames();
      invalidate();
    }

    private void clearListFrames() {
      for (int a = 0; a < frames.size(); a++) {
        Bitmap bitmap = frames.get(a);
        if (bitmap != null) {
          bitmap.recycle();
        }
      }
      frames.clear();
      if (currentTask != null) {
        currentTask.cancel(true);
        currentTask = null;
      }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
      super.onMeasure(widthMeasureSpec, heightMeasureSpec);
      int widthSize = MeasureSpec.getSize(widthMeasureSpec);
      if (lastWidth != widthSize) {
        clearFrames();
        lastWidth = widthSize;
      }
    }

    @Override
    protected void onDraw(Canvas canvas) {
      int width = getMeasuredWidth() - dp(36);
      int startX = (int) (width * progressLeft) + dp(16);
      int endX = (int) (width * progressRight) + dp(16);
      canvas.save();
      canvas.clipRect(dp(16), dp(4), width + dp(20), dp(48));
      if (frames.isEmpty() && currentTask == null) {
        reloadFrames(0);
      } else {
        int offset = 0;
        for (int a = 0; a < frames.size(); a++) {
          Bitmap bitmap = frames.get(a);
          if (bitmap != null) {
            int x = dp(16) + offset * (isRoundFrames ? utils.frameWidth / 2 : utils.frameWidth);
            int y = dp(2 + 4);
            if (isRoundFrames) {
              rect2.set(x, y, x + dp(28), y + dp(28));
              canvas.drawBitmap(bitmap, rect1, rect2, null);
            } else {
              canvas.drawBitmap(bitmap, x, y, null);
            }
          }
          offset++;
        }
      }

      int top = dp(6);
      int end = dp(48);
      canvas.drawRect(dp(16), top, startX, dp(46), paint2);
      canvas.drawRect(endX + dp(4), top, dp(16) + width + dp(4), dp(46), paint2);
      canvas.drawRect(startX, dp(4), startX + dp(2), end, paint);
      canvas.drawRect(endX + dp(2), dp(4), endX + dp(4), end, paint);
      canvas.drawRect(startX + dp(2), dp(4), endX + dp(4), top, paint);
      canvas.drawRect(startX + dp(2), end - dp(2), endX + dp(4), end, paint);
      canvas.restore();
      rect3.set(startX - dp(8), dp(4), startX + dp(2), end);
      canvas.drawRoundRect(rect3, radius, radius, paint);
      drawableLeft.setBounds(
          startX - dp(8),
          dp(4) + (dp(44) - dp(18)) / 2,
          startX + dp(2),
          (dp(44) - dp(18)) / 2 + dp(18 + 4));
      drawableLeft.draw(canvas);
      rect3.set(endX + dp(2), dp(4), endX + dp(12), end);
      canvas.drawRoundRect(rect3, radius, radius, paint);
      drawableRight.setBounds(
          endX + dp(2),
          dp(4) + (dp(44) - dp(18)) / 2,
          endX + dp(12),
          (dp(44) - dp(18)) / 2 + dp(18 + 4));
      drawableRight.draw(canvas);

      if (playEnabled) {
        float cx = dp(18) + width * (progressLeft + (progressRight - progressLeft) * playProgress);
        rect3.set(cx - dp(1.5f), dp(2), cx + dp(1.5f), dp(50));
        canvas.drawRoundRect(rect3, dp(1), dp(1), paint2);
        canvas.drawCircle(cx, dp(52), dp(3.5f), paint2);

        rect3.set(cx - dp(1), dp(2), cx + dp(1), dp(50));
        canvas.drawRoundRect(rect3, dp(1), dp(1), paint);
        canvas.drawCircle(cx, dp(52), dp(3), paint);
      }
    }
  }

  public void Bundle() {}
}