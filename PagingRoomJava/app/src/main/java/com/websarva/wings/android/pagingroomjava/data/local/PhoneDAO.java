package com.websarva.wings.android.pagingroomjava.data.local;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface PhoneDAO {
	@Query("SELECT * FROM phones ORDER BY id")
	PagingSource<Integer, Phone> findAll();
}
