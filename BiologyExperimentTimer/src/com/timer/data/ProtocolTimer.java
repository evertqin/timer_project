package com.timer.data;

import java.util.Calendar;

import android.text.format.Time;

public class ProtocolTimer implements Timer {
	private Calendar time = null;

	@Override
	public void setEndTime(int hour, int minute) {
		// TODO Auto-generated method stub
		time = Calendar.getInstance();
		time.add(Calendar.HOUR, hour);
		time.add(Calendar.MINUTE, minute);
	}

	@Override
	public void SetEndTime(int minute) {
		// TODO Auto-generated method stub
		setEndTime(0, minute);
	}

	@Override
	public Time getEndTime() {
		// TODO Auto-generated method stub
		if (time != null) {
			Time retTime = new Time();
			retTime.hour = time.get(Calendar.HOUR);
			retTime.minute = time.get(Calendar.MINUTE);
			return retTime;
		} else {
			Time retTime = new Time();
			return retTime;
		}
	}

}
