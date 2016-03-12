package com.websterh18.videochatfinal.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by websterh18 on 11/03/16.
 */
public class DialogUtil {
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static  void showToast(Context context, int messageId) {
        Toast.makeText(context, context.getString(messageId), Toast.LENGTH_LONG).show();
    }
}
