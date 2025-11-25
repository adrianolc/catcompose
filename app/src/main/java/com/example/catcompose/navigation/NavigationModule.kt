package com.example.catcompose.navigation

import com.example.catcompose.core.navigation.Navigator
import com.example.catcompose.features.details.navigation.DetailsNavKey
import com.example.catcompose.features.list.navigation.ListRoute
import com.example.catcompose.features.list.navigation.OnCatClick
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
internal object NavigationModule {
    @Provides
    @ActivityRetainedScoped
    fun provideNavigator(): Navigator = Navigator(startDestination = ListRoute)

    @Provides
    @ActivityRetainedScoped
    fun provideOnCatClick(navigator: Navigator): OnCatClick =
        OnCatClick {
            navigator.navigate(
                destination =
                    DetailsNavKey(
                        catId = it.id,
                        imageUrl = it.imageUrl,
                        catName = it.name,
                    ),
            )
        }
}
