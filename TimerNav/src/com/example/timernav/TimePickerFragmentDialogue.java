package com.example.timernav;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TimePicker;

public class TimePickerFragmentDialogue extends DialogFragment {

	public Time oTime;
	private TimePicker mTimePicker;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		builder.setView(inflater.inflate(R.layout.data_selector_dialog, null))
				.setPositiveButton("Confirm",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// FIRE ZE MISSILES!
							}
						})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// User cancelled the dialog
								getDialog().cancel();
							}
						}).setTitle("Choose a Time...");
		
		// Create the AlertDialog object and return it
		AlertDialog alertDialog = builder.create();

		return alertDialog;
	}

}
