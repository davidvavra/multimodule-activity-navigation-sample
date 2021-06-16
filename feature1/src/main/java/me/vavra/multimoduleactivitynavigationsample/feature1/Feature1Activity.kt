package me.vavra.multimoduleactivitynavigationsample.feature1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.vavra.multimoduleactivitynavigationsample.common.ui.theme.MultimoduleActivityNavigationSampleTheme

class Feature1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultimoduleActivityNavigationSampleTheme {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("Feature 1") }) },
                    content = {
                        Content()
                    }
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Content() {
        var argument by remember { mutableStateOf("") }
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            TextField(
                value = argument,
                onValueChange = { argument = it },
                label = { Text("Argument") },
            )
            Button(
                onClick = {},
                content = { Text("Navigate to Feature 2") },
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}