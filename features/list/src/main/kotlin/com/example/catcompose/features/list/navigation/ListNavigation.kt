package com.example.catcompose.features.list.navigation

import androidx.navigation3.runtime.NavKey
import com.example.catcompose.core.navigation.EntryProvider
import com.example.catcompose.features.list.ui.Cat
import com.example.catcompose.features.list.ui.ListScreen
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet
import kotlinx.serialization.Serializable

@Serializable
public data object ListRoute : NavKey

public fun interface OnCatClick {
    public fun click(cat: Cat)
}

@Module
@InstallIn(ActivityRetainedComponent::class)
internal object NavigationModule {
    @IntoSet
    @Provides
    fun provideListRouteEntry(onCatClick: OnCatClick): EntryProvider =
        {
            entry<ListRoute> {
                ListScreen(onCatClick)
            }
        }
}
