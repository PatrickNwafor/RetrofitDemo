package com.example.retrofitdemo

import retrofit2.Response
import retrofit2.http.*

interface AlbumService {

    @GET("albums")
    suspend fun getAlbums() : Response<Albums>

    @GET("albums/{id}")
    suspend fun getSingleAlbums(@Path("id") albumId: Int) : Response<AlbumsItem>

    @GET("albums")
    suspend fun getSortedAlbums(@Query(USER_ID_KEY) userId: Int) : Response<Albums>

    @POST("albums")
    suspend fun uploadAlbum(@Body album: AlbumsItem): Response<AlbumsItem>
}