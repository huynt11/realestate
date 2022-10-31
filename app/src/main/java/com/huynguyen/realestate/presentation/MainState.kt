package com.huynguyen.realestate.presentation

import com.huynguyen.realestate.base.BaseNetworkResult
import com.huynguyen.realestate.data.model.EstateProperty

sealed class MainState {

    object Empty : MainState()

    object LoadingState : MainState()

    class ErrorState(val errorType: BaseNetworkResult.Error) : MainState()

    class SucceedState(val results: List<EstateProperty>) : MainState()
}