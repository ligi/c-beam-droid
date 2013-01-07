package org.c_base.c_beam;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.widget.TextView;

public class Helper {

	public static void setFont(Activity activity, TextView view) {
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(view.getContext());
		String font = sharedPref.getString("pref_font", "Android Default");
		int fontsize = Integer.parseInt(sharedPref.getString("pref_fontsize", "20"));
		if (font.equals("X-Scale")) {
			view.setPadding(25, 10, 25, 25);
			Typeface myTypeface = Typeface.createFromAsset(activity.getAssets(), "X-SCALE.TTF");
			view.setTypeface(myTypeface);
			view.setTextSize(fontsize);
		} else if (font.equals("Ceva")) {
			view.setPadding(25, 25, 25, 25);
			Typeface myTypeface = Typeface.createFromAsset(activity.getAssets(), "CEVA-CM.TTF");
			view.setTypeface(myTypeface);
			view.setTextSize(fontsize);
		} else {
			view.setPadding(25, 25, 25, 25);
			view.setTextSize(fontsize);
		}

		view.setGravity(Gravity.CENTER_VERTICAL);		
	}
}
