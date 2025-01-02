package com.pradiph31.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pradiph31.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        fullName = stringResource(R.string.fullName),
                        title = stringResource(R.string.title),
                        phone = stringResource(R.string.phone),
                        email = stringResource(R.string.email),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    modifier: Modifier = Modifier,
    title: String = "",
    phone: String = "",
    email: String = "",
    fullName: String = ""
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFA1E8A0)),
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {}
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(3f)
        ) {
            MainDetails(
                fullName = fullName,
                title = title
            )
            ContactDetails(
                phone = phone,
                email = email
            )
        }
    }
}

@Composable
private fun ContactDetails(phone: String, email: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp),
    ) {
        SpacedInfo(
            textValue = phone,
            icon = Icons.Outlined.Call,
            description = "An image of a phone"
        )
        SpacedInfo(
            textValue = email,
            icon = Icons.Outlined.Email,
            description = "An image of email"
        )
    }
}

@Composable
private fun SpacedInfo(
    textValue: String,
    icon: ImageVector,
    description: String
) {
    Row(
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        Spacer(
            modifier = Modifier.width(80.dp)
        )
        Image(
            imageVector = icon,
            contentDescription = description
        )
        Text(
            modifier = Modifier.padding(start = 30.dp),
            fontSize = 15.sp,
            text = textValue
        )
    }
}

@Composable
private fun MainDetails(fullName: String, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(R.drawable.baseline_memory_24),
            modifier = Modifier
                .size(150.dp)
                .padding(8.dp),
            contentDescription = "An image of a processor"
        )
        Text(
            text = fullName,
            fontSize = 40.sp,
            modifier = Modifier.padding(top = 2.dp),
            fontWeight = FontWeight.Thin
        )
        Text(
            modifier = Modifier.padding(10.dp),
            fontSize = 20.sp,
            color = Color(0xFF1A591B),
            fontWeight = FontWeight.Bold,
            text = title
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun BusinessCardPreview() {
    HappyBirthdayTheme {
        BusinessCard(fullName = "Android")
    }
}