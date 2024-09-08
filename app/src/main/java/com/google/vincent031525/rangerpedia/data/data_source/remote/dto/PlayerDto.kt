package com.google.vincent031525.rangerpedia.data.data_source.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlayerDto(
    val imageUrl: String,
    val level: Int,
    val usePvPTeamNo: Int,
    val userName: String
)