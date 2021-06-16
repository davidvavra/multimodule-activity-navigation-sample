package me.vavra.multimoduleactivitynavigationsample.feature1

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import me.vavra.multimoduleactivitynavigationsample.common.BaseActivity
import me.vavra.multimoduleactivitynavigationsample.common.ui.theme.MultimoduleActivityNavigationSampleTheme
import me.vavra.multimoduleactivitynavigationsample.common.ui.theme.Typography
import me.vavra.multimoduleactivitynavigationsample.navigation.contracts.Feature2Contract

@AndroidEntryPoint
class Feature1Activity : BaseActivity() {

    private lateinit var feature2ContractLauncher: ActivityResultLauncher<Feature2Contract.Args>
    private val uiState = MutableStateFlow<String?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultimoduleActivityNavigationSampleTheme {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("Feature 1") }) },
                    content = {
                        Content(uiState.collectAsState().value)
                    }
                )
            }
        }
        feature2ContractLauncher = registerForActivityResult(contracts.feature2Contract) {
            if (it != null) {
                uiState.value = it.result1
            }
        }
    }

    @Composable
    fun Content(result: String?) {
        var argument by remember { mutableStateOf("") }
        Column {
            TextField(
                value = argument,
                onValueChange = { argument = it },
                label = { Text("Argument") },
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
            Button(
                onClick = {
                    feature2ContractLauncher.launch(Feature2Contract.Args(argument))
                },
                content = { Text("Navigate to Feature 2") },
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
            if (result != null) {
                Divider(modifier = Modifier.padding(top = 16.dp))
                Text(
                    "Result from Feature 2:",
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )
                Text(
                    result,
                    style = Typography.body2,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            Divider(modifier = Modifier.padding(top = 16.dp))
            Button(
                onClick = {
                    contracts.feature3Contract.launch()
                },
                content = { Text("Navigate to Feature 3") },
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ContentNoResult() {
        Content(null)
    }

    @Preview(showBackground = true)
    @Composable
    fun ContentWithResult() {
        Content("Value")
    }
}