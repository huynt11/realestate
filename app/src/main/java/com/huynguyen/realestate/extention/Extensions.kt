package com.huynguyen.realestate.extention

import com.huynguyen.realestate.base.BaseNetworkResult
import com.huynguyen.realestate.data.parser.parseException

internal inline fun <T : Any> runNetworkSafety(block: () -> BaseNetworkResult<T>): BaseNetworkResult<T> {
    runCatching {
        return block.invoke()
    }.onFailure {
        return it.parseException()
    }
    return BaseNetworkResult.UnCatchError()
}