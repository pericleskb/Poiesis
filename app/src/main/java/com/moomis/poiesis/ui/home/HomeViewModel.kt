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
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class HomeViewModelState(
    val randomPoems: List<Poem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class HomeViewModel(poemsRepository: PoemsRepository): ViewModel() {

    private val _uiState = MutableStateFlow(HomeViewModelState())
    val uiState: StateFlow<HomeViewModelState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val result = poemsRepository.fetchRandomPoems()
                _uiState.update {
                    it.copy(
                        randomPoems = it.randomPoems + result,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Unknown error"
                    )
                }
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