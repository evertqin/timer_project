package com.timer.common;

import android.text.format.Time;



public class Step implements Protocol {

	public final long id;
	public String name = "";
	public Time defaultTime;
	public String DESC;
	public boolean isFavorited = false;

	public Step(long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Step " + id + ": " + name);
		System.out.println("Default Time: " +  defaultTime);
		System.out.println(DESC);
	}

}
