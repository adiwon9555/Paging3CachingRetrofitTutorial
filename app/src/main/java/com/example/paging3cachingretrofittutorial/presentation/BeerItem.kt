package com.example.paging3cachingretrofittutorial.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.paging3cachingretrofittutorial.Greeting
import com.example.paging3cachingretrofittutorial.domain.Beer
import com.example.paging3cachingretrofittutorial.ui.theme.Paging3CachingRetrofitTutorialTheme

@Composable
fun BeerItem(
    beer: Beer,
    modifier: Modifier = Modifier
){
    Text(text = "Hello")
}

@Preview
@Composable
fun previewBeerItem(){
    Paging3CachingRetrofitTutorialTheme {
        val beer = Beer(
            id = 1,
            name = "My Beer",
            description = "This is a very tasty beer",
            first_brewed = "7/July/2023",
            tagline = "Dil Mange More",
            image_url = null
        )
        BeerItem(beer)
    }
}