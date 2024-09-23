package com.websarva.wings.android.pagingroomkotlin.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phones")
data class Phone(
	@PrimaryKey(autoGenerate = true)
	val id: Long,
	val phoneNo: String
)
