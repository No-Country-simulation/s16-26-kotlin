package com.nocountry.edunotify.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.nocountry.edunotify.R
import com.nocountry.edunotify.ui.screens.login.LoginScreen
import com.nocountry.edunotify.ui.screens.register.RegisterScreen
import com.nocountry.edunotify.ui.theme.EduNotifyTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRowComponent() {
    val tabItem = listOf(
        stringResource(id = R.string.login),
        stringResource(id = R.string.register)
    )
    val pagerState = rememberPagerState { tabItem.size }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        //topBar = { TopAppBarComponent() },
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                modifier = Modifier.fillMaxWidth(),
            ) {
                tabItem.forEachIndexed { index, title ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            Text(
                                text = title,
                                color = if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary else Color.Gray,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    )
                }
            }
            TabsContent(pagerState = pagerState)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()

    ) { page ->
        when (page) {
            0 -> {
                LoginScreen()
            }

            1 -> {
                RegisterScreen()
            }
        }
    }
}

@Preview
@Composable
fun TabRowComponentPreview() {
    EduNotifyTheme {
        TabRowComponent()
    }
}













