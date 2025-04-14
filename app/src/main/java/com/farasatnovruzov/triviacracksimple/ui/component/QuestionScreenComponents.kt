package com.farasatnovruzov.triviacracksimple.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScoreBar(
    correctAnswerCount: Int,
    wrongAnswerCount: Int,
) {
    val correctScore = remember(correctAnswerCount) { correctAnswerCount }
    val wrongScore = remember(wrongAnswerCount) { wrongAnswerCount }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(
                width = 2.dp,
//                color = Color.Transparent,
                color = Color.Yellow, shape = RoundedCornerShape(34.dp)
            )
            .clip(RoundedCornerShape(50.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f)
                    .background(Color.Green)
                    .padding(10.dp), contentAlignment = Alignment.CenterEnd

            ) {
                Text(
                    "$correctScore", style = TextStyle(
                        fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black
                    )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f)
                    .background(Color.Red)
                    .padding(10.dp),
                contentAlignment = Alignment.CenterStart

            ) {
                Text(
                    "$correctScore", style = TextStyle(
                        fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black
                    )
                )
            }

        }
    }
}


@Composable
fun QuestionTrackerBar(
    counter: Int, outOf: Int
) {
    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(textIndent = TextIndent.None)) {
            withStyle(
                style = SpanStyle(
//                        color = Color.Black,
                    fontWeight = FontWeight.Bold, fontSize = 30.sp
                )
            ) {
                append("Question ${counter + 1} /")
                withStyle(
                    style = SpanStyle(
//                            color = Color.Black,
                        fontWeight = FontWeight.Light, fontSize = 17.sp
                    )
                ) {
                    append("$outOf")
                }
            }
        }

    })

}

@Composable
fun DrawDottedLine() {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(5.dp)
            .padding(vertical = 5.dp)
    ) {
        drawLine(
            color = Color.White,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect,
            strokeWidth = 10f
        )
    }

}


@Preview(showBackground = true)
@Composable
private fun Preview() {
//    ScoreBar(correctAnswerCount = 10, wrongAnswerCount = 20)
//    QuestionTrackerBar(counter = 10, outOf = 20)
    DrawDottedLine()
}