package com.huynguyen.realestate.base

sealed class BaseNetworkResult<out T> {

    class Success<out T : Any>(val response : T) : BaseNetworkResult<T>()

    open class Error() : BaseNetworkResult<Nothing>()

    object NoDataFoundError : Error()

    object NetWorkError : Error()

    class UnCatchError(val errorMessage : String? = null, val errorCode: Int? = null) : Error()

}