package com.google.vincent031525.rangerpedia.data.data_source.remote.dto

import com.google.vincent031525.rangerpedia.domain.model.PvpTeam
import kotlinx.serialization.Serializable

@Serializable
data class PvpteamDto(
    val `1`: List<RangerDto>,
    val `2`: List<RangerDto>? = null,
) {
    fun toPvpTeam(): PvpTeam {
        return PvpTeam(
            first = `1`.map { ranger -> ranger.toRanger() },
            second = `2`?.map { ranger -> ranger.toRanger() }
        )
    }
}