package com.editlike.app;

import android.Manifest;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.*;
import android.media.*;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.*;
import android.os.Build;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.ViewGroup;
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
import com.editlike.app.databinding.ActivityMainBinding;
import com.editlike.app.databinding.BackgroundlayoutBinding;
import com.editlike.app.databinding.BackgroundviewBinding;
import com.editlike.app.databinding.DescriptionviewBinding;
import com.editlike.app.databinding.StatusbarviewBinding;
import com.editlike.app.databinding.ToolbarviewBinding;
import com.editlike.app.databinding.VideosizeviewBinding;
import com.flask.colorpicker.*;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.unity3d.ads.UnityAds;
import de.hdodenhof.circleimageview.*;
import io.michaelrocks.paranoid.Obfuscate;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import android.util.AttributeSet;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import com.editlike.app.Utils.TrimTimelineView;
import com.editlike.app.Utils.VideoFrameDecoderUtils;
import com.editlike.app.Interfaces.TrimTimelineViewListener;

@Obfuscate
public class MainActivity extends AppCompatActivity {

  private TrimTimelineView TrimView;
  private VideoView vidview;

  private ActivityMainBinding mainbinding;
  private ToolbarviewBinding toolbinding;
  private StatusbarviewBinding statusbinding;
  private DescriptionviewBinding descriptionbinding;
  private BackgroundviewBinding backgroundbinding;
  private VideosizeviewBinding videobinding;
  private BackgroundlayoutBinding backgroundlayoutbinding;

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
    mainbinding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(mainbinding.getRoot());

    /* SET XML LAYOUT INFLATOR - toolbarview.xml (res/layout) */
    toolbinding = ToolbarviewBinding.inflate(getLayoutInflater(), mainbinding.bottommainbar, false);

    /* SET XML LAYOUT INFLATOR - statusbarview.xml (res/layout) */
    statusbinding =
        StatusbarviewBinding.inflate(getLayoutInflater(), mainbinding.bottommainbar, false);

    /* SET XML LAYOUT INFLATOR - descriptionview.xml (res/layout) */
    descriptionbinding =
        DescriptionviewBinding.inflate(getLayoutInflater(), mainbinding.bottommainbar, false);

    /* SET XML LAYOUT INFLATOR - backgroundview.xml (res/layout) */
    backgroundbinding =
        BackgroundviewBinding.inflate(getLayoutInflater(), mainbinding.bottommainbar, false);

    /* SET XML LAYOUT INFLATOR - videosizeview.xml (res/layout) */
    videobinding =
        VideosizeviewBinding.inflate(getLayoutInflater(), mainbinding.bottommainbar, false);

    /**/
    backgroundlayoutbinding = BackgroundlayoutBinding.inflate(getLayoutInflater(), mainbinding.background, true);
    
    // EVERYTHING ON INITIALISE ~~
    if (getIntent().getStringExtra("TEMPLATE").equals("TEMPLATE1")) {
      backgroundbinding.addbackgroundvideobutton.setVisibility(View.GONE);
    } else {
      backgroundbinding.addbackgroundvideobutton.setVisibility(View.VISIBLE);
      backgroundlayoutbinding.container.setVisibility(View.GONE);
    }

    videobinding.imageview9.setTag("sound");
    backgroundlayoutbinding.addfile .setVisibility(View.VISIBLE);
    backgroundlayoutbinding.videoview1.setVisibility(View.GONE);
    backgroundlayoutbinding.videoview1.setMediaController(null);
    mainbinding.bottombackground.setVisibility(View.GONE);
    videobinding.linear0.setVisibility(View.VISIBLE);
    videobinding.trimbarbackground.setVisibility(View.GONE);
    videobinding.videosizebackground.setVisibility(View.GONE);
    videobinding
        .videosizeseekbar
        .getProgressDrawable()
        .setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
    videobinding
        .videosizeseekbar
        .getThumb()
        .setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);

    UnityAds.initialize(this, GameID, false);

    // SET TIME AND DATE ~~
    SETTIMEANDDATE();

    // VIDEO TRIM VIEW ~~
    TrimView = new TrimTimelineView(this);
    videobinding.trimbarview.addView(TrimView);
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
            backgroundlayoutbinding.videoview1.seekTo(Integer.parseInt(Float.toString(progress).replace(".0", "")));
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
    mainbinding.savefab.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (mainbinding.bottombackground.getVisibility() == View.VISIBLE) {
              FABTRANSITION();
            }
            final double videopositionY = backgroundlayoutbinding.container.getTop();
            final double videoscalex = backgroundlayoutbinding.videoview1.getWidth();
            final double videoscaley = backgroundlayoutbinding.videoview1.getHeight();
            final double backgroundheight = mainbinding.background.getWidth();
            final double backgroundwidth = mainbinding.background.getHeight();
            if (!(videopath.length() == 0)) {
              FileUtil.deleteFile("/storage/emulated/0/DCIM/save.png");
              backgroundlayoutbinding.videoview1.setBackgroundColor(0xFFFFFFFF);
              viewToImage(mainbinding.background, "/storage/emulated/0/DCIM/save.png");
              Intent EXPORTPAGE = new Intent();
              EXPORTPAGE.setClass(getApplicationContext(), ExportActivity.class);
              EXPORTPAGE.putExtra("VIDEOPATH", videopath);
              EXPORTPAGE.putExtra("VIDEOPOSITIONY", String.valueOf(videopositionY));
              EXPORTPAGE.putExtra("VIDEOSCALEX", String.valueOf(videoscalex));
              EXPORTPAGE.putExtra("VIDEOSCALEY", String.valueOf(videoscaley));
              EXPORTPAGE.putExtra("BACKGROUNDHEIGHT", String.valueOf(backgroundheight));
              EXPORTPAGE.putExtra("BACKGROUNDWIDTH", String.valueOf(backgroundwidth));
              EXPORTPAGE.putExtra("DURATION", String.valueOf(backgroundlayoutbinding.videoview1.getDuration()));
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
    backgroundlayoutbinding.username.setOnFocusChangeListener(
        new OnFocusChangeListener() {
          @Override
          public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
              backgroundlayoutbinding.username.setHint("type a username here...");
            } else {
              backgroundlayoutbinding.username.setHint("@enterusername");
            }
          }
        });

    // NAME (EDITTEXT) ON CLICKED ~~
    backgroundlayoutbinding.name.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            backgroundlayoutbinding.name.setHint("type a name here...");
            backgroundlayoutbinding.name.setHintTextColor(0xFF9E9E9E);
          }
        });

    backgroundlayoutbinding.name.setOnFocusChangeListener(
        new OnFocusChangeListener() {
          @Override
          public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
              backgroundlayoutbinding.name.setHint("type a name here...");
              backgroundlayoutbinding.name.setHintTextColor(0xFF9E9E9E);
            } else {
              backgroundlayoutbinding.name.setHint("YOUR NAME");
              backgroundlayoutbinding.name.setHintTextColor(0xFF000000);
            }
          }
        });

    // DESCRIPTION (EDITTEXT) ON CLICKED ~~
    backgroundlayoutbinding.description.setOnFocusChangeListener(
        new OnFocusChangeListener() {
          @Override
          public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
              backgroundlayoutbinding.description.setHint("type description here...");
              backgroundlayoutbinding.description.setHintTextColor(0xFF9E9E9E);
            } else {
              backgroundlayoutbinding.description.setHint("Write description here");
              backgroundlayoutbinding.description.setHintTextColor(0xFF000000);
            }
          }
        });

    // ADDFILE (LINEARLAYOUT) ON CLICKED ~~
    backgroundlayoutbinding.addfile.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            // SELECT VIDEO
            containerheight = backgroundlayoutbinding.container.getHeight();
            containerwidth = backgroundlayoutbinding.container.getWidth();
            Intent PICKVIDEO =
                new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            PICKVIDEO.setType("video/*");
            startActivityForResult(PICKVIDEO, REQ_CD_PICKVIDEO);
          }
        });

    // PROFILEPHOTO (IMAGEVIEW) ON CLICKED ~~
    backgroundlayoutbinding.profilephoto.setOnClickListener(
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
    mainbinding.expandfab.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            FABTRANSITION();
          }
        });

    // TOOLBAR (LINEARLAYOUT) ON CLICKED ~~
    mainbinding.toolbarbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            mainbinding.bottommainbar.removeView(mainbinding.bottombar);
            mainbinding.bottommainbar.addView(toolbinding.getRoot());
            BOTTOMBARLAYOUT = "TOOLBAR";
          }
        });

    // STATUSBAR BUTTON (LINEARLAYOUT) ON CLICKED ~~
    mainbinding.statusbarbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            mainbinding.bottommainbar.removeView(mainbinding.bottombar);
            mainbinding.bottommainbar.addView(statusbinding.getRoot());
            BOTTOMBARLAYOUT = "STATUSBAR";
          }
        });

    // BACKGROUND BUTTON (LINEARLAYOUT) ON CLICKED ~~
    mainbinding.backgroundbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            mainbinding.bottommainbar.removeView(mainbinding.bottombar);
            mainbinding.bottommainbar.addView(backgroundbinding.getRoot());
            BOTTOMBARLAYOUT = "BACKGROUND";
          }
        });

    // DESCRIPTION BUTTON (LINEARLAYOUT) ON CLICKED ~~
    mainbinding.descriptionbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            mainbinding.bottommainbar.removeView(mainbinding.bottombar);
            mainbinding.bottommainbar.addView(descriptionbinding.getRoot());
            BOTTOMBARLAYOUT = "DESCRIPTION";
          }
        });

    // VIDEOSIZE BUTTON (LINEARLAYOUT) ON CLICKED ~~
    mainbinding.videobutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            mainbinding.bottommainbar.removeView(mainbinding.bottombar);
            mainbinding.bottommainbar.addView(videobinding.getRoot());
            BOTTOMBARLAYOUT = "VIDEO";
          }
        });

    // SHOW/HIDE TOOLBAR (LINEARLAYOUT) [toolbarview.xml] ON CLICKED ~~
    toolbinding.showhidetoolbar.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (backgroundlayoutbinding.toolbar.getVisibility() == View.VISIBLE) {
              backgroundlayoutbinding.toolbar.setVisibility(View.GONE);
            } else {
              backgroundlayoutbinding.toolbar.setVisibility(View.VISIBLE);
            }
          }
        });

    // SHOW/HIDE 3 DOT (LINEARLAYOUT) [toolbarview.xml] OM CLICKED ~~
    toolbinding.showhide3dot.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (backgroundlayoutbinding.dot3.getVisibility() == View.VISIBLE) {
              backgroundlayoutbinding.dot3.setVisibility(View.GONE);
            } else {
              backgroundlayoutbinding.dot3.setVisibility(View.VISIBLE);
            }
          }
        });

    // SHOW/HIDE STATUSBAR (LINEARLAYOUT) [statusbarview.xml] ON CLICKED ~~
    statusbinding.showhidestatusbar.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (backgroundlayoutbinding.statusbar.getVisibility() == View.VISIBLE) {
              backgroundlayoutbinding.statusbar.setVisibility(View.GONE);
            } else {
              backgroundlayoutbinding.statusbar.setVisibility(View.VISIBLE);
            }
          }
        });

    // CHANGE BACKGROUND COLOR (LINEARLAYOUT) [backgroundview.xml] ON CLICKED ~~
    backgroundbinding.choosecolorbutton.setOnClickListener(
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
                        backgroundlayoutbinding.ground.setBackgroundColor(selectedColor);
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

    backgroundbinding.addbackgroundvideobutton.setOnClickListener(
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
    descriptionbinding.showhidedescriptionbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (backgroundlayoutbinding.description.getVisibility() == View.VISIBLE) {
              backgroundlayoutbinding.description.setVisibility(View.GONE);
            } else {
              backgroundlayoutbinding.description.setVisibility(View.VISIBLE);
            }
          }
        });

    // TRIM (LINEARLAYOUT) [videosizeview.xml] ON CLICKED ~~
    videobinding.trimbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            videobinding.linear0.setVisibility(View.GONE);
            videobinding.videosizebackground.setVisibility(View.GONE);
            videobinding.trimbarbackground.setVisibility(View.VISIBLE);
          }
        });

    videobinding.videosizebutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            videobinding.linear0.setVisibility(View.GONE);
            videobinding.trimbarbackground.setVisibility(View.GONE);
            videobinding.videosizebackground.setVisibility(View.VISIBLE);
          }
        });

    videobinding.replacebutton.setOnClickListener(
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

    videobinding.soundbutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (mp != null) {
              if (videobinding.imageview9.getTag() != null
                  && videobinding.imageview9.getTag().toString().equals("sound")) {
                videobinding.imageview9.setImageResource(R.drawable.speakermuteicon);
                videobinding.imageview9.setTag("mute");
                mp.setVolume(0f, 0f);
              } else {
                videobinding.imageview9.setImageResource(R.drawable.speakericon);
                videobinding.imageview9.setTag("sound");
                mp.setVolume(1f, 1f);
              }
            }
          }
        });

    // VIDEOSIZESEEKBAR (SEEKBAR) CHANGED ~~
    videobinding.videosizeseekbar.setOnSeekBarChangeListener(
        new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
            final int progressValue = _param2;
            ChangeViewSize(backgroundlayoutbinding.videoview1, progressValue);
          }

          @Override
          public void onStartTrackingTouch(SeekBar _param1) {}

          @Override
          public void onStopTrackingTouch(SeekBar _param2) {}
        });

    backgroundlayoutbinding.videoview1.setOnPreparedListener(
        new MediaPlayer.OnPreparedListener() {
          @Override
          public void onPrepared(MediaPlayer np) {

            mp = np;
          }
        });

    // VIDEOVIEW1 (VIDEOVIEW) ON COMPLETED ~~
    backgroundlayoutbinding.videoview1.setOnCompletionListener(
        new MediaPlayer.OnCompletionListener() {
          @Override
          public void onCompletion(MediaPlayer mediaPlayer) {
            if (VIDEOTRIMMED) {
              backgroundlayoutbinding.videoview1.seekTo(Integer.parseInt(STARTTIMEinmillivar));
              backgroundlayoutbinding.videoview1.start();
            } else {
              backgroundlayoutbinding.videoview1.start();
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
    backgroundlayoutbinding.videoview1.setBackgroundColor(Color.TRANSPARENT);
    if (backgroundlayoutbinding.videoview1 != null) {
      if (VIDEOTRIMMED) {
        backgroundlayoutbinding.videoview1.seekTo(Integer.parseInt(STARTTIMEinmillivar));
        backgroundlayoutbinding.videoview1.start();
      } else {
        backgroundlayoutbinding.videoview1.start();
      }
    }
  }

  @Override
  public void onPause() {
    super.onPause();
    backgroundlayoutbinding.videoview1.pause();
  }

  // ON BACK BUTTON PRESSED
  @Override
  public void onBackPressed() {
    switch (BOTTOMBARLAYOUT) {
      case "BOTTOMBAR":
        FABTRANSITION();
        break;
      case "TOOLBAR":
        mainbinding.bottommainbar.removeAllViews();
        mainbinding.bottommainbar.addView(mainbinding.bottombar);
        BOTTOMBARLAYOUT = "BOTTOMBAR";
        break;
      case "STATUSBAR":
        mainbinding.bottommainbar.removeAllViews();
        mainbinding.bottommainbar.addView(mainbinding.bottombar);
        BOTTOMBARLAYOUT = "BOTTOMBAR";
        break;
      case "BACKGROUND":
        mainbinding.bottommainbar.removeAllViews();
        mainbinding.bottommainbar.addView(mainbinding.bottombar);
        BOTTOMBARLAYOUT = "BOTTOMBAR";
        break;
      case "DESCRIPTION":
        mainbinding.bottommainbar.removeAllViews();
        mainbinding.bottommainbar.addView(mainbinding.bottombar);
        BOTTOMBARLAYOUT = "BOTTOMBAR";
        break;
      case "VIDEO":
        if (videobinding.linear0.getVisibility() == View.VISIBLE) {
          mainbinding.bottommainbar.removeAllViews();
          mainbinding.bottommainbar.addView(mainbinding.bottombar);
          BOTTOMBARLAYOUT = "BOTTOMBAR";
        } else {
          videobinding.linear0.setVisibility(View.VISIBLE);
          videobinding.trimbarbackground.setVisibility(View.GONE);
          videobinding.videosizebackground.setVisibility(View.GONE);
        }
        break;
      default:
        finish();
        break;
    }
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
      backgroundlayoutbinding.videoview1.setBackgroundColor(Color.TRANSPARENT);
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
            backgroundlayoutbinding.videoview1.setVideoURI(VIDEOURI);
            backgroundlayoutbinding.addfile.setVisibility(View.GONE);
            backgroundlayoutbinding.videoview1.setVisibility(View.VISIBLE);
            backgroundlayoutbinding.videoview1.start();
            TrimView.setVideoPath(videopath);
            videobinding.videosizeseekbar.setMax((int) containerwidth);
            backgroundlayoutbinding.container.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
            backgroundlayoutbinding.container.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            videobinding.videosizeseekbar.setProgress(
                (int) (videobinding.videosizeseekbar.getMax() / 1.5));
            VIDEOTRIMMED = false;
          }
        }
        break;
        // ON CROPPED
      case REQ_CD_CROPPHOTO:
        if (resultCode == RESULT_OK) {
          CropImage.ActivityResult resultdata = CropImage.getActivityResult(data);
          Uri resultUria = resultdata.getUri();
          backgroundlayoutbinding.profilephoto.setImageURI(resultUria);
        }
        break;
      case REQ_CD_BACKGROUNDVIDEO:
        if (resultCode == Activity.RESULT_OK) {
          vidview = new VideoView(this);
          vidview.setLayoutParams(
              new LinearLayout.LayoutParams(
                  LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
          backgroundlayoutbinding.backgroundvideoview.addView(vidview);
          vidview.setVideoURI(data.getData());
        }
        break;
      default:
        break;
    }
  }

  public void FABTRANSITION() {
    if (mainbinding.bottombackground.getVisibility() == View.VISIBLE) {
      mainbinding.expandfab.setTranslationY((float) (0));
      mainbinding.savefab.setTranslationY((float) (0));
      mainbinding.bottombackground.setVisibility(View.GONE);
      if (BOTTOMBARLAYOUT.equals("BOTTOMBAR")) {
        BOTTOMBARLAYOUT = "";
      }
    } else {
      mainbinding.expandfab.setTranslationY((float) (-130));
      mainbinding.savefab.setTranslationY((float) (-130));
      mainbinding.bottombackground.setVisibility(View.VISIBLE);
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
                    backgroundlayoutbinding.time.setText(new SimpleDateFormat("hh:mm a").format(cal.getTime()));
                    backgroundlayoutbinding.date.setText(new SimpleDateFormat("dd MMM yy").format(cal.getTime()) + " •");
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
                      if (backgroundlayoutbinding.videoview1.getCurrentPosition()
                          >= Double.parseDouble(ENDTIMEinmillivar)) {
                        backgroundlayoutbinding.videoview1.pause();
                        backgroundlayoutbinding.videoview1.seekTo(Integer.parseInt(STARTTIMEinmillivar));
                        backgroundlayoutbinding.videoview1.start();
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

  
  
}