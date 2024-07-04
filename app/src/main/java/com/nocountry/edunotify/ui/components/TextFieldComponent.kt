package com.nocountry.edunotify.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocountry.edunotify.R
import com.nocountry.edunotify.ui.theme.EduNotifyTheme

@Composable
fun TextFieldComponent(
    title: Int,
    value: String,
    onValueChange: (String) -> Unit,
    label: Int,
    leadingIcon: ImageVector?,
    trailingIcon: ImageVector?,
    keyboardOptions: KeyboardOptions,
    visualTransformation: VisualTransformation
) {
    Column {
        Text(text = stringResource(id = title), style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            modifier = Modifier.width(380.dp),
            value = value,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = stringResource(label),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF7C7986)
                )
            },
            leadingIcon = {
                if (leadingIcon != null) {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            trailingIcon = {
                if (trailingIcon != null) {
                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview() {
    EduNotifyTheme {
        TextFieldComponent(
            title = R.string.mail,
            value = "",
            onValueChange = { /*TODO*/ },
            label = R.string.username_label,
            leadingIcon = Icons.Default.Email,
            trailingIcon = null,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            visualTransformation = VisualTransformation.None
        )
    }
}