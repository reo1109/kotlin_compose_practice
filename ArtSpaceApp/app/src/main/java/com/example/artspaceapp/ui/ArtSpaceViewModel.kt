package com.example.artspaceapp.ui

import androidx.lifecycle.ViewModel
import com.example.artspaceapp.ui.imagelist.imageList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ArtSpaceViewModel: ViewModel() {
    private val _uiSate = MutableStateFlow(ArtSpaceUiState())
    val uiState: StateFlow<ArtSpaceUiState> = _uiSate.asStateFlow()

    private lateinit var currentImage: Image
    private var currentImageNum = 0

    init {
        currentImage()
        updatedCurrentImage()
    }

    private fun currentImage() {
        currentImage = imageList[currentImageNum]
    }

    private fun updatedCurrentImage() {
        _uiSate.update { currentState ->
            currentState.copy(
                currentImageId = currentImage.imageId,
                currentImageTitle = currentImage.title,
                currentImageArtist = currentImage.artist,
                currentImageYear = currentImage.year
            )
        }
    }

    fun onClickPreviousButton() {
        if (currentImageNum != 0) {
            currentImageNum--
        }
        currentImage()
        updatedCurrentImage()
        buttonEnabledSwitch()
    }

    fun onClickNextButton() {
        if (currentImageNum != imageList.size-1) {
            currentImageNum++
        }
        currentImage()
        updatedCurrentImage()
        buttonEnabledSwitch()
    }

    private fun buttonEnabledSwitch() {
        when (currentImageNum) {
            0 -> {
                _uiSate.update { currentState ->
                    currentState.copy(
                        onClickPreviousEnabled = false
                    )
                }
            }
            imageList.size-1 -> {
                _uiSate.update { currentState ->
                    currentState.copy(
                        onClickNextEnabled = false
                    )
                }
            }
            else -> {
                _uiSate.update { currentState ->
                    currentState.copy(
                        onClickPreviousEnabled = true,
                        onClickNextEnabled = true
                    )
                }
            }
        }
    }
}