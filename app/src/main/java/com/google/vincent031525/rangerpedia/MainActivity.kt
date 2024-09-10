package com.google.vincent031525.rangerpedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.google.vincent031525.rangerpedia.presentation.PvpScreen
import com.google.vincent031525.rangerpedia.ui.theme.RangerpediaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RangerpediaTheme {
                val viewModel: MainViewModel by viewModels()
                SideEffect { viewModel.getPvp() }
                val pvpRank by viewModel.pvpRank.collectAsState()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PvpScreen(modifier = Modifier.padding(innerPadding), pvpRank)
                }
            }
        }
    }
}
