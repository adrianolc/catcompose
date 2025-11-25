package com.example.catcompose.features.details.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation3.runtime.NavKey
import com.example.catcompose.core.navigation.EntryProvider
import com.example.catcompose.core.navigation.Navigator
import com.example.catcompose.features.details.ui.DetailScreen
import com.example.catcompose.features.details.ui.DetailsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet
import kotlinx.serialization.Serializable

@Serializable
public data class DetailsNavKey(
    val catId: String,
    val imageUrl: String,
    val catName: String,
) : NavKey

@Module
@InstallIn(ActivityRetainedComponent::class)
internal object NavigationModule {
    @IntoSet
    @Provides
    fun provideDetailsRouteEntry(navigator: Navigator): EntryProvider =
        {
            entry<DetailsNavKey> { key ->
                val detailsViewModel: DetailsViewModel =
                    hiltViewModel<DetailsViewModel, DetailsViewModel.Factory>(
                        creationCallback = { factory ->
                            factory.create(key)
                        },
                    )

                DetailScreen(
                    onBackClick = { navigator.pop() },
                    viewModel = detailsViewModel,
                )
            }
        }
}
