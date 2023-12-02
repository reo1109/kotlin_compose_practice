package com.example.artspaceapp.ui

import com.example.artspaceapp.R

data class ArtSpaceUiState(
    val imageList: List<Image> = listOf(
        Image(R.drawable.hugaku, "富嶽三十六景/神奈川沖浪裏", "葛飾北斎", "1830~1834"),
        Image(R.drawable.sakebi, "The Scream", "Edvard Munch", "1910"),
        Image(R.drawable.choushoku, "Breakfast", "Maurice Denis", "1901"),
        Image(R.drawable.huji, "忍野の富士", "川瀬巴水", "1942")
    ),
)

data class Image(
    val imageId: Int,
    val title: String,
    val artist: String,
    val year: String,
)