package com.example.artspaceapp.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ArtSpaceScreen() {

}

@Composable
fun ImageSection() {

}

@Composable
fun TileSection() {

}

@Composable
fun ButtonSection(
    modifier: Modifier,
    onCLickPreviousButton: () -> Unit,
    onClickNextButton: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            onClick = onCLickPreviousButton,
            modifier = Modifier
                .weight(1f)
            ) {
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = onClickNextButton,
            modifier = Modifier
                .weight(1f)
            ) {
            Text(text = "Next")
        }
    }
}

@Preview
@Composable
private fun ArtSpaceScreenPreview() {
    ButtonSection(
        modifier = Modifier,
        onCLickPreviousButton = { /*TODO*/ },
        onClickNextButton = {}
    )
}
