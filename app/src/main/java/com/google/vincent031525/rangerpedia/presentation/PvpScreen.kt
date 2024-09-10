package com.google.vincent031525.rangerpedia.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.vincent031525.rangerpedia.domain.model.Player
import com.google.vincent031525.rangerpedia.domain.model.PvpTeam

@Composable
fun PvpScreen(modifier: Modifier = Modifier, pvpRank: List<Player>) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(pvpRank.size, key = { index -> pvpRank[index].id }) { index ->
            PvpPlayerItem(player = pvpRank[index])
        }
    }
}

@Composable
fun PvpPlayerItem(modifier: Modifier = Modifier, player: Player) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = player.rank.toString())
            AsyncImage(
                modifier = Modifier
                    .padding(5.dp)
                    .size(width = 50.dp, height = 50.dp)
                    .clip(CircleShape),
                model = "https://rangers.lerico.net/res/user_profile_img/${player.imageUrl}.png",
                contentDescription = "profile image"
            )
            Column {
                Text(text = player.userName)
                Text(text = "Lv.${player.level}")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = player.score.toString(), modifier = Modifier.padding(horizontal = 10.dp))
        }
    }
}

@Composable
fun PlayerTeamItem(modifier: Modifier = Modifier, team: PvpTeam) {
    Column(modifier = modifier) {
        team.first?.let {
            LazyRow(verticalAlignment = Alignment.Bottom) {
                items(it.size, key = { index -> it[index].unitCode }) { index ->
                    RangerItem(unitcode = it[index].unitCode, level = it[index].unitLevel)
                }
            }
        }
        team.second?.let {
            LazyRow(verticalAlignment = Alignment.Bottom) {
                items(it.size, key = { index -> it[index].unitCode }) { index ->
                    RangerItem(unitcode = it[index].unitCode, level = it[index].unitLevel)
                }
            }
        }
    }
}

@Composable
fun RangerItem(modifier: Modifier = Modifier, unitcode: String, level: Int) {
    Column(modifier = modifier) {
        AsyncImage(
            modifier = Modifier.sizeIn(maxHeight = 100.dp, maxWidth = 50.dp),
            model = "https://rangers.lerico.net/res/$unitcode/$unitcode-thum.png",
            contentDescription = "ranger image"
        )
        Text(text = "Lv.$level")
    }
}