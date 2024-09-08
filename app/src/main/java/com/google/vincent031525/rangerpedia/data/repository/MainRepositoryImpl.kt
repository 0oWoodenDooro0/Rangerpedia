package com.google.vincent031525.rangerpedia.data.repository

import com.google.vincent031525.rangerpedia.data.data_source.remote.RemoteDataSource
import com.google.vincent031525.rangerpedia.data.data_source.remote.dto.PvpDto
import com.google.vincent031525.rangerpedia.domain.repository.MainRepository
import com.google.vincent031525.rangerpedia.domain.repository.PvpRank
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : MainRepository {
    override suspend fun getPvp(rank:PvpRank): PvpDto {
        return remoteDataSource.getPvp(rank)
    }
}