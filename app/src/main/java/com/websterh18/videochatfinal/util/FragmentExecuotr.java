package com.websterh18.videochatfinal.util;

import android.app.Fragment;
import android.app.FragmentManager;

/**
 * Created by websterh18 on 11/03/16.
 */
public class FragmentExecuotr {
    public static void addFragment(FragmentManager fragmentManager, int containerId, Fragment fragment, String tag) {
        fragmentManager.beginTransaction().replace(containerId, fragment, tag).commitAllowingStateLoss();
    }

    public static void removeFragment(FragmentManager fragmentManager, Fragment fragment) {
        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
    }
}
