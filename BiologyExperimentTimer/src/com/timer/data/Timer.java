package com.timer.data;

import android.text.format.Time;


public interface Timer {
	public void setEndTime(int hour, int minute);
	public void SetEndTime(int minute); // 
	public Time getEndTime(); // return end time in minute
}
