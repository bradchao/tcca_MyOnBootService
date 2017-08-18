package tw.brad.android.games.myonbootservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    private Timer timer;
    private NotificationManager nmgr;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("brad", "MyService:onCreate()");
        nmgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        timer = new Timer();
        timer.schedule(new MyTask(), 1000, 3000);
    }

    private class MyTask extends TimerTask {
        @Override
        public void run() {
            Log.i("brad", "task");
            sendNotice();
        }
    }

    private void sendNotice(){
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.android);
        builder.setTicker("你看不到...");
        builder.setContentTitle("重要訊息");
        builder.setContentText("內容");
        builder.setAutoCancel(true);

//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        PendingIntent pendingIntent =
//                stackBuilder.getPendingIntent(
//                        0, PendingIntent.FLAG_UPDATE_CURRENT);
//        builder.setContentIntent(pendingIntent);

        Notification notification = builder.build();
        nmgr.notify(1, notification);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null){
            timer.cancel();
            timer.purge();
            timer = null;
        }
    }
}
