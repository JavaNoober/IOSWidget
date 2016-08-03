package com.xiaoqi.ioswidget;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class IOSAnimationUtils {

	public static void setPopupAnimation(final Activity activity,
			PopupWindow popupWindow) {
		((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0)
				.startAnimation(AnimationUtils.loadAnimation(activity,
								R.anim.anim_bg_enter));

		popupWindow.setOnDismissListener(new OnDismissListener() {

			@Override
			public void onDismiss() {
				((ViewGroup) activity.findViewById(android.R.id.content))
						.getChildAt(0).startAnimation(AnimationUtils.loadAnimation(activity,
										R.anim.anim_bg_out));
			}
		});
		popupWindow.setAnimationStyle(R.style.popwin_anim_style);
	}
	
}
