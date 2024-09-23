package com.websarva.wings.android.pagingroomkotlin.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query

@Dao
interface PhoneDAO {
	@Query("SELECT * FROM phones ORDER BY id")
	fun findAll(): PagingSource<Int, Phone>
}
