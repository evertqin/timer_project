package com.example.timernav;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.view.animation.Animation;

public class TimerDetailFragment extends Fragment{
	private Animation myAnimation_Alpha;  
	private Animation myAnimation_Scale;  
	private Animation myAnimation_Translate;  
	private Animation myAnimation_Rotate;  
	public String nameString;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View view = inflater.inflate(R.layout.activity_timer_detail_fragment, null);
		
		EditText mTimerEditText = (EditText) view.findViewById(R.id.timeEditor);
		mTimerEditText.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogFragment dialogFragment = new TimePickerFragmentDialogue();			
				dialogFragment.show(getChildFragmentManager(), "yes");

			}
		});
		

		return view;
	}







}
