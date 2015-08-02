package com.ta.mokeyh.teacherapp.util;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.ta.mokeyh.teacherapp.R;

/**
 * Created by mokey on 2015/8/2.
 */
public class ShowSnackbar {
    /**
     *
     * @param view
     * @param message
     */
    public static void showSnackbar(View view, String message) {
        Snackbar.make(view,
                message,
                Snackbar.LENGTH_LONG).show();
    }

    /**
     *
     * @param view
     * @param message
     * @param actionText
     * @param actionClickListener
     */
    public static void showSnackbar(View view, String message, String actionText, View.OnClickListener actionClickListener) {
        Snackbar.make(view,
                message,
                Snackbar.LENGTH_LONG)
                .setAction(actionText, actionClickListener)
                .setActionTextColor(view.getContext().getResources().getColor(R.color.colorPrimary))
                .show();
    }
}
