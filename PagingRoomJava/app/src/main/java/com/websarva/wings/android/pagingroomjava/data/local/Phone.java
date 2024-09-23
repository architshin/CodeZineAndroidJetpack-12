package com.websarva.wings.android.pagingroomjava.data.local;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "phones")
public class Phone {
	@PrimaryKey(autoGenerate = true)
	public long id;
	@NonNull
	public String phoneNo;
}
