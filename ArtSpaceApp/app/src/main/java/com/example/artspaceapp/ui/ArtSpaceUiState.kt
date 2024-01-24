package com.example.artspaceapp.ui

data class ArtSpaceUiState(
    val currentImageId: Int = 0,
    val currentImageTitle: String = "",
    val currentImageArtist: String = "",
    val currentImageYear: String = "",
    val onClickPreviousEnabled: Boolean = false,
    val onClickNextEnabled: Boolean = true,
)

data class Image(
    val imageId: Int,
    val title: String,
    val artist: String,
    val year: String,
)