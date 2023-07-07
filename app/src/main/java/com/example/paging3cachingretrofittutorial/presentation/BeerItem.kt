package com.example.paging3cachingretrofittutorial.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.paging3cachingretrofittutorial.domain.Beer
import com.example.paging3cachingretrofittutorial.ui.theme.Paging3CachingRetrofitTutorialTheme

@Composable
fun BeerItem(
    beer: Beer,
    modifier: Modifier = Modifier
){
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Max)
        .padding(16.dp)
    ) {
        AsyncImage(
            model = beer.image_url,
            contentDescription = beer.name,
            modifier = Modifier
                .weight(1f)
                .height(150.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(3f),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = beer.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = beer.tagline,
                color = Color.LightGray,
                modifier = Modifier
                    .fillMaxWidth(),
                fontStyle = FontStyle.Italic,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = beer.description,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = beer.first_brewed,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.End,
                fontSize = 8.sp
            )
        }
    }
}

@Preview
@Composable
fun previewBeerItem(){
    Paging3CachingRetrofitTutorialTheme {
        val beer = Beer(
            id = 1,
            name = "My Beer",
            description = "This is a very tasty beer I like it so much I cant even describe",
            first_brewed = "7/July/2023",
            tagline = "Dil Mange More",
            image_url = null
        )
        BeerItem(beer)
    }
}