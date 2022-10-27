package agency.five.codebase.android.movieapp.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class MovieCategoryLabelViewState(
    val itemId: Int,
    val isSelected: Boolean,
    val categoryText: MovieCategoryLabelTextViewState
)
sealed class MovieCategoryLabelTextViewState{
    class InputText(val text: String): MovieCategoryLabelTextViewState()
    class SendRef(@StringRes val textRes: Int):MovieCategoryLabelTextViewState()

}
/* Nije riješen zadatak */