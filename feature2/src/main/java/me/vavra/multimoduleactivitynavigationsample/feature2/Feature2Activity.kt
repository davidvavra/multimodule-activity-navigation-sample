package me.vavra.multimoduleactivitynavigationsample.feature2

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
import me.vavra.multimoduleactivitynavigationsample.common.ui.theme.Typography

class Feature2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultimoduleActivityNavigationSampleTheme {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("Feature 2") }) },
                    content = {
                        Content("")
                    }
                )
            }
        }
    }

    @Composable
    fun Content(argument: String) {
        var result by remember { mutableStateOf("") }
        Column {
            Text(
                "Argument from Feature 1:",
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
            Text(
                argument,
                style = Typography.body2,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            Divider(modifier = Modifier.padding(top = 16.dp))
            TextField(
                value = result,
                onValueChange = { result = it },
                label = { Text("Result") },
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
            Button(
                onClick = {},
                content = { Text("Return result to Feature 1") },
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ContentWithArgument() {
        Content("Value")
    }
}