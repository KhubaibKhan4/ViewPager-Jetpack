package com.codespacepro.viewpagerjetpackcompose.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticleViewPager() {

    val counter = 10
    val pagersState = rememberPagerState()

    HorizontalPager(pageCount = counter, state = pagersState) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_launcher_background),
//                contentDescription = null
//            )
            Text(text = "Page # $it", fontSize = 24.sp)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row {
            repeat(counter) {
                CustomIndic(selected = pagersState.currentPage == it)
            }
        }

    }

}

@Composable
fun CustomIndic(selected: Boolean) {
    Box(
        modifier = Modifier
            .padding(2.dp)
            .background(color = if (selected) Color.Red else Color.LightGray, shape = CircleShape)
            .size(8.dp)
    )
}