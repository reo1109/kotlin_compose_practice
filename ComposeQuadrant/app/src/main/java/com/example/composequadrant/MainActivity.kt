package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrant()
                }
            }
        }
    }
}



@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier) {
    val greenTitle = stringResource(R.string.green_title)
    val greenText = stringResource(R.string.green_text)
    val yellowTitle = stringResource(R.string.yellow_title)
    val yellowText = stringResource(R.string.yellow_text)
    val cyanTitle = stringResource(R.string.cyan_title)
    val cyanText = stringResource(R.string.cyan_text)
    val grayTitle = stringResource(R.string.gray_title)
    val grayText = stringResource(R.string.gray_text)

    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            Quadrant(title = greenTitle, text = greenText, color = Color.Green, modifier = Modifier.weight(1f))
            Quadrant(title = yellowTitle, text = yellowText, color = Color.Yellow, modifier = Modifier.weight(1f))
        }

        Row(Modifier.weight(1f)) {
            Quadrant(title = cyanTitle, text = cyanText, color = Color.Cyan, modifier = Modifier.weight(1f))
            Quadrant(title = grayTitle, text = grayText, color = Color.LightGray, modifier = Modifier.weight(1f))
        }

    }

}

@Composable
fun Quadrant (
    title: String,
    text: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp))
    {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify
        )

    }
}



@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}