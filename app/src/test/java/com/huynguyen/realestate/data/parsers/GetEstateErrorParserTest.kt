package com.huynguyen.realestate.data.parsers

import android.accounts.NetworkErrorException
import com.huynguyen.realestate.base.BaseNetworkResult
import com.huynguyen.realestate.data.parser.parseException
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException

class GetEstateErrorParserTest {

    @Test
    fun `verify parse exception return NetWorkError with NetworkErrorException, IOException, UnknownHostException `(){
        val networkErrorException = NetworkErrorException()
        val iOException = IOException()
        val unknownHostException = UnknownHostException()

        val result1 = networkErrorException.parseException<Any>()
        assert(result1 is BaseNetworkResult.NetWorkError)

        val result2 = iOException.parseException<Any>()
        assert(result2 is BaseNetworkResult.NetWorkError)

        val result3 = unknownHostException.parseException<Any>()
        assert(result3 is BaseNetworkResult.NetWorkError)
    }

    @Test
    fun `verify parse exception return NoDataFoundError with HttpException and error code is 404`(){
        val httpException = HttpException(Response.error<Any>(404,"Error".toResponseBody()))
        val result = httpException.parseException<Any>()
        assert(result is BaseNetworkResult.NoDataFoundError)
    }

    @Test
    fun `verify parse exception return UnCatchError with HttpException and error code is not 404`(){
        val httpException = HttpException(Response.error<Any>(400,"Error".toResponseBody()))
        val result = httpException.parseException<Any>()
        assert(result is BaseNetworkResult.UnCatchError)
    }

    @Test
    fun `verify parse exception return UnCatchError with error that is not network or http 404 error`(){
        val httpException = NullPointerException()
        val result = httpException.parseException<Any>()
        assert(result is BaseNetworkResult.UnCatchError)
    }
}