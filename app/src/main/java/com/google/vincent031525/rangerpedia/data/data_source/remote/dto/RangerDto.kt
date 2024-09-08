package com.google.vincent031525.rangerpedia.data.data_source.remote.dto

import com.google.vincent031525.rangerpedia.domain.model.Ranger
import kotlinx.serialization.Serializable

@Serializable
data class RangerDto(
    val playerUnitMaxLevel: Int,
    val unitCode: String,
    val unitLevel: Int
) {
    fun toRanger(): Ranger {
        return Ranger(
            unitCode = unitCode,
            unitLevel = unitLevel,
            playerUnitMaxLevel = playerUnitMaxLevel
        )
    }
}