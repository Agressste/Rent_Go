package com.example.rent_go

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

val supabase = createSupabaseClient(
    supabaseUrl = "https://arxemonvbwvslwxwggxv.supabase.co",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFyeGVtb252Ynd2c2x3eHdnZ3h2Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzc1MzQ5OTcsImV4cCI6MjA1MzExMDk5N30.8WKDqTnDkfuMtxTvSkd6I3QKwHTN3pdzrsimw3pG41Y"
) {
    install(Postgrest)
}