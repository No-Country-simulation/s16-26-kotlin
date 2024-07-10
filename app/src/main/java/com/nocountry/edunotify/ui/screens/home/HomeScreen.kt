package com.nocountry.edunotify.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocountry.edunotify.R
import com.nocountry.edunotify.ui.components.CircleButtonComponent
import com.nocountry.edunotify.ui.components.SpacerComponent
import com.nocountry.edunotify.ui.components.TopAppBarComponent
import com.nocountry.edunotify.ui.theme.EduNotifyTheme


//Mock data
data class Notification(
    val message: String,
    val expiration: Int
)

val notifications = listOf(
    Notification(message = "Message1", expiration = 1),
    Notification(message = "Message2", expiration = 1),
    Notification(message = "Message3", expiration = 1),
    Notification(message = "Message4", expiration = 1),
)

@Composable
fun HomeScreen(notifications: List<Notification>) {
    val message by rememberSaveable { mutableStateOf(notifications[0].message) }

    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = R.string.app_name,
                navigationIcon = { /*TODO*/ },
                actions = {
                    CircleButtonComponent(
                        onClick = { /*TODO*/ },
                        icon = R.drawable.log_out,
                    )
                },
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            if (message.isNotEmpty()) {
                CoursesCardList(notifications = notifications)
            } else {
                CourseEmptyList(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                )
            }
            AddNewCourse(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun CoursesCardList(notifications: List<Notification>) {
    LazyColumn {
        items(notifications) { notification ->
            SpacerComponent(height = 5.dp)
            CourseCard(
                notification = notification,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
fun CourseCard(notification: Notification, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .shadow(4.dp, shape = RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.inverseOnSurface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.inversePrimary),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = notification.message,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        SpacerComponent(height = 5.dp)
        Text(
            text = "Expira en ${notification.expiration} semana",
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
    }
}

@Composable
fun CourseEmptyList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.no_courses),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .size(300.dp)
        )
        SpacerComponent(height = 10.dp)
        Text(
            text = stringResource(id = R.string.home_no_notifications_title),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = stringResource(id = R.string.home_no_notifications_message),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun AddNewCourse(modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(bottom = 25.dp)) {
        SpacerComponent(modifier = Modifier.weight(1f))
        CircleButtonComponent(
            onClick = { /*TODO*/ },
            icon = R.drawable.plus,
            size = 60.dp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EduNotifyTheme {
        HomeScreen(notifications)
    }
}