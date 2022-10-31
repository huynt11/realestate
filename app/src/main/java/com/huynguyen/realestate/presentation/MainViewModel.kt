package com.huynguyen.realestate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huynguyen.realestate.base.BaseNetworkResult
import com.huynguyen.realestate.data.model.EstateProperty
import com.huynguyen.realestate.data.repository.EstateRepository
import com.huynguyen.realestate.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val estateRepository: EstateRepository
): ViewModel() {

    private val _state = MutableStateFlow<MainState>(MainState.Empty)
    internal val state: StateFlow<MainState> = _state

    private var queryJob: Job? = null

    internal fun getEstateList() {
        _state.value = MainState.LoadingState
        queryJob?.cancel()
        queryJob = viewModelScope.launch {
            estateRepository.getProperties()
                .flowOn(dispatcherProvider.io())
                .collect {
                    when(it){
                        is BaseNetworkResult.Success -> {
                            _state.value = MainState.SucceedState(it.response)
                        }
                        else -> {
                            _state.value = MainState.ErrorState(it as BaseNetworkResult.Error)
                        }
                    }
                }
        }
    }

    internal fun saveFavorite(estateProperty: EstateProperty) {
        viewModelScope.launch {
            if (estateProperty.isLiked) {
                estateRepository.removeFavorite(estateProperty.id)
            } else {
                estateRepository.saveFavorite(estateProperty.id)
            }
        }
    }
}