package com.websarva.wings.android.pagingroomkotlin.data.repository

import android.app.Application
import androidx.paging.PagingSource
import com.websarva.wings.android.pagingroomkotlin.data.local.AppDatabase
import com.websarva.wings.android.pagingroomkotlin.data.local.Phone

class PhoneRepository(application: Application) {
	private val _db: AppDatabase

	init {
		_db = AppDatabase.getDatabase(application)
	}

	fun getAllPhoneListPagingSource(): PagingSource<Int, Phone> {
		val phoneDAO = _db.createPhoneDAO()
		return phoneDAO.findAll()
	}
}
