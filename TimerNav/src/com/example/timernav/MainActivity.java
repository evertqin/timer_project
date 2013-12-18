package com.example.timernav;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {

	// private String[] mPlanetTitles;
	private ArrayList<String> mPlanetTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ArrayAdapter<String> mAdapter;
	private LinearLayout mLinearLayout;

	private TimerDetailFragment mTimerDetailFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mPlanetTitles = new ArrayList<String>(Arrays.asList(getResources()
				.getStringArray(R.array.plants_array)));
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mAdapter = new ArrayAdapter<String>(this, R.layout.drawer_list_item,
				mPlanetTitles);
		mDrawerList.setAdapter(mAdapter);

		if (findViewById(R.id.fragment_container) != null) {
			if (savedInstanceState != null) {
				return;
			}

			mTimerDetailFragment = new TimerDetailFragment();
			mTimerDetailFragment.setArguments(getIntent().getExtras());
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.fragment_container, mTimerDetailFragment).commit();
		}


		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.action_add:
			addNewTimerToList();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void addNewTimerToList() {
		mPlanetTitles.add("test");
		mAdapter.notifyDataSetChanged();
	}

}
