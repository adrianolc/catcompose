package com.example.catcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.catcompose.core.designsystem.CatTheme
import com.example.catcompose.core.navigation.Navigator
import com.example.catcompose.navigation.CatNavDisplay
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle =
                SystemBarStyle.dark(
                    Color.Transparent.toArgb(),
                ),
        )

        setContent {
            CatTheme {
                CatNavDisplay(
                    modifier =
                        Modifier.semantics {
                            testTagsAsResourceId = true
                        },
                    navigator = navigator,
                )
            }
        }
    }
}
