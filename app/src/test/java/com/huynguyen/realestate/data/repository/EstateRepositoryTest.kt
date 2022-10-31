package com.huynguyen.realestate.data.repository

import com.huynguyen.realestate.base.BaseNetworkResult
import com.huynguyen.realestate.data.getEstateResponse
import com.huynguyen.realestate.data.local.LocalDataSource
import com.huynguyen.realestate.data.network.services.EstateService
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EstateRepositoryTest {

    @Mock
    private lateinit var estateService: EstateService

    @Mock
    private lateinit var localStorage: LocalDataSource

    private lateinit var repository: EstateRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(EstateRepositoryTest::class)
        repository = EstateRepositoryImpl(
            estateService = estateService,
            localDataSource = localStorage,
        )
    }

    @Test
    fun `verify successfully get Properties`() {
        runBlocking {
            `when`(estateService.getEstateList())
                .thenReturn(getEstateResponse())

            `when`(localStorage.getFavorites())
                .thenReturn(listOf("104123262"))

            val resultFlow = repository.getProperties()

            resultFlow.collect {
                assert(it is BaseNetworkResult.Success)
                val dataList =
                    (it as BaseNetworkResult.Success).response
                assert(dataList.size == 1)
                val detail = dataList[0]
                assert(detail.isLiked)
                assert(detail.price == "CHF 9999999.0")
            }
        }
    }
}