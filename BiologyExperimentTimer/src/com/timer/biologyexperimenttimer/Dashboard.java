package com.timer.biologyexperimenttimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.biologyexperimenttimer.R;
import com.timer.common.ClockTicking;
import com.timer.common.CountDownFinishEvent;
import com.timer.common.CountDownTickingEvent;
import com.timer.common.CountDownTimerWithActiveIndicator;

public class Dashboard extends FragmentActivity {
	private TextView mCountDownTimerTextView;
	private List<Button> mButtons = new ArrayList<Button>();
	private List<CountDownTimerWithActiveIndicator> mCountDownTimers = new ArrayList<CountDownTimerWithActiveIndicator>();
	private CountDownTimerWithActiveIndicator mCurrentCountDownTimer;
	public final int NUM_OF_DISPLAY_BUTTONS = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		mCountDownTimerTextView = (TextView) findViewById(R.id.timerCountDown);
		ClockTicking clockTicking = new ClockTicking(this);
		clockTicking.startClock();
		setTimer();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.favorite_menu:
			Intent intent = new Intent(this, FavoriteAndRecent.class);
			startActivity(intent);
			break;
		default:
		}
		return super.onOptionsItemSelected(item);
	}

	public Button addNewButton(final int ID) {
		Button button = new Button(this);

		final String text = "T" + Integer.toString(ID + 1);
		button.setText(text);

		LinearLayout ll = (LinearLayout) findViewById(R.id.timersButtonContiner);
		LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		ll.addView(button, lp);
		mButtons.add(button);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				mCurrentCountDownTimer.disable();
				mCurrentCountDownTimer = mCountDownTimers.get(ID);
				if (mCurrentCountDownTimer.isFinished()) {
					mCountDownTimerTextView.setText("Done");
				} else {
					mCurrentCountDownTimer.enable();
				}
			}
		});

		return button;
	}

	public void onTimePickerFinished(long enteredTime) {

		if (mCurrentCountDownTimer != null) {
			mCurrentCountDownTimer.disable();
		}
		final Button newButton = addNewButton(mCountDownTimers.size());
		mCurrentCountDownTimer = new CountDownTimerWithActiveIndicator(
				enteredTime, 1000).setTickingCallback(
				new CountDownTickingEvent() {

					@Override
					public void ticking(long millisUntilFinished) {
						// TODO Auto-generated method stub
						String hmsString = String.format(
								Locale.US,
								"%02d:%02d:%02d",
								TimeUnit.MILLISECONDS
										.toHours(millisUntilFinished),
								TimeUnit.MILLISECONDS
										.toMinutes(millisUntilFinished)
										- TimeUnit.HOURS
												.toMinutes(TimeUnit.MILLISECONDS
														.toHours(millisUntilFinished)),
								TimeUnit.MILLISECONDS
										.toSeconds(millisUntilFinished)
										- TimeUnit.MINUTES
												.toSeconds(TimeUnit.MILLISECONDS
														.toMinutes(millisUntilFinished)));

						mCountDownTimerTextView.setText(hmsString);

					}
				}).setFinishCallback(new CountDownFinishEvent() {

			@Override
			public void finish() {
				// TODO Auto-generated method stub
				newButton.getBackground().setColorFilter(0xFFFF0000,
						PorterDuff.Mode.OVERLAY);

			}

			@Override
			public void activeFinish() {
				// TODO Auto-generated method stub
				mCountDownTimerTextView.setText("Done");
			}
		});
		mCountDownTimers.add(mCurrentCountDownTimer);
		mCurrentCountDownTimer.start();

	}

	private void setTimer() {
		TextView countDownTimer = (TextView) findViewById(R.id.timerCountDown);
		countDownTimer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogFragment timePickerFragmentDialogue = new TimePickerFragmentDialogue();
				timePickerFragmentDialogue.show(getSupportFragmentManager()
						.beginTransaction(), "yes");
			}
		});

	}

}
