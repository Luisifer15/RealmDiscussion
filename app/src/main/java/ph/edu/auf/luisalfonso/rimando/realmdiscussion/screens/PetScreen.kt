package ph.edu.auf.luisalfonso.rimando.realmdiscussion.screens

import android.content.ClipData.Item
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ph.edu.auf.luisalfonso.rimando.realmdiscussion.components.ItemPet
import ph.edu.auf.luisalfonso.rimando.realmdiscussion.viewmodels.PetViewModel


@Composable
fun PetScreen(petViewModel: PetViewModel = viewModel()){
    val pets by petViewModel.pets.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        Scaffold { paddingValues ->
            LazyColumn(
                modifier = Modifier.padding(paddingValues)
            ) {
                itemsIndexed(
                    items = pets,
                    key = {_,item -> item.id}
                ){_, petContent ->
                    ItemPet(petContent, onRemove = { petViewModel::deletePet })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetScreenPreview(){
    PetScreen()
}