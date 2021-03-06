package com.todaysfuture.dynpin;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
//THIS CLASS DOES NOT DO ANYTHING.
/**
 * Created by rishabh on 14/2/16.
 */
//0918
public class MyService  extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Calendar c = Calendar.getInstance();
            int hour=c.get(Calendar.HOUR_OF_DAY);
            int minute=c.get(Calendar.MINUTE);
            Calendar calendar = new GregorianCalendar(1990, 1, 1, hour, minute);
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
            String date = sdf.format(calendar.getTime());
            String str=date.charAt(0)+""+date.charAt(1)+""+date.charAt(3)+""+date.charAt(4);
            String LOG_TAG="DevicePolicyAdmin";
            Log.v(LOG_TAG, "Service Started");
            MainActivity.minochaDevicePolicyManager.resetPassword(str, 0);
        }
    }
}
