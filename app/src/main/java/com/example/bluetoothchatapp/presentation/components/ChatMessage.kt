package com.example.bluetoothchatapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bluetoothchatapp.domain.chat.BluetoothMessage
import com.example.bluetoothchatapp.ui.theme.BluetoothChatAppTheme
import com.example.bluetoothchatapp.ui.theme.Pink80
import com.example.bluetoothchatapp.ui.theme.Purple40

@Composable
fun ChatMessage(
    message: BluetoothMessage,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    topStart = if (message.isFromLocalUser) 15.dp else 0.dp,
                    topEnd = 15.dp,
                    bottomStart = 15.dp,
                    bottomEnd = if (message.isFromLocalUser) 0.dp else 15.dp
                )
            )
            .background(
                if (message.isFromLocalUser) Purple40 else Pink80
            )
            .padding(16.dp)
    ) {
        Text(
            text = message.senderName,
            fontSize = 10.sp,
            color = Color.Black
        )
        Text(
            text = message.message,
            fontSize = 10.sp,
            color = Color.Black,
            modifier = Modifier.widthIn(max = 250.dp)
        )
    }

}

@Preview
@Composable
fun chatMessagePreview() {
    BluetoothChatAppTheme {
        ChatMessage(message = BluetoothMessage(
            message = "Hello World!",
            senderName = "Pixel 6",
            isFromLocalUser = true
        ))
    }
}