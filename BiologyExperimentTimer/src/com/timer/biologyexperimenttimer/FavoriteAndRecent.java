package com.timer.biologyexperimenttimer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class FavoriteAndRecent extends Activity{
	 ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mViewPager = new ViewPager(this);
		
	}
	   
	 
}
