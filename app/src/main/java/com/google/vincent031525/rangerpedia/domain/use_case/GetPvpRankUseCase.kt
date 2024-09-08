package com.google.vincent031525.rangerpedia.domain.use_case

import com.google.vincent031525.rangerpedia.data.data_source.remote.dto.PlayerInfoDto
import com.google.vincent031525.rangerpedia.domain.model.Player
import com.google.vincent031525.rangerpedia.domain.repository.MainRepository
import com.google.vincent031525.rangerpedia.domain.repository.PvpRank
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPvpRankUseCase @Inject constructor(private val repository: MainRepository) {
    suspend operator fun invoke(rank: PvpRank = PvpRank.LEGEND): List<Player> = withContext(Dispatchers.Default) {
        val data = repository.getPvp(rank)
        val playerInfo: MutableMap<String, PlayerInfoDto> = mutableMapOf()
        data.playerInfo.forEach { player ->
            playerInfo.plusAssign(Pair(player.mid, player))
        }
        return@withContext data.top100.mapNotNull { player ->
            playerInfo[player.mid]?.let {
                player.toPlayer(it.player.level, it.playerUnitTeamGroupMap.pvpteam)
            }
        }
    }
}