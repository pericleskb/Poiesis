package com.moomis.poiesis.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moomis.poiesis.data.models.Poem
import com.moomis.poiesis.data.repositories.PoemsWithAuthorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val poemsWithAuthorRepository: PoemsWithAuthorRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeViewModelState())
    val uiState: StateFlow<HomeViewModelState> = _uiState.asStateFlow()

    init {
        fetchRandomPoems()
    }

    fun fetchRandomPoems() {
        if (_uiState.value.isLoading) return
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val result = poemsWithAuthorRepository.fetchRandomPoems()
                _uiState.update {
                    it.copy(randomPoems = it.randomPoems + result, isLoading = false)
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(isLoading = false, error = e.message ?: "Unknown error")
                }
            }
        }
    }
}

data class HomeViewModelState(
    val randomPoems: List<Poem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
