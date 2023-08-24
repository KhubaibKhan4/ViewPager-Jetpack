package com.codespacepro.viewpagerjetpackcompose.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewPagerScreen() {
    val pageState = rememberPagerState()
    val count = 10

    HorizontalPager(
        pageCount = count,
        state = pageState,


        ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Page No #$it", fontSize = 32.sp)
        }

    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.padding(bottom = 20.dp)) {
            repeat(count) {
                CustomDots(selected = pageState.currentPage == it)
            }
        }
    }


}

@Composable
fun CustomDots(
    selected: Boolean
) {
    Box(
        modifier = Modifier
            .padding(2.dp)
            .background(
                if (selected) Color.Red else Color.LightGray,
                shape = RoundedCornerShape(20.dp)
            )
            .size(10.dp),

        )
}