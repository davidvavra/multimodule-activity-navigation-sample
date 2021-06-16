package me.vavra.multimoduleactivitynavigationsample.feature3

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import dagger.hilt.android.AndroidEntryPoint
import me.vavra.multimoduleactivitynavigationsample.common.BaseActivity
import me.vavra.multimoduleactivitynavigationsample.common.ui.theme.MultimoduleActivityNavigationSampleTheme

@AndroidEntryPoint
class Feature3Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultimoduleActivityNavigationSampleTheme {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("Feature 3") }) },
                    content = {}
                )
            }
        }
    }
}