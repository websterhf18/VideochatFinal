package com.websterh18.videochatfinal.util;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.util.Log;

/**
 * Created by websterh18 on 11/03/16.
 */
public class CameraUtils {
    private static final String TAG = CameraUtils.class.getSimpleName();

    public static CameraInfo getCameraInfo(int deviceId){

        CameraInfo info = null;

        try {
            info = new CameraInfo();
            Camera.getCameraInfo(deviceId, info);
        } catch (Exception var3) {
            info = null;
            Log.e(TAG, "getCameraInfo failed on device " + deviceId);
        }
        return info;
    }

    public static boolean isCameraFront(int deviceId){
        CameraInfo cameraInfo = getCameraInfo(deviceId);
        return (cameraInfo != null && cameraInfo.facing == 1);
    }
}
