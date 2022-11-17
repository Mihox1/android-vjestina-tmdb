import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.ui.component.FavoriteButton
import agency.five.codebase.android.movieapp.ui.theme.spacing
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

data class MovieCardViewState(
    val imageUrl: String?,
    val title: String,
    val isFavorite: Boolean
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieCard(
    movieCardViewState: MovieCardViewState,

    onCardClick: () -> Unit,

    onLikeButtonClick: () -> Unit,

    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .clickable { onCardClick() },
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius)),
        elevation = dimensionResource(id = R.dimen.elevation)
    )
    {
        Box {
            AsyncImage(
                model = movieCardViewState.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            FavoriteButton(
                isFavorite = movieCardViewState.isFavorite,
                modifier = Modifier
                    .padding(
                        start = MaterialTheme.spacing.small,
                        top = MaterialTheme.spacing.small
                    ),
                onClick = { onLikeButtonClick() },

                )

        }
    }
}


@Preview
@Composable
private fun MovieCardPreview() {
    val movie = MoviesMock.getMoviesList()[4]
    val movieCardViewState =
        MovieCardViewState(imageUrl = movie.imageUrl, title = movie.title, movie.isFavorite)
    MovieCard(
        movieCardViewState = movieCardViewState,
        modifier = Modifier
            .width(125.dp)
            .height(205.dp)
            .padding(10.dp),
        onCardClick = {},
        onLikeButtonClick = { }
    )
}
