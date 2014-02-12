package com.timer.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.widget.TextView;

import com.example.biologyexperimenttimer.R;

public class ClockTicking {
	
	private Activity mParentActivity;
	
	public ClockTicking(Activity activity) {
		mParentActivity = activity;
		
	}
	
	private void clockTick() {
		mParentActivity.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				TextView tickingClock = (TextView) mParentActivity.findViewById(R.id.tickingClock);
				Calendar rightNow = Calendar.getInstance();

				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
				String curTime = sdf.format(rightNow.getTime());
				tickingClock.setText(curTime);
			}
		});
	}

	class RunningClock implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (!Thread.currentThread().isInterrupted()) {
				try {
					clockTick();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} catch (Exception e) {

				}
			}
		}

	}

	public void startClock() {
		Thread myThread = null;

		Runnable runnable = new RunningClock();
		myThread = new Thread(runnable);
		myThread.start();
	}
}
