package com.websarva.wings.android.pagingroomjava.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;
import androidx.paging.PagingSource;

import com.websarva.wings.android.pagingroomjava.data.local.Phone;
import com.websarva.wings.android.pagingroomjava.data.repository.PhoneRepository;

import kotlinx.coroutines.CoroutineScope;

public class MainViewModel extends AndroidViewModel {
	private static final int ITEMS_PER_PAGE = 50;
	private PhoneRepository _phoneRepository;
	private LiveData<PagingData<Phone>> _phoneListLiveData;

	public MainViewModel(@NonNull Application application) {
		super(application);
		_phoneRepository = new PhoneRepository(application);

		PagingSource<Integer, Phone> phoneListPageSource = _phoneRepository.getAllPhoneListPagingSource();
		PagingConfig pagingConfig = new PagingConfig(ITEMS_PER_PAGE);
		Pager<Integer, Phone> phoneListPager = new Pager<>(pagingConfig, () -> phoneListPageSource);
		CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(MainViewModel.this);
		_phoneListLiveData = PagingLiveData.cachedIn(PagingLiveData.getLiveData(phoneListPager), viewModelScope);
	}

	public LiveData<PagingData<Phone>> getPhoneListLiveData() {
		return _phoneListLiveData;
	}
}
