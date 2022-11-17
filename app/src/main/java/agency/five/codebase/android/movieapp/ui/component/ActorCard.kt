package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock.getActor
import agency.five.codebase.android.movieapp.ui.theme.spacing
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class ActorCardViewState(
    val imageUrl: String?,
    val name: String,
    val character: String,
)

@Composable
fun ActorCard(
    actorCardViewState: ActorCardViewState,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier
            .width(130.dp)
            .height(200.dp),
        shape = RoundedCornerShape(10.dp), elevation = 10.dp
    ) {
        Column {
            AsyncImage(
                model = actorCardViewState.imageUrl,
                contentDescription = null,
                modifier = Modifier.weight(0.6f),
                contentScale = ContentScale.Crop

            )
            Text(
                text = actorCardViewState.name,
                fontFamily = FontFamily.Cursive,
                fontSize = 16.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(
                        top = MaterialTheme.spacing.small,
                        bottom = MaterialTheme.spacing.extraSmall
                    )
                    .padding(horizontal = MaterialTheme.spacing.small),

                )
            Text(
                text = actorCardViewState.character,
                fontFamily = FontFamily.Monospace,
                fontSize = 5.sp, textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(start = MaterialTheme.spacing.small)
                    .alpha(ContentAlpha.disabled)
                    .width(100.dp)
            )
        }
    }
}

@Preview
@Composable
private fun ActorCardPreview() {
    val actor = getActor()
    ActorCard(
        actorCardViewState = ActorCardViewState(actor.imageUrl, actor.name, actor.character),
        modifier = Modifier
            .padding(10.dp)
            .size(
                width = 130.dp,
                height = 220.dp,
            )


    )
}
