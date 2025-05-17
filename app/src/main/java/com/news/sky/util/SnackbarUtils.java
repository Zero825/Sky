package com.news.sky.util;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class SnackbarUtils {

    /**
     * 显示一个短暂的Snackbar，带有默认颜色的背景
     *
     * @param view    Snackbar要依附的View
     * @param message 要显示的消息字符串
     */
    public static void showShortSnackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * 显示一个短暂的Snackbar，带有指定颜色的背景
     *
     * @param view            Snackbar要依附的View
     * @param message         要显示的消息字符串
     * @param backgroundColor Snackbar的背景颜色
     */
    public static void showShortSnackbar(View view, String message, int backgroundColor) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(backgroundColor);
        snackbar.show();
    }

    /**
     * 显示一个长时间的Snackbar，带有默认颜色的背景
     *
     * @param view    Snackbar要依附的View
     * @param message 要显示的消息字符串
     */
    public static void showLongSnackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    /**
     * 显示一个长时间的Snackbar，带有指定颜色的背景
     *
     * @param view            Snackbar要依附的View
     * @param message         要显示的消息字符串
     * @param backgroundColor Snackbar的背景颜色
     */
    public static void showLongSnackbar(View view, String message, int backgroundColor) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(backgroundColor);
        snackbar.show();
    }
}
