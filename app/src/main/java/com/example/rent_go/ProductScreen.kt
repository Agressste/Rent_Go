package com.example.rent_go

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import coil3.compose.rememberAsyncImagePainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

/*
@Composable
fun ProductDetailPage(
    productName: String,
    productPrice: String,
    productDescription: String,
    sellerName: String,
    sellerImageUrl: String,
    productImages: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Слайдер для картинок товара
        ImageSlider(images = productImages)

        Spacer(modifier = Modifier.height(16.dp))

        // Название товара
        Text(
            text = productName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Цена товара
        Text(
            text = productPrice,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Полное описание товара
        Text(
            text = productDescription,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Пользователь, который выставил товар на продажу
        SellerInfo(sellerName = sellerName, sellerImageUrl = sellerImageUrl)

        Spacer(modifier = Modifier.height(24.dp))

        // Кнопки "Написать" и "Позвонить"
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Действие при нажатии на кнопку "Написать" */ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Написать")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { /* Действие при нажатии на кнопку "Позвонить" */ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Позвонить")
            }
        }
    }
}

@Composable
fun ImageSlider(images: List<String>) {
    // Здесь можно реализовать слайдер для картинок
    // В данном примере просто отображается первая картинка
    if (images.isNotEmpty()) {
        Image(
            painter = rememberAsyncImagePainter(model = images[0]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun SellerInfo(sellerName: String, sellerImageUrl: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = sellerImageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = "Продавец",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            Text(
                text = sellerName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductDetailPage() {
    MaterialTheme {
        ProductDetailPage(
            productName = "Велосипед сука",
            productPrice = "250 ₽/час",
            productDescription = "Это самый ахуенный велосипед который вы только блять могли видеть! Сквозь грязь и лужу, доставит вам большую грушу! Через дебри и песок, вы получите посашок",
            sellerName = "Иван Иванов",
            sellerImageUrl = "https://media.istockphoto.com/id/1298261537/ru/%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%BD%D0%B0%D1%8F/%D0%BF%D1%83%D1%81%D1%82%D0%BE%D0%B9-%D1%87%D0%B5%D0%BB%D0%BE%D0%B2%D0%B5%D0%BA-%D0%BF%D1%80%D0%BE%D1%84%D0%B8%D0%BB%D1%8C-%D0%B3%D0%BB%D0%B0%D0%B2%D0%B0-%D0%B7%D0%BD%D0%B0%D1%87%D0%BE%D0%BA-%D0%B7%D0%B0%D0%BF%D0%BE%D0%BB%D0%BD%D0%B8%D1%82%D0%B5%D0%BB%D1%8C.webp?s=2048x2048&w=is&k=20&c=AcpdpuUQmZtBZKBEoqIVtDcbkWLfpzKyJLecykUwsx4=",
            productImages = listOf(
                "https://media.istockphoto.com/id/1147544807/ru/%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%BD%D0%B0%D1%8F/%D0%BD%D0%B5%D1%82-thumbnail-%D0%B8%D0%B7%D0%BE%D0%B1%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80-%D0%B3%D1%80%D0%B0%D1%84%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9.jpg?s=612x612&w=0&k=20&c=qA0VzNlwzqnnha_m2cHIws9MJ6vRGsZmys335A0GJW4=",
                "https://media.istockphoto.com/id/1147544807/ru/%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%BD%D0%B0%D1%8F/%D0%BD%D0%B5%D1%82-thumbnail-%D0%B8%D0%B7%D0%BE%D0%B1%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80-%D0%B3%D1%80%D0%B0%D1%84%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9.jpg?s=612x612&w=0&k=20&c=qA0VzNlwzqnnha_m2cHIws9MJ6vRGsZmys335A0GJW4="
            )
        )
    }
}
 */

@Composable
fun ProductDetailPage(
    productName: String,
    productPrice: String,
    productDescription: String,
    sellerName: String,
    sellerImageResId: Int,
    productImageResIds: List<Int>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            ImageSlider(images = productImageResIds)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = productName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = productPrice,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = productDescription,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            Spacer(modifier = Modifier.height(24.dp))
            SellerInfo(sellerName = sellerName, sellerImageResId = sellerImageResId)
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Действие при нажатии на кнопку "Написать" */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Написать")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* Действие при нажатии на кнопку "Позвонить" */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Позвонить")
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSlider(images: List<Int>) {
    val pagerState = rememberPagerState()

    if (images.isNotEmpty()) {
        Column {
            HorizontalPager(
                count = images.size,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) { page ->
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp),
                activeColor = MaterialTheme.colorScheme.primary,
                inactiveColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
            )
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Gray)
        )
    }
}

@Composable
fun SellerInfo(sellerName: String, sellerImageResId: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Аватар продавца
        if (sellerImageResId != 0) {
            Image(
                painter = painterResource(id = sellerImageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        } else {
            // Если аватар отсутствует, показываем цветной блок
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = "Продавец",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            Text(
                text = sellerName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductDetailPage() {
    MaterialTheme {
        ProductDetailPage(
            productName = "ЧТО ЭТО",
            productPrice = "999 000 ₽",
            productDescription = "Что-то тут было. оршуцацуоащцуоащцуоащцшуаощцуа",
            sellerName = "Иван Иванов",
            sellerImageResId = R.drawable.my_image, // Замените на ваш ресурс
            productImageResIds = listOf(
                R.drawable.b, // Замените на ваш ресурс
                R.drawable.a  // Замените на ваш ресурс
            )
        )
    }
}