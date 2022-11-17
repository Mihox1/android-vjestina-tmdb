package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock.getCrewman
import agency.five.codebase.android.movieapp.ui.theme.spacing
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

data class CrewItemViewState(
    val name: String,
    val job: String,
)

@Composable
fun CrewItem(
    crewItemViewState: CrewItemViewState,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = crewItemViewState.name,
            fontFamily = FontFamily.Cursive,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.extraSmall)
        )
        Text(
            text = crewItemViewState.job,
            fontFamily = FontFamily.Monospace,
            fontSize = 8.sp, textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(
                    top = MaterialTheme.spacing.small,
                    bottom = MaterialTheme.spacing.extraSmall
                )
                .padding(horizontal = MaterialTheme.spacing.small)
        )
    }
}

@Preview
@Composable
private fun CrewItemPreview() {
    val crewman = getCrewman()
    CrewItem(crewItemViewState = CrewItemViewState(crewman.name, crewman.job))
}
