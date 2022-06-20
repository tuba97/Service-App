package ders.yasin.serviceapp;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;


public class MyIntentService extends IntentService {
    MediaPlayer mp;
    boolean flag;
    int i=0;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String name=intent.getStringExtra("NAME");
            mp=MediaPlayer.create(this,R.raw.short_sound);
            flag=true;
            run();

        }
    }

    private void run() {
        while(flag){
            i++;
            mp.start();
            Log.i("Timer", "Timer" + i + ", thread number:" + Thread.currentThread().getId());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flag=false;
    }
}