package com.nocountry.edunotify.ui.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocountry.edunotify.R
import com.nocountry.edunotify.ui.components.ButtonComponent
import com.nocountry.edunotify.ui.components.SpacerComponent
import com.nocountry.edunotify.ui.components.TextFieldComponent
import com.nocountry.edunotify.ui.components.TextFieldEmpty
import com.nocountry.edunotify.ui.theme.EduNotifyTheme

@Composable
fun RegisterScreen() {
    Scaffold {
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RegisterFields()
            }
        }
    }
}

@Composable
fun RegisterFields() {
    var name by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var mail by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var isNameEmpty by rememberSaveable { mutableStateOf(false) }
    var isLastNameEmpty by rememberSaveable { mutableStateOf(false) }
    var isMailEmpty by rememberSaveable { mutableStateOf(false) }
    var isPhoneEmpty by rememberSaveable { mutableStateOf(false) }
    var isPasswordEmpty by rememberSaveable { mutableStateOf(false) }

    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "logo",
        modifier = Modifier.size(180.dp)
    )
    SpacerComponent(height = 5.dp)
    TextFieldComponent(
        title = R.string.name,
        value = name,
        onValueChange = { name = it },
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
        onValueChange = { lastName = it },
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
        title = R.string.mail,
        value = mail,
        onValueChange = { mail = it },
        label = R.string.mail_label,
        leadingIcon = Icons.Default.Email,
        trailingIcon = { },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        visualTransformation = VisualTransformation.None,
        supportingText = {
            if (isMailEmpty) {
                TextFieldEmpty()
            }
        },
        isError = isMailEmpty
    )
    SpacerComponent(height = 5.dp)
    TextFieldComponent(
        title = R.string.phone,
        value = phone,
        onValueChange = { phone = it },
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
    SpacerComponent(height = 5.dp)
    TextFieldComponent(
        title = R.string.password,
        value = password,
        onValueChange = { password = it },
        label = R.string.password_label,
        leadingIcon = null,
        trailingIcon = {
            if (password.isNotEmpty()) {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    if (passwordVisible) {
                        Icon(imageVector = Icons.Default.VisibilityOff, contentDescription = null)
                    } else {
                        Icon(imageVector = Icons.Default.Visibility, contentDescription = null)
                    }
                }
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation =
        if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        supportingText = {
            if (isPasswordEmpty) {
                TextFieldEmpty()
            }
        },
        isError = isPasswordEmpty
    )
    SpacerComponent(height = 15.dp)
    ButtonComponent(
        text = R.string.register,
        onClick = {
            if (name.isNotBlank() && lastName.isNotBlank()
                && mail.isNotBlank() && phone.isNotBlank()
                && password.isNotBlank()
            ) {

            }
        }
    )
}

@Preview
@Composable
fun RegisterScreenPreview() {
    EduNotifyTheme {
        RegisterScreen()
    }
}