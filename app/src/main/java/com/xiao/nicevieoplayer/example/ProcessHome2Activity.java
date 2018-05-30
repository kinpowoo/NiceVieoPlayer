package com.xiao.nicevieoplayer.example;

import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevieoplayer.R;

import static android.view.KeyEvent.KEYCODE_HOME;

public class ProcessHome2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_home2);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new DemoProcessHomeKeyFragenment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (NiceVideoPlayerManager.instance().getCurrentNiceVideoPlayer() != null) {
            if (NiceVideoPlayerManager.instance().getCurrentNiceVideoPlayer().isPaused()) {
                NiceVideoPlayerManager.instance().getCurrentNiceVideoPlayer().start();
            }
        }

    }

}
