package com.editlike.app;

import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.*;
import android.media.*;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;
import com.editlike.app.AppUtil;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import com.editlike.app.Interfaces.TrimTimelineViewListener;
import com.editlike.app.TrimTimelineView;
import com.editlike.app.databinding.FeatbottombarBinding;
import com.editlike.app.databinding.MainBinding;
import com.editlike.app.databinding.ToolbottombarBinding;
import com.editlike.app.databinding.TweetlayoutBinding;
import com.editlike.app.databinding.VideobottombarBinding;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.unity3d.ads.UnityAds;
import com.unity3d.scar.adapter.common.Utils;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, View.OnFocusChangeListener, SeekBar.OnSeekBarChangeListener {

  // mainbinding is for main.xml
  private MainBinding mainbinding;
  // toolbinding is for toolbottombar.xml
  private ToolbottombarBinding toolbinding;
  // videobinding is for videobottombar.xml
  private VideobottombarBinding videobinding;
  // featbinding is for featbottombar.xml
  private FeatbottombarBinding featbinding;
  // tweetlayout binding is for tweetlayout.xml
  private TweetlayoutBinding tweetlayoutbinding;
  // Global TimerTask Variable, used to update video position if trimmed
  private TimerTask settimer1;
  // Global MediaPlayer Variable mp
  private MediaPlayer mp;
  // Global Variable for TrimTimelineView, used for setting trim view in bottombar
  private TrimTimelineView TrimView;
  // Global VideoView Variable, used for background video
  private VideoView vidview;
  // Global String Variable, used in Video Trimming Logic
  private String STARTTIMEvar = "";
  // Global String Variable, used in Video Trimming Logic
  private String ENDTIMEvar = "";
  // Global String Variable, used in Video Trimming Logic
  private String STARTTIMEinmillivar = "";
  // Global String Variable, used in Video Trimming Logic
  private String ENDTIMEinmillivar = "";
  // Global String Variable, used to set video patch when picked from gallery
  private String videopath = "";
  // Global String Variable, used to set picked video file name
  private String videofilename = "";
  // Global String Variable, used to set the current xml showing in bottom bar
  public String BOTTOMBARLAYOUT = "";
  // Global double variable, used to know the current container height > changes on addfile clicked
  private double containerheight = 0;
  // Global double variable, used to know the current container width > changes on addfile clicked
  private double containerwidth = 0;
  // Global boolean Variable, used to know whether video is trimmed or not
  private boolean VIDEOTRIMMED = false;
  // Global boolean Variable ,used to know whether video is muted or not
  private boolean videomuted = false;
  // Global Variable to know whether tweetview(in tweetlayout.xml) is set to move or not
  private boolean tweetviewmoveable = false;
  // Intent ResultCode for picking video from gallery and checking whether video is picked or not
  public final int REQ_CD_PICKVIDEO = 101;
  // Intent ResultCode for picking profile photo from gallery and checking photo is picked or not
  public final int REQ_CD_PICKPROFILEPHOTO = 102;
  // Intent ResultCode for going to profile photo cropping page and checking whether cropped or not
  public final int REQ_CD_CROPPHOTO = 103;
  // Intent ResultCode for picking background video from gallery and checking video picked or not
  public final int REQ_CD_BACKGROUNDVIDEO = 104;
  // Defining Global Timer Variable, used to update Video when trimmed
  private Timer timer1 = new Timer();
  // Global float Variable, used to move tweetview(tweelayout.xml) with fingers
  private float dX;
  // Global float Variable, used to move tweetview(tweelayout.xml) with fingers
  private float dY;
  // Global float Variable, used to move tweetview(tweelayout.xml) with fingers
  private int lastAction;
  // Unity Ads Game Id (here changed for security reasons)
  private String GameID = "000000";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // APP LOGS GENERATOR (com.itsaky.androidide.logsender.LogSender)
    // LogSender.startLogging(this);
    // main.xml Binding
    mainbinding = MainBinding.inflate(getLayoutInflater());
    setContentView(mainbinding.getRoot());
    // toolbarbottombar.xml Binding
    toolbinding =
        ToolbottombarBinding.inflate(getLayoutInflater(), mainbinding.bottommainbar, false);
    // videobottombar.xml Binding
    videobinding =
        VideobottombarBinding.inflate(getLayoutInflater(), mainbinding.bottommainbar, false);
    // featbottombar.xml Binding
    featbinding =
        FeatbottombarBinding.inflate(getLayoutInflater(), mainbinding.bottommainbar, false);
    // tweetlayout.xml Binding
    tweetlayoutbinding =
        TweetlayoutBinding.inflate(getLayoutInflater(), mainbinding.background, true);

    // EVERYTHING ON INITIALISE ~~
    if (getIntent().getStringExtra("TEMPLATE").equals("TEMPLATE2")) {
      tweetlayoutbinding.container.setVisibility(View.GONE);
      mainbinding.featbutton.setVisibility(View.VISIBLE);
      vidview = new VideoView(this);
      vidview.setLayoutParams(
          new LinearLayout.LayoutParams(
              LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
      tweetlayoutbinding.backgroundvideoview.addView(vidview);
      vidview.setVideoURI(Uri.parse(getIntent().getStringExtra("VIDEOURI")));
      vidview.start();
      vidview.setOnCompletionListener(
          new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
              vidview.start();
            }
          });
    }

    // Set Tag to know video sound is hearable or muted
    videobinding.imageview9.setTag("sound");
    // Remove Default Controllers of videoview
    tweetlayoutbinding.videoview1.setMediaController(null);
    // Initialise Unity Ads to be used in ExportActivity
    UnityAds.initialize(this, GameID, false);
    // SET TIME AND DATE ~~
    AppUtil.TimeAndDate(tweetlayoutbinding.time, tweetlayoutbinding.date);
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
            tweetlayoutbinding.videoview1.seekTo(
                Integer.parseInt(Float.toString(progress).replace(".0", "")));
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

    mainbinding.savefab.setOnClickListener(this);
    tweetlayoutbinding.addfile.setOnClickListener(this);
    tweetlayoutbinding.name.setOnClickListener(this);
    tweetlayoutbinding.profilephoto.setOnClickListener(this);
    mainbinding.expandfab.setOnClickListener(this);
    mainbinding.toolbarbutton.setOnClickListener(this);
    mainbinding.videobutton.setOnClickListener(this);
    mainbinding.featbutton.setOnClickListener(this);
    toolbinding.showhidetoolbar.setOnClickListener(this);
    toolbinding.showhide3dot.setOnClickListener(this);
    toolbinding.showhidestatusbar.setOnClickListener(this);
    toolbinding.showhidedescriptionbutton.setOnClickListener(this);
    videobinding.trimbutton.setOnClickListener(this);
    videobinding.videosizebutton.setOnClickListener(this);
    videobinding.replacebutton.setOnClickListener(this);
    videobinding.soundbutton.setOnClickListener(this);
    featbinding.movebutton.setOnClickListener(this);
    featbinding.tweetviewresizebutton.setOnClickListener(this);
    // On Focus Change Listener
    tweetlayoutbinding.username.setOnFocusChangeListener(this);
    tweetlayoutbinding.name.setOnFocusChangeListener(this);
    tweetlayoutbinding.description.setOnFocusChangeListener(this);
    // On Change Listener
    featbinding.seekbar1.setOnSeekBarChangeListener(this);

    // VIDEOSIZESEEKBAR (SEEKBAR) CHANGED ~~
    videobinding.videosizeseekbar.setOnSeekBarChangeListener(
        new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
            final int progressValue = _param2;
            ChangeViewSize(tweetlayoutbinding.videoview1, progressValue);
          }

          @Override
          public void onStartTrackingTouch(SeekBar _param1) {}

          @Override
          public void onStopTrackingTouch(SeekBar _param2) {}
        });

    tweetlayoutbinding.videoview1.setOnPreparedListener(
        new MediaPlayer.OnPreparedListener() {
          @Override
          public void onPrepared(MediaPlayer np) {
            mp = np;
            tweetlayoutbinding.videoview1.start();
          }
        });

    // VIDEOVIEW1 (VIDEOVIEW) ON COMPLETED ~~
    tweetlayoutbinding.videoview1.setOnCompletionListener(
        new MediaPlayer.OnCompletionListener() {
          @Override
          public void onCompletion(MediaPlayer mediaPlayer) {
            if (VIDEOTRIMMED) {
              tweetlayoutbinding.videoview1.seekTo(Integer.parseInt(STARTTIMEinmillivar));
              tweetlayoutbinding.videoview1.start();
            } else {
              tweetlayoutbinding.videoview1.start();
            }
          }
        });
  }
  /*«««««««««««««««««««« [ CLOSES ON CREATE ] »»»»»»»»»»»»»»»»»»»»»*/
  /*«««««««««««««««««««« [ CLOSES ON CREATE ] »»»»»»»»»»»»»»»»»»»»»*/
  /*«««««««««««««««««««« [ CLOSES ON CREATE ] »»»»»»»»»»»»»»»»»»»»»*/
  /*«««««««««««««««««««« [ CLOSES ON CREATE ] »»»»»»»»»»»»»»»»»»»»»*/
  /*«««««««««««««««««««« [ CLOSES ON CREATE ] »»»»»»»»»»»»»»»»»»»»»*/

  // On Activity Resume
  @Override
  public void onResume() {
    super.onResume();
    if (getIntent().getStringExtra("TEMPLATE").equals("TEMPLATE1")) {
      tweetlayoutbinding.videoview1.setBackgroundColor(Color.TRANSPARENT);
      if (tweetlayoutbinding.videoview1 != null) {
        if (VIDEOTRIMMED) {
          tweetlayoutbinding.videoview1.seekTo(Integer.parseInt(STARTTIMEinmillivar));
          tweetlayoutbinding.videoview1.start();
        } else {
          tweetlayoutbinding.videoview1.start();
        }
      }
    } else {
      vidview.start();
    }
  }

  // On Pause
  @Override
  public void onPause() {
    super.onPause();
    if (getIntent().getStringExtra("TEMPLATE").equals("TEMPLATE1")) {
      tweetlayoutbinding.videoview1.pause();
    } else {
      vidview.pause();
    }
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
      case "FEAT":
        if (featbinding.linear1.getVisibility() == View.VISIBLE) {
          mainbinding.bottommainbar.removeAllViews();
          mainbinding.bottommainbar.addView(mainbinding.bottombar);
          BOTTOMBARLAYOUT = "BOTTOMBAR";
        } else {
          featbinding.linear1.setVisibility(View.VISIBLE);
          featbinding.linear2.setVisibility(View.GONE);
        }
        break;
      default:
        finish();
        break;
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
          videofilename = Uri.parse(videopath).getLastPathSegment();
          Uri VIDEOURI = data.getData();
          // CHECK IF PATH(videopath) is a video file or not
          if (!videopath.endsWith(".jpg") || !videopath.endsWith(".png")) {
            tweetlayoutbinding.videoview1.setVideoURI(VIDEOURI);
            tweetlayoutbinding.addfile.setVisibility(View.GONE);
            tweetlayoutbinding.videoview1.setVisibility(View.VISIBLE);
            // tweetlayoutbinding.videoview1.start();
            // TrimView.setVideoPath(videopath);
            videobinding.videosizeseekbar.setMax((int) containerwidth);
            tweetlayoutbinding.container.getLayoutParams().width =
                ViewGroup.LayoutParams.WRAP_CONTENT;
            tweetlayoutbinding.container.getLayoutParams().height =
                ViewGroup.LayoutParams.WRAP_CONTENT;
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
          tweetlayoutbinding.profilephoto.setImageURI(resultUria);
        }
        break;
      case REQ_CD_BACKGROUNDVIDEO:
        if (resultCode == Activity.RESULT_OK) {}

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
                    tweetlayoutbinding.time.setText(
                        new SimpleDateFormat("hh:mm a").format(cal.getTime()));
                    tweetlayoutbinding.date.setText(
                        new SimpleDateFormat("dd MMM yy").format(cal.getTime()) + " •");
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
                      if (tweetlayoutbinding.videoview1.getCurrentPosition()
                          >= Double.parseDouble(ENDTIMEinmillivar)) {
                        tweetlayoutbinding.videoview1.pause();
                        tweetlayoutbinding.videoview1.seekTo(Integer.parseInt(STARTTIMEinmillivar));
                        tweetlayoutbinding.videoview1.start();
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

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case (R.id.savefab):
        savefabOnClicked();
        break;
      case (R.id.name):
        nameOnClicked();
        break;
      case (R.id.addfile):
        addfileOnClicked();
        break;
      case (R.id.profilephoto):
        profilephotoOnClicked();
        break;
      case (R.id.expandfab):
        expandfabOnClicked();
        break;
      case (R.id.toolbarbutton):
        toolbarbuttonOnClicked();
        break;
      case (R.id.videobutton):
        videobuttonOnClicked();
        break;
      case (R.id.featbutton):
        featbuttonOnClicked();
        break;
      case (R.id.showhidetoolbar):
        showhidetoolbarOnClicked();
        break;
      case (R.id.showhide3dot):
        showhide3dotOnClicked();
        break;
      case (R.id.showhidestatusbar):
        showhidestatusbarOnClicked();
        break;
      case (R.id.showhidedescriptionbutton):
        showhidedescriptionbuttonOnClicked();
        break;
      case (R.id.trimbutton):
        trimbuttonOnClicked();
        break;
      case (R.id.videosizebutton):
        videosizebuttonOnClicked();
        break;
      case (R.id.replacebutton):
        replacebuttonOnClicked();
        break;
      case (R.id.soundbutton):
        soundbuttonOnClicked();
        break;
      case (R.id.movebutton):
        movebuttonOnClicked();
        break;
      case (R.id.tweetviewresizebutton):
        tweetviewresizebuttonOnClicked();
        break;
    }
  }

  @Override
  public void onFocusChange(View view, boolean hasFocus) {
    switch (view.getId()) {
      case (R.id.username):
        usernameOnFocusChanged(hasFocus);
        break;
      case (R.id.name):
        nameOnFocusChanged(hasFocus);
        break;
      case (R.id.description):
        descriptionOnFocusChanged(hasFocus);
        break;
    }
  }

  public void savefabOnClicked() {
    if (mainbinding.bottombackground.getVisibility() == View.VISIBLE) {
      FABTRANSITION();
    }
    final double videopositionY = tweetlayoutbinding.container.getTop();
    final double videoscalex = tweetlayoutbinding.videoview1.getWidth();
    final double videoscaley = tweetlayoutbinding.videoview1.getHeight();
    final double backgroundheight = mainbinding.background.getWidth();
    final double backgroundwidth = mainbinding.background.getHeight();
    if (!(videopath.length() == 0)) {
      FileUtil.deleteFile("/storage/emulated/0/DCIM/save.png");
      tweetlayoutbinding.videoview1.setBackgroundColor(0xFFFFFFFF);
      AppUtil.viewToImage(
          mainbinding.background,
          tweetlayoutbinding.videoview1,
          "/storage/emulated/0/DCIM/save.png");
      Intent EXPORTPAGE = new Intent();
      EXPORTPAGE.setClass(getApplicationContext(), ExportActivity.class);
      EXPORTPAGE.putExtra("VIDEOPATH", videopath);
      EXPORTPAGE.putExtra("VIDEOFILENAME", videofilename);
      EXPORTPAGE.putExtra("VIDEOPOSITIONY", String.valueOf(videopositionY));
      EXPORTPAGE.putExtra("VIDEOSCALEX", String.valueOf(videoscalex));
      EXPORTPAGE.putExtra("VIDEOSCALEY", String.valueOf(videoscaley));
      EXPORTPAGE.putExtra("BACKGROUNDHEIGHT", String.valueOf(backgroundheight));
      EXPORTPAGE.putExtra("BACKGROUNDWIDTH", String.valueOf(backgroundwidth));
      EXPORTPAGE.putExtra("DURATION", String.valueOf(tweetlayoutbinding.videoview1.getDuration()));
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

  public void nameOnClicked() {
    tweetlayoutbinding.name.setHint("type a name here...");
    tweetlayoutbinding.name.setHintTextColor(0xFF9E9E9E);
  }

  public void addfileOnClicked() {
    containerheight = tweetlayoutbinding.container.getHeight();
    containerwidth = tweetlayoutbinding.container.getWidth();
    Intent PICKVIDEO = new Intent(Intent.ACTION_PICK);
    PICKVIDEO.setDataAndType(
        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "video/*");
    startActivityForResult(PICKVIDEO, REQ_CD_PICKVIDEO);
  }

  public void profilephotoOnClicked() {
    Intent PICKPROFILEPHOTO = new Intent(Intent.ACTION_PICK);
    PICKPROFILEPHOTO.setDataAndType(
        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
    startActivityForResult(PICKPROFILEPHOTO, REQ_CD_PICKPROFILEPHOTO);
  }

  public void expandfabOnClicked() {
    FABTRANSITION();
  }

  public void toolbarbuttonOnClicked() {
    mainbinding.bottommainbar.removeView(mainbinding.bottombar);
    mainbinding.bottommainbar.addView(toolbinding.getRoot());
    BOTTOMBARLAYOUT = "TOOLBAR";
  }

  public void videobuttonOnClicked() {
    mainbinding.bottommainbar.removeView(mainbinding.bottombar);
    mainbinding.bottommainbar.addView(videobinding.getRoot());
    BOTTOMBARLAYOUT = "VIDEO";
  }

  public void featbuttonOnClicked() {
    mainbinding.bottommainbar.removeView(mainbinding.bottombar);
    mainbinding.bottommainbar.addView(featbinding.getRoot());
    BOTTOMBARLAYOUT = "FEAT";
  }

  public void showhidetoolbarOnClicked() {
    if (tweetlayoutbinding.toolbar.getVisibility() == View.VISIBLE) {
      tweetlayoutbinding.toolbar.setVisibility(View.GONE);
      toolbinding.imageview6.setImageResource(R.drawable.hidden);
    } else {
      tweetlayoutbinding.toolbar.setVisibility(View.VISIBLE);
      toolbinding.imageview6.setImageResource(R.drawable.visible);
    }
  }

  public void showhide3dotOnClicked() {
    if (tweetlayoutbinding.dot3.getVisibility() == View.VISIBLE) {
      tweetlayoutbinding.dot3.setVisibility(View.GONE);
      toolbinding.imageview7.setImageResource(R.drawable.hidden);
    } else {
      tweetlayoutbinding.dot3.setVisibility(View.VISIBLE);
      toolbinding.imageview7.setImageResource(R.drawable.visible);
    }
  }

  public void showhidestatusbarOnClicked() {
    if (tweetlayoutbinding.statusbar.getVisibility() == View.VISIBLE) {
      tweetlayoutbinding.statusbar.setVisibility(View.GONE);
      toolbinding.imageview8.setImageResource(R.drawable.hidden);
    } else {
      tweetlayoutbinding.statusbar.setVisibility(View.VISIBLE);
      toolbinding.imageview8.setImageResource(R.drawable.visible);
    }
  }

  public void showhidedescriptionbuttonOnClicked() {
    if (tweetlayoutbinding.description.getVisibility() == View.VISIBLE) {
      tweetlayoutbinding.description.setVisibility(View.GONE);
      toolbinding.imageview9.setImageResource(R.drawable.hidden);
    } else {
      tweetlayoutbinding.description.setVisibility(View.VISIBLE);
      toolbinding.imageview9.setImageResource(R.drawable.visible);
    }
  }

  public void trimbuttonOnClicked() {
    videobinding.linear0.setVisibility(View.GONE);
    videobinding.videosizebackground.setVisibility(View.GONE);
    videobinding.trimbarbackground.setVisibility(View.VISIBLE);
    TrimView.setVideoPath(videopath);
  }

  public void videosizebuttonOnClicked() {
    videobinding.linear0.setVisibility(View.GONE);
    videobinding.trimbarbackground.setVisibility(View.GONE);
    videobinding.videosizebackground.setVisibility(View.VISIBLE);
  }

  public void replacebuttonOnClicked() {
    Intent REPLACEVIDEO = new Intent(Intent.ACTION_PICK);
    REPLACEVIDEO.setDataAndType(
        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "video/*");
    startActivityForResult(REPLACEVIDEO, REQ_CD_PICKVIDEO);
  }

  public void soundbuttonOnClicked() {
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

  public void movebuttonOnClicked() {
    if (tweetviewmoveable) {
      tweetviewmoveable = false;
      featbinding.imageview6.setImageResource(R.drawable.touch);
      featbinding.textview8.setText("Move");
    } else {
      tweetviewmoveable = true;
      featbinding.imageview6.setImageResource(R.drawable.moving);
      featbinding.textview8.setText("Moving");
    }
  }

  public void tweetviewresizebuttonOnClicked() {
    featbinding.linear1.setVisibility(View.GONE);
    featbinding.linear2.setVisibility(View.VISIBLE);
  }

  public void usernameOnFocusChanged(boolean hasFocus) {
    if (hasFocus) {
      tweetlayoutbinding.username.setHint("type a username here...");
    } else {
      tweetlayoutbinding.username.setHint("@enterusername");
    }
  }

  public void nameOnFocusChanged(boolean hasFocus) {
    if (hasFocus) {
      tweetlayoutbinding.name.setHint("type a name here...");
      tweetlayoutbinding.name.setHintTextColor(0xFF9E9E9E);
    } else {
      tweetlayoutbinding.name.setHint("YOUR NAME");
      tweetlayoutbinding.name.setHintTextColor(0xFF000000);
    }
  }

  public void descriptionOnFocusChanged(boolean hasFocus) {
    if (hasFocus) {
      tweetlayoutbinding.description.setHint("type description here...");
      tweetlayoutbinding.description.setHintTextColor(0xFF9E9E9E);
    } else {
      tweetlayoutbinding.description.setHint("Write description here");
      tweetlayoutbinding.description.setHintTextColor(0xFF000000);
    }
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent event) {
    if (tweetviewmoveable) {
      switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
          dX = tweetlayoutbinding.tweetview.getX() - event.getRawX();
          dY = tweetlayoutbinding.tweetview.getY() - event.getRawY();
          lastAction = MotionEvent.ACTION_DOWN;
          break;
        case MotionEvent.ACTION_MOVE:
          tweetlayoutbinding.tweetview.setY(event.getRawY() + dY);
          tweetlayoutbinding.tweetview.setX(event.getRawX() + dX);
          lastAction = MotionEvent.ACTION_MOVE;
          break;
        case MotionEvent.ACTION_UP:
          if (lastAction == MotionEvent.ACTION_DOWN) break;
      }
    }
    return super.dispatchTouchEvent(event);
  }

  @Override
  public void onProgressChanged(SeekBar seekbar, int param, boolean arg2) {
    final int _progressValue = param;
    tweetlayoutbinding.tweetview.setScaleX((float) _progressValue);
    tweetlayoutbinding.tweetview.setScaleY((float) _progressValue);
  }

  @Override
  public void onStartTrackingTouch(SeekBar seekbar) {}

  @Override
  public void onStopTrackingTouch(SeekBar seekbar) {}
}
