package com.timer.data;

import android.provider.BaseColumns;

public final class ProtocolEntries {
	public static abstract class ProtocolEntry implements BaseColumns {
		public static final String TABLE_NAME = "protocol";
		public static final String COLUMN_NAME_PROTOCOL_ID = "id";
		public static final String COLUMN_NAME_PROTOCOL_NAME = "name";
		public static final String COLUMN_NAME_PROTOCOL_LAST_USED = "last_used";
		public static final String COLUMN_NAME_PROTOCOL_IS_FAV = "is_favorited";
		public static final String COLUMN_NAME_PROTOCOL_DESCRIPTION = "description";
	}
}
