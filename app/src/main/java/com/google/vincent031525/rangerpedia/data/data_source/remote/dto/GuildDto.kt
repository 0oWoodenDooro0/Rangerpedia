package com.google.vincent031525.rangerpedia.data.data_source.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GuildDto(
    val gid: String,
    val level: Int,
    val name: String,
    val nationalFlag: String
)