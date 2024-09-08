package com.google.vincent031525.rangerpedia.data.data_source.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PvpDto(
    val playerInfo: List<PlayerInfoDto>,
    val top100: List<Top100Dto>
)