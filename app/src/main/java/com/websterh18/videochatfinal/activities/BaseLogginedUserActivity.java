package com.websterh18.videochatfinal.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import com.quickblox.users.model.QBUser;
import com.websterh18.videochatfinal.R;
import com.websterh18.videochatfinal.definitions.Consts;
import com.websterh18.videochatfinal.holder.DataHolder;

/**
 * Created by websterh18 on 11/03/16.
 */
public class BaseLogginedUserActivity extends ActionBarActivity {
    private static final String APP_VERSION = "App version";
    static ActionBar mActionBar;
    private Chronometer timerABWithTimer;
    private boolean isStarted = false;

    public void initActionBar() {

        mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.actionbar_view, null);

        TextView numberOfListAB = (TextView) mCustomView.findViewById(R.id.numberOfListAB);
        QBUser loggedUser = DataHolder.getLoggedUser();
        if (loggedUser != null ) {
            int number = DataHolder.getUserIndexByID(loggedUser.getId());
            numberOfListAB.setBackgroundResource(ListUsersActivity.resourceSelector(number));
            numberOfListAB.setText(String.valueOf(number+1));

            TextView loginAsAB = (TextView) mCustomView.findViewById(R.id.loginAsAB);
            loginAsAB.setText(R.string.logged_in_as);
            //
            TextView userNameAB = (TextView) mCustomView.findViewById(R.id.userNameAB);
            userNameAB.setText(String.valueOf(number+1));
        }

        numberOfListAB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(BaseLogginedUserActivity.this);
                dialog.setTitle(APP_VERSION);
                dialog.setMessage(Consts.VERSION_NUMBER);
                dialog.show();
                return true;
            }});


        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

    }

    public void initActionBarWithTimer() {
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.actionbar_with_timer, null);

        timerABWithTimer = (Chronometer) mCustomView.findViewById(R.id.timerABWithTimer);

        TextView loginAsABWithTimer = (TextView) mCustomView.findViewById(R.id.loginAsABWithTimer);
        loginAsABWithTimer.setText(R.string.logged_in_as);

        TextView userNameAB = (TextView) mCustomView.findViewById(R.id.userNameABWithTimer);
        QBUser user = DataHolder.getLoggedUser();
        if (user != null) {
            userNameAB.setText(user.getFullName());
        }

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }

    public void startTimer() {
        if (!isStarted) {
            timerABWithTimer.setBase(SystemClock.elapsedRealtime());
            timerABWithTimer.start();
            isStarted = true;
        }
    }

    public void stopTimer(){
        if (timerABWithTimer != null){
            timerABWithTimer.stop();
            isStarted = false;
        }
    }
}
