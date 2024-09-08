package com.google.vincent031525.rangerpedia.domain.repository

import com.google.vincent031525.rangerpedia.data.data_source.remote.dto.PvpDto

interface MainRepository {
    suspend fun getPvp(rank: PvpRank): PvpDto
}

enum class PvpRank{
    LEGEND,
    MASTER_1,
    MASTER_2,
    MASTER_3,
    DIAMOND_1,
    DIAMOND_2,
    DIAMOND_3,
    GOLD_1,
    GOLD_2,
    GOLD_3,
    SILVER_1,
    SILVER_2,
    SILVER_3,
    BRONZE
}