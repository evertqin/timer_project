package com.timer.common;

import android.os.CountDownTimer;

public class CountDownTimerWithActiveIndicator extends CountDownTimer {

	private boolean mIsActive = true;
	private boolean mIsFinished = false;

	private CountDownTickingEvent mCdte;
	private CountDownFinishEvent mCdfe;

	public CountDownTimerWithActiveIndicator(long millisInFuture,
			long countDownInterval) {
		super(millisInFuture, countDownInterval);
	}

	public CountDownTimerWithActiveIndicator setFinishCallback(
			CountDownFinishEvent cdfe) {
		mCdfe = cdfe;
		return this;
	}

	public CountDownTimerWithActiveIndicator setTickingCallback(
			CountDownTickingEvent cdte) {
		mCdte = cdte;
		return this;
	}

	public void enable() {
		mIsActive = true;
	}

	public void disable() {
		mIsActive = false;
	}

	public boolean isActive() {
		return mIsActive;
	}

	public boolean isFinished() {
		return mIsFinished;
	}

	@Override
	public void onFinish() {
		// TODO Auto-generated method stub
		if (mCdfe != null) {
			mCdfe.finish();
		}
	}

	@Override
	public void onTick(long millisUntilFinished) {
		// TODO Auto-generated method stub
		if (mCdte != null) {
			if (mIsActive) {
				mCdte.ticking(millisUntilFinished);
			}
		}
	}

}
