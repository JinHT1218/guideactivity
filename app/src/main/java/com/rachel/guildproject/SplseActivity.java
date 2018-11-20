package com.rachel.guildproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;
public class SplseActivity extends Activity {
    private VideoView videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("guide",MODE_PRIVATE);
                boolean isfirst = preferences.getBoolean("isfirst",false);
                if (!isfirst) {
                    startActivity(new Intent(SplseActivity.this, GuideActivity.class));
                    SharedPreferences.Editor editor =
                            getSharedPreferences("guide",MODE_PRIVATE).edit();
                    editor.putBoolean("isfirst",true);
                    editor.commit();
                    finish();
                }else{
                    startActivity(new Intent(SplseActivity.this,GuideActivity.class));
                    finish();
                }
            }
        },3000);
    }

}
