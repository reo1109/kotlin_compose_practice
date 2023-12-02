package com.example.artspaceapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.R

@Composable
fun ArtSpaceScreen() {

}

@Composable
fun ImageSection() {

}

@Composable
fun TitleSection(
    titleText: String,
    artistName: String,
    year: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(
                color = Color.Gray
            ),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = titleText,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )
        Row {
            Text(
                text = artistName,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp, start = 16.dp)
            )
            Text(text = "（$year）")
        }
    }
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
            Text(text = stringResource(R.string.label_previous))
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = onClickNextButton,
            modifier = Modifier
                .weight(1f)
        ) {
            Text(text = stringResource(R.string.label_next))
        }
    }
}

@Preview
@Composable
private fun ArtSpaceScreenPreview() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        TitleSection(
            titleText = "ArtWorkTitle",
            artistName = "ArtistName",
            year = "year",
            modifier = Modifier
                .padding(vertical = 24.dp, horizontal = 16.dp)
                .fillMaxWidth()
        )
        ButtonSection(
            modifier = Modifier,
            onCLickPreviousButton = {},
            onClickNextButton = {}
        )
    }
}
