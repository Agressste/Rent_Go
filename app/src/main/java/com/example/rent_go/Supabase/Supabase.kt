package com.example.rent_go.Supabase

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage
import kotlin.time.Duration.Companion.seconds

val supabase: SupabaseClient = createSupabaseClient(
    supabaseUrl = "https://fgfkhjverpzyuxksdnhz.supabase.co",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZnZmtoanZlcnB6eXV4a3Nkbmh6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzY3NDc3MjYsImV4cCI6MjA1MjMyMzcyNn0.4w51t7YW_Xcw2v7qAhpH9h_td2uJnNdo7p5AuSf_f3g"
) {
    install(Postgrest)
    install(Storage) {
        transferTimeout = 30.seconds
    }
    install(Auth)
}