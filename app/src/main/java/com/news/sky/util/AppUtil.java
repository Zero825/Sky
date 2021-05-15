package com.news.sky.util;

import android.content.Context;

import com.news.sky.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AppUtil {

    /**
     * 根据毫秒时间戳来格式化字符串
     * 今天显示今天、昨天显示昨天、前天显示前天.
     * 早于前天的显示具体年-月-日，如2017-06-12；
     * @param timeStamp 毫秒值
     * @return 今天 昨天 前天 或者 yyyy-MM-dd HH:mm:ss类型字符串
     */
    public static String timeFormat(long timeStamp) {
        long curTimeMillis = System.currentTimeMillis();
        Calendar calendar=Calendar.getInstance();
        int todayHoursSeconds = calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60;
        int todayMinutesSeconds = calendar.get(Calendar.MINUTE) * 60;
        int todaySeconds = calendar.get(Calendar.SECOND);
        int todayMillis = (todayHoursSeconds + todayMinutesSeconds + todaySeconds) * 1000;
        long todayStartMillis = curTimeMillis - todayMillis;
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
        if(timeStamp >= todayStartMillis) {
            return "今天 "+sdf1.format(new Date(timeStamp));
        }
        int oneDayMillis = 24 * 60 * 60 * 1000;
        long yesterdayStartMilis = todayStartMillis - oneDayMillis;
        if(timeStamp >= yesterdayStartMilis) {
            return "昨天 "+sdf1.format(new Date(timeStamp));
        }
        long yesterdayBeforeStartMilis = yesterdayStartMilis - oneDayMillis;
        if(timeStamp >= yesterdayBeforeStartMilis) {
            return "前天 "+sdf1.format(new Date(timeStamp));
        }
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return  sdf2.format(new Date(timeStamp));
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}
