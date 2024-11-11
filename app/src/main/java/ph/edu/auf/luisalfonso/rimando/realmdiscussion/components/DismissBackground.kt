package ph.edu.auf.luisalfonso.rimando.realmdiscussion.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissBackground(dismissState : SwipeToDismissBoxState) {
    val color = when(dismissState.dismissDirection){
        SwipeToDismissBoxValue.StartToEnd -> Color.Red
        SwipeToDismissBoxValue.EndToStart -> Color.Cyan
        SwipeToDismissBoxValue.Settled -> Color.Transparent
    }

    Row (
        modifier = Modifier.fillMaxSize()
            .background(color)
            .padding(12.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Icon(
            Icons.Default.Delete,
            contentDescription = "Delete",
        )
        Spacer(modifier = Modifier)
        Icon(
            Icons.Default.AddCircle,
            contentDescription = "Archive",
        )
    }
}