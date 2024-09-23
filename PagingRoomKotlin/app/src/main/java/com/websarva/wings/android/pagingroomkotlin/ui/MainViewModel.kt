package com.websarva.wings.android.pagingroomkotlin.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.websarva.wings.android.pagingroomkotlin.data.local.Phone
import com.websarva.wings.android.pagingroomkotlin.data.repository.PhoneRepository
import kotlinx.coroutines.flow.Flow

private const val ITEMS_PER_PAGE = 50

class MainViewModel(application: Application) : AndroidViewModel(application) {
	val phoneListFlow: Flow<PagingData<Phone>>
	private val _phoneRepository: PhoneRepository

	init {
		_phoneRepository  = PhoneRepository(application)
		val phoneListPageSource = _phoneRepository.getAllPhoneListPagingSource()
		val pagingConfig = PagingConfig(ITEMS_PER_PAGE)
		val phoneListPager = Pager(pagingConfig) {phoneListPageSource}
		phoneListFlow = phoneListPager.flow.cachedIn(viewModelScope)
	}
}
