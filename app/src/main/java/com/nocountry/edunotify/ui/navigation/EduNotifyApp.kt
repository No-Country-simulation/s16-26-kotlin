package com.nocountry.edunotify.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nocountry.edunotify.ui.components.TabRowComponent
import com.nocountry.edunotify.ui.screens.notifications.NotificationsScreen
import com.nocountry.edunotify.ui.screens.notifications.notifications

@Composable
fun EduNotifyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        //NotificationsScreen(notifications)
        TabRowComponent()
    }
}