package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.ui.theme.spacing
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val DEGREES_IN_CIRCLE = 360f
private const val PERCENTAGE_FACTOR = 10f
private const val STARTING_ANGLE = -90f
private const val SCORE_FORMAT = "%.1f"

@Composable
fun UserScoreProgressBar(
    score: Float,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Canvas(
            modifier = Modifier
                .padding(MaterialTheme.spacing.extraSmall)
                .fillMaxSize()
        ) {
            drawArc(
                color = Color(R.color.teal_700),
                startAngle = STARTING_ANGLE,
                sweepAngle = DEGREES_IN_CIRCLE,
                useCenter = false,
                style = Stroke(5.dp.toPx(), cap = StrokeCap.Round)
            )
            drawArc(
                color = Color(R.color.black),
                startAngle = STARTING_ANGLE,
                sweepAngle = DEGREES_IN_CIRCLE * score,
                useCenter = false, style = Stroke(5.dp.toPx(), cap = StrokeCap.Round)
            )
        }

        Text(text = SCORE_FORMAT.format(score * PERCENTAGE_FACTOR).toString())
    }
}

@Preview(showBackground = true)
@Composable
fun UserScoreProgressBarPreview() {
    UserScoreProgressBar(modifier = Modifier.size(50.dp), score = 0.9f)
}
