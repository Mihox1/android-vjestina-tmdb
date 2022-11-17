package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier ,
    contentDescription: String = "Favorite button"
) {
    Image(
        painter = painterResource(id = if (isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_outlined),
        contentDescription = contentDescription,
        modifier = modifier
            .size(dimensionResource(id = R.dimen.favorite_button_size))
            .clickable { onClick() }
    )
}


@Preview
@Composable
private fun FavoriteButtonPreview() {
    FavoriteButton(isFavorite = true, onClick = {}, modifier = Modifier)
}
