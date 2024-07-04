package com.nocountry.edunotify.ui.screens.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocountry.edunotify.R
import com.nocountry.edunotify.ui.components.ButtonComponent
import com.nocountry.edunotify.ui.components.TextFieldComponent
import com.nocountry.edunotify.ui.theme.EduNotifyTheme

@Composable
fun LoginScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier.size(180.dp)
                )
                Spacer(modifier = Modifier.height(50.dp))
                LoginFields()
                Spacer(modifier = Modifier.height(50.dp))
                ButtonComponent(text = R.string.login, onClick = { /*TODO*/ })
                Spacer(modifier = Modifier.height(50.dp))
                SocialMediaCards()
            }
        }
    }
}

@Composable
fun LoginFields() {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextFieldComponent(
        title = R.string.mail,
        value = username,
        onValueChange = { username = it },
        label = R.string.username_label,
        leadingIcon = Icons.Default.Email,
        trailingIcon = null,
        keyboardOptions = KeyboardOptions.Default,
        visualTransformation = VisualTransformation.None
    )
    Spacer(modifier = Modifier.height(20.dp))
    TextFieldComponent(
        title = R.string.password,
        value = password,
        onValueChange = { password = it },
        label = R.string.password_label,
        leadingIcon = Icons.Default.Password,
        trailingIcon = Icons.Default.RemoveRedEye,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )
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
        //SocialMediaCard(image = R.drawable.facebook_icon)
        LoginScreen()
    }
}