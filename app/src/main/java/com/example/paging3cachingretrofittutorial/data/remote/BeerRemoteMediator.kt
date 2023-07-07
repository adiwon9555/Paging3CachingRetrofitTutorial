package com.example.paging3cachingretrofittutorial.data.remote

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.paging3cachingretrofittutorial.data.local.BeerDatabase
import com.example.paging3cachingretrofittutorial.data.local.BeerEntity
import com.example.paging3cachingretrofittutorial.data.mappers.toBeerEntity
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException
import java.util.logging.Logger

@OptIn(ExperimentalPagingApi::class)
class BeerRemoteMediator(
    val beerDb : BeerDatabase,
    val beerApi: BeerApi
) : RemoteMediator<Int, BeerEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BeerEntity>
    ): MediatorResult {
        return try{
            val loadKey = when(loadType){
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if(lastItem == null){
                        1
                    }else{
//                        val currentTotalSize = state.pages
//                            .flatMap { it.data }
//                            .size
//                        Log.d("BeerRemoteMediator", "@aditya " +state.pages + currentTotalSize )
                        (lastItem.id / state.config.pageSize) + 1
                    }


                }
            }
            val beers = beerApi.getBeers(
                page = loadKey,
                pageCount = state.config.pageSize
            )
            delay(2000)
            beerDb.withTransaction{
                if(LoadType.REFRESH == loadType){
                    beerDb.dao.clearAll()
                }
                val beerEntities = beers.map{ it.toBeerEntity()}
                beerDb.dao.upsertAll(beerEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = beers.isEmpty()
            )
        }catch (e: IOException){
            MediatorResult.Error(e)
        }catch (e: HttpException){
            MediatorResult.Error(e)
        }

    }
}