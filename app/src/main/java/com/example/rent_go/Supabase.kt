package com.example.rent_go

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage
import kotlin.time.Duration.Companion.seconds

val supabase: SupabaseClient = createSupabaseClient(
    supabaseUrl = "https://arxemonvbwvslwxwggxv.supabase.co",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFyeGVtb252Ynd2c2x3eHdnZ3h2Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzc1MzQ5OTcsImV4cCI6MjA1MzExMDk5N30.8WKDqTnDkfuMtxTvSkd6I3QKwHTN3pdzrsimw3pG41Y"
) {
    install(Auth)
    install(Postgrest)
    install(Storage) {
        transferTimeout = 90.seconds
    }
}