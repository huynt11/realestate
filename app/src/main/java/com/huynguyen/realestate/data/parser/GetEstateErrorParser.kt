package com.huynguyen.realestate.data.parser

import android.accounts.NetworkErrorException
import com.huynguyen.realestate.base.BaseNetworkResult
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection
import java.net.UnknownHostException

fun <T : Any> Throwable.parseException(): BaseNetworkResult<T> {
    return when (this) {
        is NetworkErrorException, is IOException, is UnknownHostException -> {
            BaseNetworkResult.NetWorkError
        }

        is HttpException -> {
            if (code() == HttpURLConnection.HTTP_NOT_FOUND) {
                BaseNetworkResult.NoDataFoundError
            } else {
                BaseNetworkResult.UnCatchError(errorMessage = message, errorCode = code())
            }
        }
        else -> BaseNetworkResult.UnCatchError(errorMessage = message)
    }
}