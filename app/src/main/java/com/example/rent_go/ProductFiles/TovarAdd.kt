package com.example.rent_go.ProductFiles

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rent_go.Navigation
import com.example.rent_go.Supabase.supabase
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.storage.storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TovarAdd(navController: NavHostController, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {
        val name = remember { mutableStateOf("") }
        val price = remember { mutableStateOf("") }
        val description = remember { mutableStateOf("") }
        var imageUri by remember { mutableStateOf<Uri?>(null) }

        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            imageUri = uri
        }

        OutlinedButton(
            onClick = { launcher.launch("image/*") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(300.dp)
                .background(Color.LightGray),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(text = if (imageUri == null) "Нажмите, чтобы выбрать картинку" else "Картинка выбрана")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            text = "Информация о товаре",
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Start,
            fontSize = 16.sp
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 8.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Название товара") },
                textStyle = TextStyle(fontSize = 18.sp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffeeeeee),
                    unfocusedTextColor = Color(0xff888888),
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color(0xff222222),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = price.value,
                onValueChange = { price.value = it },
                label = { Text("Цена товара") },
                textStyle = TextStyle(fontSize = 14.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffeeeeee),
                    unfocusedTextColor = Color(0xff888888),
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color(0xff222222),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                value = description.value,
                onValueChange = { description.value = it },
                label = { Text("Описание товара") },
                textStyle = TextStyle(fontSize = 14.sp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffeeeeee),
                    unfocusedTextColor = Color(0xff888888),
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color(0xff222222),
                )
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        val composableScope = rememberCoroutineScope()
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onClick = {
                composableScope.launch(Dispatchers.IO) {
                    val priceValue = price.value.toDoubleOrNull()
                    if (priceValue == null) {
                        println("Цена должна быть числом")
                        return@launch
                    }

                    imageUri?.let { uri ->
                        val contentResolver = context.contentResolver
                        val inputStream = contentResolver.openInputStream(uri)
                        val byteArray = inputStream?.readBytes()
                        val fileName = "images/${System.currentTimeMillis()}.jpg"
                        val storage = supabase.storage.from("images")
                        val result = byteArray?.let { storage.upload(fileName, it) }
                        val imageUrl = storage.publicUrl(fileName)

                        try {
                            val tovar = Tovar(
                                id = 0, // ID будет автоматически сгенерирован в Supabase
                                name = name.value,
                                price = priceValue,
                                description = description.value,
                                image_url = imageUrl
                            )
                            supabase.from("Tovar").insert(tovar)
                            println("Товар добавлен")

                            // Переход на следующую страницу после успешного добавления
                            withContext(Dispatchers.Main) {
                                navController.navigate("home") // Переход на главный экран
                            }
                        } catch (e: Exception) {
                            println("Ошибка при добавлении: ${e.message}")
                        }
                    }
                }
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Blue
            )
        ) {
            Text(text = "Сохранить", fontWeight = FontWeight.Bold)
        }
    }
}

data class Tovar(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val image_url: String?
)