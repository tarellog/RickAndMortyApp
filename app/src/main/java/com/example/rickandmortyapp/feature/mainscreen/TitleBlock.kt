package com.example.rickandmortyapp.feature.mainscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rickandmortyapp.navigation.Screens

@Composable
fun Title(
    navController: NavController
) {
    Column(
        modifier = Modifier.clickable { navController.navigate(Screens.Character.route) }
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            Text(text = "Все персонажи")
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    val context = LocalContext.current
    Title(navController = NavController(context))
}