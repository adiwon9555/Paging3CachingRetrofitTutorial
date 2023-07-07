package com.example.paging3cachingretrofittutorial.data.mappers

import com.example.paging3cachingretrofittutorial.data.local.BeerEntity
import com.example.paging3cachingretrofittutorial.data.remote.BeerDto
import com.example.paging3cachingretrofittutorial.domain.Beer

fun BeerDto.toBeerEntity() : BeerEntity{
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        first_brewed = first_brewed,
        image_url= image_url
    )
}

fun BeerEntity.toBeer() : Beer{
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        first_brewed = first_brewed,
        image_url= image_url
    )
}