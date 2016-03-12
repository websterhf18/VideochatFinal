package com.websterh18.videochatfinal.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.websterh18.videochatfinal.R;

/**
 * Created by websterh18 on 11/03/16.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}