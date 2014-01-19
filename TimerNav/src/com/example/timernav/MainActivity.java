package com.example.timernav;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TimePicker;

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

		mPlanetTitles = new ArrayList<String>();
		Collections.addAll(mPlanetTitles,
				getResources().getStringArray(R.array.plants_array));

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mAdapter = new ArrayAdapter<String>(this, R.layout.drawer_list_item,
				mPlanetTitles);
		mDrawerList.setAdapter(mAdapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		// mLinearLayout = (LinearLayout) findViewById(R.id.right_content);

		if (findViewById(R.id.fragment_container) != null) {
			if (savedInstanceState != null) {
				return;
			}

			mTimerDetailFragment = new TimerDetailFragment();
			mTimerDetailFragment.setArguments(getIntent().getExtras());
			FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
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
		case R.id.action_edit:
			changeName();
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

	private void changeName() {
		NameChangerFragmentDialogue nameChangerFragmentDialogue = new NameChangerFragmentDialogue();
		Bundle args = new Bundle();
		System.out.println(getTitle());
		args.putCharSequence("name", getTitle());
		nameChangerFragmentDialogue.setArguments(args);
		nameChangerFragmentDialogue.show(getSupportFragmentManager(), "yes");
	}
	
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			selectItem(position);
		}

	}

	private void selectItem(int position) {
		TimerDetailFragment fragment = new TimerDetailFragment();
		Bundle args = new Bundle();
		args.putInt("name", position);
		fragment.setArguments(args);
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.fragment_container, fragment).commit();

		mDrawerList.setItemChecked(position, true);
		setTitle(mPlanetTitles.get(position));
		mDrawerLayout.closeDrawer(mDrawerList);
	}

}
