package com.nocountry.edunotify.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nocountry.edunotify.ui.theme.EduNotifyTheme

@Composable
fun ProfileScreen() {
    Scaffold {
        Surface(modifier = Modifier.padding(it)) {
            Column {

            }
        }
    }
}

@Composable
fun ProfileFields() {
    var name by rememberSaveable { mutableStateOf("Nikoll Daiana") }
    var lastName by rememberSaveable { mutableStateOf("Quintero Chavez") }
    var phone by rememberSaveable { mutableStateOf("+57 3057678939") }



}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    EduNotifyTheme {
        ProfileScreen()
    }
}