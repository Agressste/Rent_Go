package com.example.rent_go

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import java.net.URI

// Модель данных для продукта
data class Product(
    val id: Int,
    val product_name: String,
    val product_price: String,
    val product_info: String,
    val image_url: String
)

suspend fun getProductById(supabase: SupabaseClient, productId: Int): Product? {
    return try {
        supabase.from("your_table_name")
            .select()
            .eq("id", productId)
            .single()
            .decodeAs<Product>()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}