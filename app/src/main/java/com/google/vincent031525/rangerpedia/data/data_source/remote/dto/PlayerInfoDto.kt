package com.google.vincent031525.rangerpedia.data.data_source.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlayerInfoDto(
    val guild: GuildDto,
    val lastFetched: String,
    val mid: String,
    val player: PlayerDto,
    val playerUnitTeamGroupMap: PlayerUnitTeamGroupMapDto
)