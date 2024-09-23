package com.websarva.wings.android.pagingroomjava.data.repository;

import android.app.Application;

import androidx.paging.PagingSource;

import com.websarva.wings.android.pagingroomjava.data.local.AppDatabase;
import com.websarva.wings.android.pagingroomjava.data.local.Phone;
import com.websarva.wings.android.pagingroomjava.data.local.PhoneDAO;


public class PhoneRepository {
	private AppDatabase _db;

	public PhoneRepository(Application application) {
		_db = AppDatabase.getDatabase(application);
	}

	public PagingSource<Integer, Phone> getAllPhoneListPagingSource() {
		PhoneDAO phoneDAO = _db.createPhoneDAO();
		return phoneDAO.findAll();
	}
}
