package com.huynguyen.realestate.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huynguyen.realestate.R
import com.huynguyen.realestate.base.BaseNetworkResult
import com.huynguyen.realestate.data.model.EstateProperty
import com.huynguyen.realestate.databinding.ActivityMainBinding
import com.huynguyen.realestate.presentation.adapter.EstateRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObserver()
        viewModel.getEstateList()
    }

    private fun setupObserver() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collectLatest {
                onStateChanged(it)
            }
        }
    }

    private fun onStateChanged(state: MainState) {
        when (state) {
            is MainState.LoadingState -> showLoading(true)
            is MainState.ErrorState -> showError(state.errorType)
            is MainState.SucceedState -> onDataReturn(state.results)
        }
    }

    private fun onDataReturn(results: List<EstateProperty>) {
        showLoading(false)
        hideError()
        val listAdapter = EstateRecyclerViewAdapter(object : EstateRecyclerViewAdapter.OnItemClickListener {
            override fun onLiked(estate: EstateProperty) {
                viewModel.saveFavorite(estate)
            }

            override fun onItemClick(estate: EstateProperty) {

            }})
        listAdapter.updateDataList(results)
        binding.lvEstate.apply {
            visibility = View.VISIBLE
            adapter = listAdapter
            layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            scheduleLayoutAnimation()
        }


    }

    private fun showError(error: BaseNetworkResult.Error) {
        showLoading(false)
        hideRecyclerView()
        binding.tvError.apply {
            visibility = View.VISIBLE
            text = getErrorMessage(error)
        }
    }

    private fun hideError() {
        binding.tvError.visibility = View.GONE
    }

    private fun getErrorMessage(error: BaseNetworkResult.Error): String {
        return when (error) {
            is BaseNetworkResult.NoDataFoundError -> {
                getString(R.string.error_no_data_found)
            }
            is BaseNetworkResult.NetWorkError -> {
                getString(R.string.error_network)
            }
            is BaseNetworkResult.UnCatchError -> {
                error.errorMessage ?: getString(R.string.error_unknown)
            }
            else -> {
                getString(R.string.error_unknown)
            }
        }
    }

    private fun hideRecyclerView() {
        binding.lvEstate.visibility = View.GONE
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
    }
}