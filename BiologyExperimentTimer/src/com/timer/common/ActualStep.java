package com.timer.common;

import android.text.format.Time;



public class ActualStep extends Step{
	// get actually time when user hit the stop button to log the current time
	public Time realTime;
	public ActualStep(long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
		realTime = new Time();
		realTime.setToNow();
	}

}
