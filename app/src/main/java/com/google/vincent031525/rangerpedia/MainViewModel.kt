package com.google.vincent031525.rangerpedia

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.vincent031525.rangerpedia.domain.model.Player
import com.google.vincent031525.rangerpedia.domain.use_case.GetPvpRankUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getPvpRankUseCase: GetPvpRankUseCase) : ViewModel() {

    private val _pvpRank = MutableStateFlow(emptyList<Player>())
    val pvpRank: StateFlow<List<Player>> = _pvpRank.asStateFlow()

    fun getPvp() {
        viewModelScope.launch {
            _pvpRank.value = getPvpRankUseCase()
        }
    }
}