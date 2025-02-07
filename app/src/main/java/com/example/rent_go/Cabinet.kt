package com.example.rent_go

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun LichiyCabinet() {
    var isLoggedIn by remember { mutableStateOf(true) } // Состояние авторизации
    val userEmail = "user@example.com" // Пример почты
    val userPhone = "+7 123 456 78 90" // Пример телефона
    val userNickname = "Пользователь #12345" // Пример никнейма
    val userRating = "4.7 (123 отзыва)" // Пример рейтинга
    val userLocation = "Москва, Россия" // Пример геолокации

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        if (isLoggedIn) {
            // Личный кабинет для авторизованного пользователя
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Верхняя панель с кнопками "Назад" и "Изменить"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_media_previous),
                        contentDescription = "Назад",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { /* Действие при нажатии на "Назад" */ }
                    )
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_menu_edit),
                        contentDescription = "Изменить",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { /* Действие при нажатии на "Изменить" */ }
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Фото профиля
                Image(
                    painter = painterResource(id = R.drawable.my_image),
                    contentDescription = "Фото профиля",
                    modifier = Modifier
                        .size(130.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Никнейм
                Text(
                    text = userNickname,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Рейтинг и отзывы
                Text(
                    text = "★ $userRating",
                    fontSize = 16.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Личные данные
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "$userLocation",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    if (userEmail.isNotEmpty()) {
                        Text(
                            text = "$userEmail",
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    if (userPhone.isNotEmpty()) {
                        Text(
                            text = "$userPhone",
                            fontSize = 16.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                // Кнопка "Удалить профиль"
                Button(
                    onClick = { /* Действие при нажатии на "Удалить профиль" */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Удалить профиль", color = Color.White)
                }
            }
        } else {
            // Экран авторизации
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { isLoggedIn = true }, // Авторизация
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text(text = "Авторизоваться", color = Color.White)
                }
            }
        }
    }
}