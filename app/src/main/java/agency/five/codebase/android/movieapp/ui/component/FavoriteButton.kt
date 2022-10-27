package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.runtime.*


@Composable
fun FavoriteButton(modifier: Modifier = Modifier){
    var isFavorite by remember{ mutableStateOf(false) }
    Image(
        painter = painterResource(id = if (isFavorite) R.drawable.vectorselected else R.drawable.vector),
        contentDescription = null,
        modifier = Modifier
            .clickable {
                isFavorite = !isFavorite
            }
    )
}

@Preview
@Composable
private fun FavoriteButtonPreview() {
    FavoriteButton()
}