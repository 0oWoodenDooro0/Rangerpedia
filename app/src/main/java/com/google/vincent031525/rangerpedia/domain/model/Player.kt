package com.google.vincent031525.rangerpedia.domain.model

data class Player(
    val rank: Int,
    val id: String,
    val userName: String,
    val level : Int,
    val imageUrl: String,
    val nationalFlag: String,
    val score: Int,
    val pvpteam: PvpTeam
)