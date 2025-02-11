package com.example.rent_go

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rent_go.ProductFiles.ListProduct
import com.example.rent_go.ProductFiles.Poisk
import com.example.rent_go.ProductFiles.PostBox
import com.example.rent_go.ProductFiles.ProductList
import com.example.rent_go.Supabase.supabase
import com.example.rent_go.ui.theme.Rent_GoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Rent_GoTheme {
                val navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
}

@Composable
fun Enter(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(224, 255, 255))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Добро пожаловать в RentGo!", textAlign = TextAlign.Center, fontSize = 28.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(80.dp))

        Button(
            onClick = { navController.navigate("register") },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(130.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Blue
            )
        ) {
            Text(
                text = "Зарегистрироваться"
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(130.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.White
            )
        ) {
            Text(
                text = "Войти"
            )
        }
    }
}