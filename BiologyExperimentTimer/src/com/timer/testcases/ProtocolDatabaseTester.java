package com.timer.testcases;

import junit.framework.TestResult;

import com.timer.data.ProtocolDatabaseHelper;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

public class ProtocolDatabaseTester extends AndroidTestCase {
	private ProtocolDatabaseHelper db;

	public void setUp() {
		RenamingDelegatingContext context = new RenamingDelegatingContext(
				getContext(), "test_");
		db = new ProtocolDatabaseHelper(context);
	}

	public void testAddEntry() {
		// Here i have my new database wjich is not connected to the standard
		// database of the App
		
		System.out.println("This is called");
		System.out.println(db.getDatabaseName());
		db.seleteTest(db.getReadableDatabase());
	}

	public void tearDown() throws Exception {
		db.close();
		super.tearDown();
	}

}
