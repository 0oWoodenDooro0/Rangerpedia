package com.google.vincent031525.rangerpedia.data.data_source.remote.dto

import com.google.vincent031525.rangerpedia.domain.model.Player
import kotlinx.serialization.Serializable

@Serializable
data class Top100Dto(
    val displayName: String,
    val imageUrl: String,
    val mid: String,
    val nationalFlag: String,
    val rank: Int,
    val score: Int
) {
    fun toPlayer(level: Int, pvpTeam: PvpteamDto): Player {
        return Player(
            rank = rank,
            id = mid,
            userName = displayName,
            level = level,
            imageUrl = imageUrl,
            nationalFlag = nationalFlag,
            score = score,
            pvpteam = pvpTeam.toPvpTeam()
        )
    }
}