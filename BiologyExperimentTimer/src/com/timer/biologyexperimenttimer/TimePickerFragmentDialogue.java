package com.timer.biologyexperimenttimer;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.format.Time;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.biologyexperimenttimer.R;

public class TimePickerFragmentDialogue extends DialogFragment {

	public Time oTime;

	public static final int NUM_OF_KEYS = 10;
	public static final int PAD_FONT_SIZE = 50;

	private TextView displayTimeView;

	private List<TextView> textViews;
	private List<LinearLayout> layouts;
	private int enteredTime = 0;

	private View initNumberPad() {

		textViews = new ArrayList<TextView>();
		layouts = new ArrayList<LinearLayout>();

		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.data_selector_dialog, null);
		displayTimeView = (TextView) view.findViewById(R.id.timeDisplay);
		initBackSpace(view);
		setViews(view);
		return view;
	}

	
	private void initBackSpace(View view) {
		ImageView imageView = (ImageView) view.findViewById(R.id.deleteTime);
		imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				enteredTime /= 10;
				formatTimeIntoDisplay();
			}
		});
	}
	
	private void setViews(View view) {
		LinearLayout overallLayout = (LinearLayout) view
				.findViewById(R.id.numberPad);
		for (int i = 0; i < 3; i++) {
			LinearLayout linearLayout = new LinearLayout(getActivity());
			linearLayout.setLayoutParams(new ViewGroup.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT));
			for (int j = i * 3 + 1; j < i * 3 + 4; j++) {
				final TextView tv = new TextView(getActivity());
				tv.setText(Integer.toString(j));
				tv.setTextSize(PAD_FONT_SIZE);
				tv.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
				tv.setGravity(Gravity.CENTER);

				tv.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if (enteredTime < 99999) {

							Integer num = Integer.parseInt(tv.getText()
									.toString());
							enteredTime = enteredTime * 10 + num;
							formatTimeIntoDisplay();
						}
					}
				});

				linearLayout.addView(tv);
				textViews.add(tv);
			}
			layouts.add(linearLayout);

			overallLayout.addView(linearLayout);
		}
	}

	private void formatTimeIntoDisplay() {
		
		int second = enteredTime % 100;
		int minute = enteredTime / 100 % 100;
		int hour = enteredTime / 10000;

		String displayString = String.format(
				"%02d:%02d:%02d", hour, minute, second);
		displayTimeView.setText(displayString);
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		builder.setView(initNumberPad())
				.setPositiveButton("Confirm",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// return the value in the time picker box
								Dashboard dashboard = (Dashboard) getActivity();
								dashboard.onFinishedTimePicker(enteredTime);
							}
						})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// User cancelled the dialog
								getDialog().cancel();
							}
						}).setTitle("Choose a Time...");

		// Create the AlertDialog object and return it
		AlertDialog alertDialog = builder.create();

		return alertDialog;
	}

}
