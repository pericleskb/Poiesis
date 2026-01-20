package com.moomis.poiesis.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.moomis.poiesis.data.dataSources.PoemsRemoteDataSource
import com.moomis.poiesis.data.models.Poem
import com.moomis.poiesis.data.repositories.PoemsRepository
import com.moomis.poiesis.network.PoetryApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModelState(
    val randomPoems: List<Poem> = listOf()
)

class HomeViewModel(poemsRepository: PoemsRepository): ViewModel() {

    private val _uiState = MutableStateFlow(HomeViewModelState())
    val uiState: StateFlow<HomeViewModelState> = _uiState

    init {
        viewModelScope.launch {
            val result = poemsRepository.fetchRandomPoems()
            _uiState.update {
                it.randomPoems.plus(result)
                return@update it
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val poemsRepository = PoemsRepository( //change to DI
                    PoemsRemoteDataSource(
                        PoetryApi.retrofitService, Dispatchers.IO
                    )
                )
                HomeViewModel(poemsRepository)
            }
        }
    }
}