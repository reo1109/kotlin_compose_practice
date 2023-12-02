package com.example.artspaceapp.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
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
fun ArtSpaceContent(
    @DrawableRes imageId: Int,
    titleText: String,
    artistName: String,
    year: String,
    onCLickPreviousButton: () -> Unit,
    onClickNextButton: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.padding(top = 60.dp))
        ImageSection(
            imageId = imageId
        )
        TitleSection(
            titleText = titleText,
            artistName = artistName,
            year = year,
            modifier = Modifier
                .padding(vertical = 24.dp, horizontal = 16.dp)
                .fillMaxWidth()
        )
        ButtonSection(
            onCLickPreviousButton = onCLickPreviousButton,
            onClickNextButton = onClickNextButton,
        )
    }
}

@Composable
fun ImageSection(
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier
            .background(
                color = Color.Black
            )
            .shadow(5.dp)
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "",
            modifier = Modifier
                .padding(32.dp)
        )
    }
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
                color = Color.LightGray
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
    onCLickPreviousButton: () -> Unit,
    onClickNextButton: () -> Unit,
    modifier: Modifier = Modifier,
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
    ArtSpaceContent(
        imageId = R.drawable.hugaku,
        titleText = "ArtWorkTitle",
        artistName = "ArtistName",
        year = "year",
        onCLickPreviousButton = {},
        onClickNextButton = {},
    )
}
