package com.xiaoqi.ioswidget;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.xiaoqi.widget.IOSAlertDialog;

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
        Button btnDialog1 = (Button) findViewById(R.id.btn_dialog1);
        btnDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        Button btnDialog2 = (Button) findViewById(R.id.btn_dialog2);
        btnDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog2();
            }
        });
    }

    /**
     * 仿ios菜单
     */
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

    private void showDialog(){
        final IOSAlertDialog dialog = new IOSAlertDialog(this,R.style.iOSAlertDialog,"下线通知","您的账号与13:08在另一台iPhone手机登录。如非本人操作，则密码可能泄露，建议修改密码或紧急冻结账号。");
        dialog.setNegative(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        },"退出");

        dialog.setPositive(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        },"重新登录");
        dialog.show();
    }

    private void showDialog2(){
        final IOSAlertDialog dialog = new IOSAlertDialog(this,R.style.iOSAlertDialog,"下线通知","您的账号与13:08在一台电脑登录。如非本人操作，则密码可能泄露，建议修改密码或紧急冻结账号。");
        dialog.setSingleSelect("确定");
        dialog.setOKBtn(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
