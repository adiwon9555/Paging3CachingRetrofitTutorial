package com.example.paging3cachingretrofittutorial.data.remote

data class BeerDto(
    val id: Int,
    val name : String,
    val tagline : String,
    val description : String,
    val first_brewed : String,
    val image_url: String?
)
