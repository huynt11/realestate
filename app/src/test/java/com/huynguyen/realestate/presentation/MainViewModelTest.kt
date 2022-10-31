package com.huynguyen.realestate.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import app.cash.turbine.test
import com.huynguyen.realestate.base.BaseNetworkResult
import com.huynguyen.realestate.coroutineTestRule.CoroutineTestRule
import com.huynguyen.realestate.data.getEstateProperty
import com.huynguyen.realestate.data.repository.EstateRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var mainViewModel: MainViewModel

    @Mock
    private lateinit var estateRepository: EstateRepository


    @Before
    fun init() {
        MockitoAnnotations.openMocks(MainViewModelTest::class)
        mainViewModel = MainViewModel(
            dispatcherProvider = coroutineTestRule.testDispatcherProvider,
            estateRepository = estateRepository
        )
    }

    @Test
    fun `verify save new favorite estate`() {
        runBlockingTest {
            val id = "104123262"
            val property = getEstateProperty()
            mainViewModel.saveFavorite(property)
            verify(estateRepository).saveFavorite(id)
        }
    }

    @Test
    fun `verify remove favorite estate`() {
        runBlockingTest {
            val id = "104123262"

            val property = getEstateProperty()
            property.isLiked = true
            mainViewModel.saveFavorite(property)
            verify(estateRepository).removeFavorite(id)
        }
    }

    @Test
    fun `verify get real estate error response`() {
        runBlockingTest {
            `when`(estateRepository.getProperties()).thenReturn(
                flowOf(BaseNetworkResult.NoDataFoundError)
            )
            mainViewModel.state.test {
                val emission = awaitItem()
                assert(emission is MainState.Empty)

                mainViewModel.getEstateList()
                assert(awaitItem() is MainState.LoadingState)

                val emission2 = awaitItem()
                assert(emission2 is MainState.ErrorState)
            }
        }
    }

    @Test
    fun `verify get real estate with succed data response`() {
        runBlockingTest {
            `when`(estateRepository.getProperties()).thenReturn(
                flowOf(BaseNetworkResult.Success(listOf(getEstateProperty())))
            )

            mainViewModel.state.test {
                val emission = awaitItem()
                assert(emission is MainState.Empty)

                mainViewModel.getEstateList()
                assert(awaitItem() is MainState.LoadingState)

                val emission2 = awaitItem()
                assert(emission2 is MainState.SucceedState)
                val results = (emission2 as MainState.SucceedState).results
                assert(results.size == 1)

                val resultEstate = results[0]
                val expectedEstate = getEstateProperty()
                assert(resultEstate.id == expectedEstate.id)
                assert(resultEstate.location == expectedEstate.location)
                assert(resultEstate.image == expectedEstate.image)
            }

        }
    }
}