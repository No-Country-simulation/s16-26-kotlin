package com.nocountry.edunotify.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocountry.edunotify.R
import com.nocountry.edunotify.ui.components.BackButtonComponent
import com.nocountry.edunotify.ui.components.ButtonComponent
import com.nocountry.edunotify.ui.components.SpacerComponent
import com.nocountry.edunotify.ui.components.TextFieldComponent
import com.nocountry.edunotify.ui.components.TextFieldEmpty
import com.nocountry.edunotify.ui.components.TopAppBarComponent
import com.nocountry.edunotify.ui.theme.EduNotifyTheme

@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = R.string.profile_top_bar,
                navigationIcon = { BackButtonComponent(onClickBack = {}) },
                actions = null
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ProfileFields()
        }
    }
}

@Composable
fun ProfileFields() {
    var name by rememberSaveable { mutableStateOf("Nikoll Daiana") }
    var lastName by rememberSaveable { mutableStateOf("Quintero Chavez") }
    var phone by rememberSaveable { mutableStateOf("+57 3057678939") }

    var isNameEmpty by rememberSaveable { mutableStateOf(false) }
    var isLastNameEmpty by rememberSaveable { mutableStateOf(false) }
    var isPhoneEmpty by rememberSaveable { mutableStateOf(false) }

    var isNameEditable by rememberSaveable { mutableStateOf(false) }
    var isLastNameEditable by rememberSaveable { mutableStateOf(false) }
    var isPhoneEditable by rememberSaveable { mutableStateOf(false) }

    TextFieldComponent(
        title = R.string.name,
        value = name,
        onValueChange = {
            if (isNameEditable) {
                name = it
            }
            isNameEmpty = name.isEmpty()
        },
        label = R.string.name_label,
        leadingIcon = null,
        trailingIcon = { },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        visualTransformation = VisualTransformation.None,
        supportingText = {
            if (isNameEmpty) {
                TextFieldEmpty()
            }
        },
        isError = isNameEmpty
    )
    SpacerComponent(height = 5.dp)
    TextFieldComponent(
        title = R.string.last_name,
        value = lastName,
        onValueChange = {
            if (isLastNameEditable) {
                lastName = it
            }
            isLastNameEmpty = lastName.isEmpty()
        },
        label = R.string.last_name_label,
        leadingIcon = null,
        trailingIcon = { },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        visualTransformation = VisualTransformation.None,
        supportingText = {
            if (isLastNameEmpty) {
                TextFieldEmpty()
            }
        },
        isError = isLastNameEmpty
    )
    SpacerComponent(height = 5.dp)
    TextFieldComponent(
        title = R.string.phone,
        value = phone,
        onValueChange = {
            if (isPhoneEditable) {
                phone = it
            }
            isPhoneEmpty = phone.isEmpty()
        },
        label = R.string.phone_label,
        leadingIcon = null,
        trailingIcon = { },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        visualTransformation = VisualTransformation.None,
        supportingText = {
            if (isPhoneEmpty) {
                TextFieldEmpty()
            }
        },
        isError = isPhoneEmpty
    )
    SpacerComponent(height = 50.dp)
    ButtonComponent(
        text = R.string.profile_edit_button,
        onClick = {
            isNameEditable = true
            isLastNameEditable = true
            isPhoneEditable = true
        }
    )
    SpacerComponent(height = 20.dp)
    ButtonComponent(text = R.string.profile_save_button,
        onClick = {
            if (name.isNotEmpty() && lastName.isNotEmpty()
                && phone.isNotEmpty()
            ) {
                isNameEditable = false
                isLastNameEditable = false
                isPhoneEditable = false
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    EduNotifyTheme {
        ProfileScreen()
    }
}