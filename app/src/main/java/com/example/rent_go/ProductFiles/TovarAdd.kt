package com.example.rent_go.ProductFiles

import android.content.Context
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import coil3.Uri
import com.google.android.gms.analytics.ecommerce.Product

//      Н Е    Р А Б О Т А Е Т

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTovar(context: Context) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFCDDA9),
                    titleContentColor = Color(0xFF49361A),
                ),
                title = {
                    Text(text = "Добавление нового товара",
                        fontWeight = FontWeight.SemiBold
                    )
                }
            )
        },

        ) { innerPadding ->
        val products = remember { mutableStateListOf<Tovar>() }
        var newName by remember { mutableStateOf("") }
        var newDesc by remember { mutableStateOf("") }
        var newManuf by remember { mutableStateOf("") }
        var newPrice by remember { mutableStateOf("") }
        var newImage by remember { mutableStateOf<Uri?>(null) }
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent(),
        ) { uri: Uri? ->
            uri?.let

            {
                newImage = uri
            }

        }
        LaunchedEffect(Unit) {
            withContext(Dispatchers.IO) {
                val results = supabase.from("Products").select().decodeList<Product>()
                products.addAll(results)
            }
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            OutlinedTextField(value = newName, onValueChange = {newName = it},
                modifier = Modifier
                    .padding(6.dp)
                    .height(60.dp))
            OutlinedTextField(value = newDesc, onValueChange = {newDesc = it},
                modifier = Modifier
                    .padding(6.dp)
                    .height(60.dp))
            OutlinedTextField(value = newManuf, onValueChange = {newManuf = it},
                modifier = Modifier
                    .padding(6.dp)
                    .height(60.dp))
            OutlinedTextField(value = newPrice, onValueChange = {newPrice = it},
                modifier = Modifier
                    .padding(6.dp)
                    .height(60.dp))
            Spacer(modifier = Modifier.height(20.dp))
            Button(shape = RoundedCornerShape(15),
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp),
                onClick = {
                    launcher.launch("image/*")
                }) {
                Text("Выбрать картинку")
            }
            Spacer(modifier = Modifier.height(20.dp))
            val context = LocalContext.current
            val composableScope = rememberCoroutineScope()

            Button(shape = RoundedCornerShape(15),
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp),
                onClick = {
                    composableScope.launch(Dispatchers.IO) {
                        newImage?.let { uri ->
                            val contentResolver = context.contentResolver
                            val inputStream = contentResolver.openInputStream(uri)
                            val byteArray = inputStream?.readBytes()
                            val fileName = "images/${System.currentTimeMillis()}.jpg"
                            val storage = supabase.storage.from("images")
                            val result = byteArray?.let { storage.upload(fileName, it) }
                            val imageUrl = storage.publicUrl(fileName)

                            try {
                                val product = Product(
                                    name = newName,
                                    description = newDesc,
                                    manufacturer = newManuf,
                                    price = newPrice.toDouble(),
                                    image = imageUrl
                                )
                                supabase.from("Products").insert(product)
                                println("товар добавлен")
                                val addIntent = Intent(context, )
                                context.startActivity(addIntent)
                            } catch (e: Exception) {
                                println("ошибка при добавлении: ${e.message}")
                            }
                        }
                    }
                }) {
                Text("Сохранить")
            }
            Button(onClick = {
                val addIntent = Intent(context, MenuActivity::class.java)
                context.startActivity(addIntent)
            }) {
                Text("Назад")
            }
        }
    }
}

 */