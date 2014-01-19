package com.example.timernav;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class NameChangerFragmentDialogue extends DialogFragment {
	public Time oTime;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View diagView = inflater.inflate(R.layout.name_changer_dialogue, null);
		builder.setView(diagView)
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
						}).setTitle("Enter New Name...");
		;
		// Create the AlertDialog object and return it
		AlertDialog alertDialog = builder.create();
		final EditText editText = (EditText) diagView
				.findViewById(R.id.editName);
		editText.setText(getArguments().getCharSequence("name"));
		editText.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 editText.setSelected(true);
			}
		});
		return alertDialog;
	}
}
