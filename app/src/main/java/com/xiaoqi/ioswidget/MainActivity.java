package com.xiaoqi.ioswidget;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
    }

    private void showMenu(){
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View popPhoneListView = inflater.inflate(R.layout.popupwindow_tag, null);
        final PopupWindow popupWindow = new PopupWindow(
                popPhoneListView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        IOSAnimationUtils.setPopupAnimation(MainActivity.this, popupWindow);
        Button btnMid = (Button) popPhoneListView.findViewById(R.id.btn1);
        Button btnHasRent = (Button) popPhoneListView.findViewById(R.id.btn2);
        Button btnNoRent = (Button) popPhoneListView.findViewById(R.id.btn3);
        Button btnNoFunction = (Button) popPhoneListView.findViewById(R.id.btn4);
        Button btnCustom = (Button) popPhoneListView.findViewById(R.id.btn5);
        Button btnClear = (Button) popPhoneListView.findViewById(R.id.btn6);
        Button btnCancel = (Button) popPhoneListView.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(MainActivity.this.getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
    }
}
