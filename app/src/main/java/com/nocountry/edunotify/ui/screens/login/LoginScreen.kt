package com.nocountry.edunotify.ui.screens.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nocountry.edunotify.R
import com.nocountry.edunotify.ui.components.ButtonComponent
import com.nocountry.edunotify.ui.components.SpacerComponent
import com.nocountry.edunotify.ui.components.TextFieldComponent
import com.nocountry.edunotify.ui.components.TextFieldEmpty
import com.nocountry.edunotify.ui.theme.EduNotifyTheme

@Composable
fun LoginScreen() {
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
                LoginFields()
            }
        }
    }
}

@Composable
fun LoginFields() {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    var isEmailEmpty by rememberSaveable { mutableStateOf(false) }
    var isPasswordEmpty by rememberSaveable { mutableStateOf(false) }

    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "logo",
        modifier = Modifier.size(180.dp)
    )
    SpacerComponent(height = 50.dp)
    TextFieldComponent(
        title = R.string.mail,
        value = email,
        onValueChange = { email = it },
        label = R.string.mail_label,
        leadingIcon = Icons.Default.Email,
        trailingIcon = { },
        keyboardOptions = KeyboardOptions.Default,
        visualTransformation = VisualTransformation.None,
        supportingText = {
            if (isEmailEmpty) {
                TextFieldEmpty()
            }
        },
        isError = isEmailEmpty
    )
    SpacerComponent(height = 5.dp)
    TextFieldComponent(
        title = R.string.password,
        value = password,
        onValueChange = { password = it },
        label = R.string.password_label,
        leadingIcon = Icons.Default.Password,
        trailingIcon = {
            if (password.isNotEmpty()) {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    if (passwordVisible) {
                        Icon(
                            imageVector = Icons.Default.VisibilityOff, contentDescription = null
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Visibility, contentDescription = null
                        )
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
    SpacerComponent(height = 30.dp)
    ButtonComponent(
        text = R.string.login,
        onClick = {
            if (email.isNotEmpty() && password.isNotEmpty()) {
                isEmailEmpty = false
                isPasswordEmpty = false

                //Access via ViewModel
            } else {
                isEmailEmpty = email.isEmpty()
                isPasswordEmpty = password.isEmpty()
            }
        }
    )
    SpacerComponent(height = 20.dp)
    Text(
        text = stringResource(id = R.string.no_account),
        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.clickable { }
    )
    SpacerComponent(height = 50.dp)
    SocialMediaCards()
}

@Composable
fun SocialMediaCards() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(380.dp)
            .height(80.dp)
            .padding(bottom = 32.dp)
    ) {
        SocialMediaCard(image = R.drawable.facebook_icon)
        SocialMediaCard(image = R.drawable.google_icon)
        SocialMediaCard(image = R.drawable.apple_icon)
    }
}

@Composable
fun SocialMediaCard(image: Int) {
    Card(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFCCCCCC),
                shape = RoundedCornerShape(size = 8.dp)
            )
            .width(116.dp)
            .height(48.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    EduNotifyTheme {
        LoginScreen()
    }
}