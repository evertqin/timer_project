package com.example.timernav;

import android.app.AlertDialog;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class TimerDetailFragment extends Fragment {


	private EditText mTimerEditText;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View view = inflater.inflate(R.layout.activity_timer_detail_fragment, null);
		mTimerEditText = (EditText) view.findViewById(R.id.timeEditor);
		mTimerEditText.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
			builder.setTitle("this is fun").setMessage("you see?");
			AlertDialog dialog = builder.create();
			dialog.show();
			}
		});
		
		return view;
	}



}
