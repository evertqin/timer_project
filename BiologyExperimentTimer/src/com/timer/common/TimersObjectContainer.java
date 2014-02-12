package com.timer.common;

import java.util.ArrayList;
import java.util.List;

import android.os.CountDownTimer;


public class TimersObjectContainer {
	private List<CountDownTimer> countDownTimers;
	
	public TimersObjectContainer() {
		countDownTimers = new ArrayList<CountDownTimer>();
	}

	public CountDownTimer getTimer(int index)
			throws ArrayIndexOutOfBoundsException {
		return countDownTimers.get(index);
	}

	public void addTimer(CountDownTimer countDownTimer) {
		countDownTimers.add(countDownTimer);
	}
}
