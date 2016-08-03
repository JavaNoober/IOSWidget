package com.xiaoqi.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaoqi.ioswidget.R;

public class IOSAlertDialog extends Dialog {

	private OnClickListener positive;
	private OnClickListener negative;
	private OnClickListener middle;
	private EditText editText;
	private LinearLayout input;
	private Button btnPositive;
	private Button btnNegative;
	private LinearLayout midLL;
	private Button btnMid;
	private LinearLayout anotherLL;
	private LinearLayout bottomLL;
	private TextView tvTitle;
	private ImageView ivDelete;
	private RelativeLayout rlTitle;
	private LinearLayout llSelect;
	private Button btnOk;
	private TextView tvContent;
	
	public IOSAlertDialog(Context context, int theme, String title, String content) {
		super(context, theme);
		setContentView(R.layout.alert_dialog);
		tvTitle = (TextView) findViewById(R.id.alert_tv_title);
		rlTitle = (RelativeLayout) findViewById(R.id.alert_rl_title);
		tvContent = (TextView) findViewById(R.id.alert_tv_content);
		ivDelete= (ImageView) findViewById(R.id.alert_iv_delete);
		editText = (EditText) findViewById(R.id.alert_et_input);
		input = (LinearLayout) findViewById(R.id.alert_ll_input);
		midLL = (LinearLayout) findViewById(R.id.alert_mid_ll);
		anotherLL = (LinearLayout) findViewById(R.id.alert_another_ll);
		bottomLL = (LinearLayout) findViewById(R.id.alert_ll_bottom);
		llSelect = (LinearLayout) findViewById(R.id.ll_select);
		btnOk= (Button) findViewById(R.id.alert_btn_ok);
		if (title == null) {
			rlTitle.setVisibility(View.GONE);
		} else {
			rlTitle.setVisibility(View.VISIBLE);
			tvTitle.setText(title);
		}
		tvContent.setText(content);
		btnPositive = (Button) findViewById(R.id.alert_btn_positive);
		btnNegative = (Button) findViewById(R.id.alert_btn_negative);
		btnMid = (Button) findViewById(R.id.alert_btn_mid);
		btnOk.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				IOSAlertDialog.this.dismiss();
				negative.onClick(IOSAlertDialog.this,
						DialogInterface.BUTTON_NEGATIVE);

			}
		});
		btnNegative.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				IOSAlertDialog.this.dismiss();
				negative.onClick(IOSAlertDialog.this,
						DialogInterface.BUTTON_NEGATIVE);

			}
		});

		btnPositive.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				IOSAlertDialog.this.dismiss();
				positive.onClick(IOSAlertDialog.this,
						DialogInterface.BUTTON_POSITIVE);

			}
		});

		btnMid.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				IOSAlertDialog.this.dismiss();
				middle.onClick(IOSAlertDialog.this,
						DialogInterface.BUTTON_NEUTRAL);

			}
		});

		setCancelable(false);
	}

	public void setEditTextVisibility(int visibility) {
		input.setVisibility(visibility);
	}

	public void setEditTextInputType(int type) {
		editText.setInputType(type);
	}

	public void setEditTextContent(String content) {
		editText.setText(content);
	}

	public String getInputContent() {
		return editText.getText().toString();
	}

	public void setPositive(OnClickListener positive) {
		if (positive == null) {
			positive = new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub

				}
			};
		}
		this.positive = positive;
	}

	public void setPositive(OnClickListener positive,
			String text) {
		btnPositive.setText(text);
		if (positive == null) {
			positive = new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub

				}
			};
		}
		this.positive = positive;
	}

	public void setNegative(OnClickListener negative) {
		if (negative == null) {
			negative = new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub

				}
			};
		}
		this.negative = negative;
	}

	public void setNegative(OnClickListener negative,
			String text) {
		btnNegative.setText(text);
		if (negative == null) {
			negative = new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub

				}
			};
		}
		this.negative = negative;
	}

	public void setMiddle(OnClickListener mid, String text) {
		btnMid.setVisibility(View.VISIBLE);
		btnMid.setText(text);
		if (middle == null) {
			middle = new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub

				}
			};
		}
		this.middle = mid;

	}

	public void setOKBtn(OnClickListener negative) {
		if (negative == null) {
			negative = new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub

				}
			};
		}
		this.negative = negative;
	}
	
	public void setNegativeVisibility(int visibility) {
		btnNegative.setVisibility(visibility);
		midLL.setVisibility(visibility);
		anotherLL.setVisibility(View.GONE);
	}

	public IOSAlertDialog(Context context) {
		super(context);
	}
	public void setAllBtnGone() {
		btnPositive.setVisibility(View.GONE);
		btnNegative.setVisibility(View.GONE);
		midLL.setVisibility(View.GONE);
		anotherLL.setVisibility(View.GONE);
		input.setVisibility(View.GONE);
		bottomLL.setVisibility(View.GONE);
	}
	
	public void setTitleColor(int color){
		tvTitle.setTextColor(color);
	}
	
	public void setTitleName(String title){
		tvTitle.setText(title);
	}
	

	/**
	 * 设置只有单一按钮
	 */
	public void setSingleSelect(String btnText){
		llSelect.setVisibility(View.GONE);
		btnOk.setVisibility(View.VISIBLE);	
		btnOk.setText(btnText);
	}
	
	public void setMultiSelect(){
		llSelect.setVisibility(View.VISIBLE);
		btnOk.setVisibility(View.GONE);	
	}
	
	public void setContentColor(int color){
		tvContent.setTextColor(color);
	}
	
	public void setContent(String content){
		tvContent.setText(content);
	}
}
