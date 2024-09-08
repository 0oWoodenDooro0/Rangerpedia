package com.google.vincent031525.rangerpedia.data.data_source.remote

import com.google.vincent031525.rangerpedia.data.data_source.remote.dto.PvpDto
import com.google.vincent031525.rangerpedia.domain.repository.PvpRank
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val httpClient: HttpClient) {
    suspend fun getPvp(rank: PvpRank): PvpDto = withContext(Dispatchers.IO) {
        return@withContext httpClient.get("api/v2/pvp/league/rank/${rank.name}") {}.body()
    }
}