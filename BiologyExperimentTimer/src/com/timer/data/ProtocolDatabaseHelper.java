package com.timer.data;

import com.timer.data.ProtocolEntries.ProtocolEntry;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ProtocolDatabaseHelper extends SQLiteOpenHelper {
	// If you change the database schema, you must increment the database
	// version.
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "ExperimentTimer.db";

	private static final String TEXT_TYPE = " TEXT";
	private static final String DATATIME_TYPE = " DATETIME";
	//private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_TABLE = "CREATE TABLE "
			+ ProtocolEntry.TABLE_NAME + " (" 
			+ ProtocolEntry.COLUMN_NAME_PROTOCOL_ID+ " INTEGER PRIMARY KEY," 
			+ ProtocolEntry.COLUMN_NAME_PROTOCOL_NAME + TEXT_TYPE + ", "
			+ ProtocolEntry.COLUMN_NAME_PROTOCOL_LAST_USED + DATATIME_TYPE + ", "
			+ ProtocolEntry.COLUMN_NAME_PROTOCOL_IS_FAV + " INTEGER, "
			+ ProtocolEntry.COLUMN_NAME_PROTOCOL_DESCRIPTION + TEXT_TYPE
			+  " )";
	
	private static final String SQL_ADD_DUMMY_ENTRY_STRING = "INSERT INTO " + ProtocolEntry.TABLE_NAME
			+ " VALUES(1, 'test, this is meaningless', 0,2, 'dsd')";
	

	private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "
			+ ProtocolEntry.TABLE_NAME;

	public ProtocolDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_CREATE_TABLE);
		db.execSQL(SQL_ADD_DUMMY_ENTRY_STRING);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	public void seleteTest(SQLiteDatabase db) throws SQLException{
		
		final String query = "SELECT " + ProtocolEntry.COLUMN_NAME_PROTOCOL_NAME + " FROM " + ProtocolEntry.TABLE_NAME;
		final Cursor cursor = db.rawQuery(query, null);
		try {
			
			if(cursor.moveToFirst()) {
				System.out.println(cursor.getString(0));
			}
		} finally {
			cursor.close();
		}
		
	}
	

}
