package com.editlike.app;

import android.net.Uri;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.arthenica.ffmpegkit.ReturnCode;
import com.arthenica.ffmpegkit.FFmpegSession;
import com.arthenica.ffmpegkit.FFmpegKit;
import com.arthenica.ffmpegkit.FFmpegSessionCompleteCallback;
import com.editlike.app.AppUtil;
import com.editlike.app.FileUtil;
import com.itsaky.androidide.logsender.LogSender;
import io.michaelrocks.paranoid.Obfuscate;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import android.os.ParcelFileDescriptor;
import android.os.Build;
import android.content.Intent;
import android.view.ViewGroup;
import com.unity3d.services.banners.IUnityBannerListener;
import com.unity3d.services.banners.UnityBanners;
import com.editlike.app.databinding.ExportBinding;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Obfuscate
public class ExportActivity extends AppCompatActivity {

  private ExportBinding binding;
  private Calendar cal = Calendar.getInstance();
  private Calendar cal1 = Calendar.getInstance();
  private Uri uriSavedVideo;
  private ContentValues values;
  private ParcelFileDescriptor pfd;
  private String cmd;
  private String[] fixedcmd;
  private String exportvideoname;
  private String exportvideopath;
  private String STARTTIME;
  private String ENDTIME;
  private String PlacementID = "ExportBanner";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LogSender.startLogging(this);
    binding = ExportBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    
    final String videopath = getIntent().getStringExtra("VIDEOPATH").replace(getIntent().getStringExtra("VIDEOFILENAME"), "'".concat(getIntent().getStringExtra("VIDEOFILENAME").concat("'")));
    final double videopositionY = Double.parseDouble(getIntent().getStringExtra("VIDEOPOSITIONY"));
    final double videoscalex = Double.parseDouble(getIntent().getStringExtra("VIDEOSCALEX"));
    final double videoscaley = Double.parseDouble(getIntent().getStringExtra("VIDEOSCALEY"));
    final double backgroundheight =
        Double.parseDouble(getIntent().getStringExtra("BACKGROUNDHEIGHT"));
    final double backgroundwidth =
        Double.parseDouble(getIntent().getStringExtra("BACKGROUNDWIDTH"));
    final double duration = Double.parseDouble(getIntent().getStringExtra("DURATION"));

    if (getIntent().hasExtra("STARTTIME")) {
      STARTTIME = getIntent().getStringExtra("STARTTIME");
    }
    if (getIntent().hasExtra("ENDTIME")) {
      ENDTIME = getIntent().getStringExtra("ENDTIME");
    }

    binding.exportingview.setVisibility(View.VISIBLE);
    binding.savedview.setVisibility(View.GONE);

    IUnityBannerListener bannerListener =
        new IUnityBannerListener() {
          @Override
          public void onUnityBannerLoaded(String s, View view) {
            ((ViewGroup) binding.banneradview).removeView(view);
            ((ViewGroup) binding.banneradview).addView(view);
          }

          @Override
          public void onUnityBannerUnloaded(String s) {
            // Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onUnityBannerShow(String s) {
            // Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onUnityBannerClick(String s) {
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onUnityBannerHide(String s) {
            // Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onUnityBannerError(String s) {
            // Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
          }
        };
    UnityBanners.setBannerListener(bannerListener);
    UnityBanners.loadBanner(this, PlacementID);

    FileUtil.makeDir("/storage/emulated/0/Movies/EditLike/");

    cal = Calendar.getInstance();
    exportvideoname = new SimpleDateFormat("yyyyMMddHHmmssSSSa").format(cal.getTime());
    exportvideopath = "/storage/emulated/0/Movies/EditLike/" + exportvideoname + ".mp4";

    /*
    if (STARTTIME != null && ENDTIME != null) {
      cmd =
          new String[] {
            "-y -i /storage/emulated/0/DCIM/save.png -ss ",
            STARTTIME,
            " -to ",
            ENDTIME,
            " -i ",
            videopath,
            " -filter_complex \"[1:v]scale=",
            String.valueOf(videoscalex),
            ":",
            String.valueOf(videoscaley),
            "[vid]; [0:v]scale=",
            String.valueOf(backgroundheight),
            ":",
            String.valueOf(backgroundwidth),
            "[img]; [img][vid] overlay=(W-w)/2:y=",
            String.valueOf(videopositionY),
            "\" -b:v 3000k -maxrate 3000k ",
            exportvideopath
          };
    } else {
      cmd =
          new String[] {
            "-y -i /storage/emulated/0/DCIM/save.png -i ",
            videopath,
            " -filter_complex \"[1:v]scale=",
            String.valueOf(videoscalex),
            ":",
            String.valueOf(videoscaley),
            "[vid]; [0:v]scale=",
            String.valueOf(backgroundheight),
            ":",
            String.valueOf(backgroundwidth),
            "[img]; [img][vid] overlay=(W-w)/2:y=",
            String.valueOf(videopositionY),
            "\" -b:v 3000k -maxrate 3000k ",
            exportvideopath,
          };
    }
    */

    // FFMPEG COMMAND
    try {
      binding.textview1.setText("EXPORTING...");
      binding.progressbar1.setVisibility(View.VISIBLE);
      if (STARTTIME != null && ENDTIME != null) {
        cmd =
            "-y -i /storage/emulated/0/DCIM/save.png -ss "
                + STARTTIME
                + " -to "
                + ENDTIME
                + " -i "
                + videopath
                + " -filter_complex \"[1:v]scale="
                + String.valueOf(videoscalex)
                + ":"
                + String.valueOf(videoscaley)
                + "[vid]; [0:v]scale="
                + String.valueOf(backgroundheight)
                + ":"
                + String.valueOf(backgroundwidth)
                + "[img]; [img][vid] overlay=(W-w)/2:y="
                + String.valueOf(videopositionY)
                + "\" -b:v 3000k -maxrate 3000k "
                + exportvideopath;
      } else {
        cmd =
            "-y -i /storage/emulated/0/DCIM/save.png -i "
                + videopath
                + " -filter_complex \"[1:v]scale="
                + String.valueOf(videoscalex)
                + ":"
                + String.valueOf(videoscaley)
                + "[vid]; [0:v]scale="
                + String.valueOf(backgroundheight)
                + ":"
                + String.valueOf(backgroundwidth)
                + "[img]; [img][vid] overlay=(W-w)/2:y="
                + String.valueOf(videopositionY)
                + "\" -b:v 3000k -maxrate 3000k "
                + exportvideopath;
      }
      final double sessionId =
          FFmpegKit.executeAsync(
                  cmd,
                  new FFmpegSessionCompleteCallback() {
                    @Override
                    public void apply(FFmpegSession session) {
                      runOnUiThread(
                          new Runnable() {
                            @Override
                            public void run() {
                              if (ReturnCode.isSuccess(session.getReturnCode())) {
                                values = new ContentValues();
                                if (Build.VERSION.SDK_INT >= 29) {
                                  if (FileUtil.isExistFile("/storage/emulated/0/Movies/")) {
                                    FileUtil.deleteFile("/storage/emulated/0/DCIM/save.png");
                                    values.put(
                                        android.provider.MediaStore.Video.Media.TITLE,
                                        exportvideoname);
                                    values.put(
                                        android.provider.MediaStore.Video.Media.DISPLAY_NAME,
                                        exportvideoname + ".mp4");
                                    values.put(
                                        android.provider.MediaStore.Video.Media.MIME_TYPE,
                                        "video/mp4");
                                    values.put(
                                        android.provider.MediaStore.Video.Media.RELATIVE_PATH,
                                        "Movies/EditLike");
                                    values.put(
                                        android.provider.MediaStore.Video.Media.DATE_ADDED,
                                        System.currentTimeMillis() / 1000);
                                    values.put(
                                        android.provider.MediaStore.Video.Media.DURATION, duration);
                                    Uri collection =
                                        android.provider.MediaStore.Video.Media.getContentUri(
                                            android.provider.MediaStore.VOLUME_EXTERNAL_PRIMARY);
                                    uriSavedVideo = getContentResolver().insert(collection, values);
                                    binding.exportingview.setVisibility(View.GONE);
                                    binding.savedview.setVisibility(View.VISIBLE);
                                  } else {
                                    FileUtil.makeDir("/storage/emulated/0/Movies/EditLike/");
                                    FileUtil.deleteFile("/storage/emulated/0/DCIM/save.png");
                                    values.put(
                                        android.provider.MediaStore.Video.Media.TITLE,
                                        exportvideoname);
                                    values.put(
                                        android.provider.MediaStore.Video.Media.DISPLAY_NAME,
                                        exportvideoname + ".mp4");
                                    values.put(
                                        android.provider.MediaStore.Video.Media.MIME_TYPE,
                                        "video/mp4");
                                    values.put(
                                        android.provider.MediaStore.Video.Media.RELATIVE_PATH,
                                        "Movies/EditLike");
                                    values.put(
                                        android.provider.MediaStore.Video.Media.DATE_ADDED,
                                        System.currentTimeMillis() / 1000);
                                    values.put(
                                        android.provider.MediaStore.Video.Media.DURATION, duration);
                                    Uri collection =
                                        android.provider.MediaStore.Video.Media.getContentUri(
                                            android.provider.MediaStore.VOLUME_EXTERNAL_PRIMARY);
                                    uriSavedVideo = getContentResolver().insert(collection, values);
                                    binding.exportingview.setVisibility(View.GONE);
                                    binding.savedview.setVisibility(View.VISIBLE);
                                  }
                                } else {
                                  if (FileUtil.isExistFile("/storage/emulated/0/Movies/")) {
                                    FileUtil.deleteFile("/storage/emulated/0/DCIM/save.png");
                                    values.put(
                                        android.provider.MediaStore.Video.Media.TITLE,
                                        exportvideoname);
                                    values.put(
                                        android.provider.MediaStore.Video.Media.MIME_TYPE,
                                        "video/mp4");
                                    values.put(
                                        android.provider.MediaStore.Video.Media.DATA,
                                        exportvideopath);
                                    getContentResolver()
                                        .insert(
                                            android.provider.MediaStore.Video.Media
                                                .EXTERNAL_CONTENT_URI,
                                            values);
                                    binding.exportingview.setVisibility(View.GONE);
                                    binding.savedview.setVisibility(View.VISIBLE);
                                  } else {
                                    FileUtil.makeDir("/storage/emulated/0/Movies/EditLike/");
                                    FileUtil.deleteFile("/storage/emulated/0/DCIM/save.png");
                                    values.put(
                                        android.provider.MediaStore.Video.Media.TITLE,
                                        exportvideoname);
                                    values.put(
                                        android.provider.MediaStore.Video.Media.MIME_TYPE,
                                        "video/mp4");
                                    values.put(
                                        android.provider.MediaStore.Video.Media.DATA,
                                        exportvideopath);
                                    getContentResolver()
                                        .insert(
                                            android.provider.MediaStore.Video.Media
                                                .EXTERNAL_CONTENT_URI,
                                            values);
                                    binding.exportingview.setVisibility(View.GONE);
                                    binding.savedview.setVisibility(View.VISIBLE);
                                  }
                                }

                                if (Build.VERSION.SDK_INT >= 29) {
                                  values.put(
                                      android.provider.MediaStore.Video.Media.DATE_TAKEN,
                                      System.currentTimeMillis());
                                  values.put(android.provider.MediaStore.Video.Media.IS_PENDING, 1);
                                }

                                if (Build.VERSION.SDK_INT >= 29) {
                                  try {
                                    pfd =
                                        getContentResolver().openFileDescriptor(uriSavedVideo, "w");
                                    FileOutputStream out =
                                        new FileOutputStream(pfd.getFileDescriptor());
                                    // get the already saved video as fileinputstream
                                    // The Directory where your file is saved
                                    File storageDir =
                                        new File("/storage/emulated/0/Movies/EditLike");
                                    // Directory and the name of your video file to copy
                                    File videoFile = new File(storageDir, exportvideoname + ".mp4");
                                    FileInputStream in = new FileInputStream(videoFile);
                                    byte[] buf = new byte[8192];
                                    int len;
                                    while ((len = in.read(buf)) > 0) {
                                      out.write(buf, 0, len);
                                    }
                                    out.close();
                                    in.close();
                                    pfd.close();
                                    FileUtil.deleteFile(exportvideopath);
                                  } catch (Exception e) {
                                    e.printStackTrace();
                                  }
                                }
                                if (Build.VERSION.SDK_INT >= 29) {
                                  values.clear();
                                  values.put(android.provider.MediaStore.Video.Media.IS_PENDING, 0);
                                  getContentResolver().update(uriSavedVideo, values, null, null);
                                }

                              } else {
                                FileUtil.deleteFile("/storage/emulated/0/DCIM/save.png");
                                FileUtil.deleteFile(exportvideopath);
                                UnityBanners.destroy();
                                FileUtil.writeFile(
                                    FileUtil.getPackageDataDir(getApplicationContext())
                                        .concat("FailLogsTree.txt"),
                                    session.getAllLogs().toString());
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Failed! See logs for more info",
                                        Toast.LENGTH_SHORT)
                                    .show();
                                finish();
                              }
                            }
                          });
                    }
                  })
              .getSessionId();
    } catch (Exception e) {
      Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
      UnityBanners.destroy();
    }

    binding.sharebutton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (Build.VERSION.SDK_INT >= 29) {
              File share =
                  new File(
                      "/storage/emulated/0/Movies/EditLike/" + exportvideoname + " (1)" + ".mp4");
              Uri uri;
              uri = Uri.parse(share.getPath());
              Intent shareintent;
              try {
                shareintent = new Intent(Intent.ACTION_SEND);
                shareintent.setType("*/*");
                shareintent.putExtra(Intent.EXTRA_STREAM, uri);
                shareintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              } catch (Exception e) {
                throw new RuntimeException(e);
              }
              startActivity(Intent.createChooser(shareintent, "share file via"));
            } else {
              File share = new File(exportvideopath);
              Uri uri;
              uri = Uri.parse(share.getPath());
              Intent shareintent;
              try {
                shareintent = new Intent(Intent.ACTION_SEND);
                shareintent.setType("*/*");
                shareintent.putExtra(Intent.EXTRA_STREAM, uri);
                shareintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              } catch (Exception e) {
                throw new RuntimeException(e);
              }
              startActivity(Intent.createChooser(shareintent, "share file via"));
            }
          }
        });
  }

  @Override
  public void onBackPressed() {
    FFmpegKit.cancel();
    UnityBanners.destroy();
    finish();
  }
}

