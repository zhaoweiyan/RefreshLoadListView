package com.mygit.refreshloadlistview.utils;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mygit.refreshloadlistview.MyApplication;


/**
 * Created by admin on 2015/11/10.
 */
public class MyToast {

    public static void show(String str) {
        if (Utils.notEmpty(str)) {
            Toast.makeText(MyApplication.getContext(), str, Toast.LENGTH_SHORT).show();
        }
    }

    public static void show(int resId) {
        Toast toast = Toast.makeText(MyApplication.getContext(), resId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 自定义位置的toast显示
     *
     * @param str
     * @param gravity
     */
    public static void show(String str, int gravity) {
        Toast toast = Toast.makeText(MyApplication.getContext(), str, Toast.LENGTH_SHORT);
        toast.setGravity(gravity, 0, 0);
        toast.show();
    }

    public static void showLong(String str, int gravity) {
        Toast toast = Toast.makeText(MyApplication.getContext(), str, Toast.LENGTH_LONG);
        toast.setGravity(gravity, 0, 0);
        toast.show();
    }

    /**
     * 自定义位置的toast显示
     *
     * @param str
     * @param gravity
     */
    public static void showCenter(String str, int gravity, int yOffset) {
        Toast toast = Toast.makeText(MyApplication.getContext(), str, Toast.LENGTH_SHORT);
        toast.setGravity(gravity, 0, yOffset);
        toast.show();
    }

    /**
     * 带图片的toast显示
     *
     * @param str
     * @param gravity
     * @param resImgId
     */
    public static void show(String str, int gravity, int resImgId) {
        Toast toast = Toast.makeText(MyApplication.getContext(), str, Toast.LENGTH_LONG);
        toast.setGravity(gravity, 0, 0);
        LinearLayout toastView = (LinearLayout) toast.getView();
        ImageView imageCodeProject = new ImageView(MyApplication.getContext());
        imageCodeProject.setImageResource(resImgId);
        toastView.addView(imageCodeProject, 0);
        toast.show();
    }

//    /**
//     * 自定义toast显示
//     *
//     * @param str
//     */
//    public static void show(Activity context, String str) {
//        LayoutInflater inflater = context.getLayoutInflater();
//        View layout = inflater.inflate(R.layout.toast_paypwd, null);
//        TextView text = (TextView) layout.findViewById(R.id.text);
//        text.setText(str);
//        Toast toast = new Toast(MyApplication.getContext());
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.setView(layout);
//        toast.show();
//    }

}
