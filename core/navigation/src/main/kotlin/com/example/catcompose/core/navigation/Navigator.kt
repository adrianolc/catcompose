package com.example.catcompose.core.navigation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

public typealias EntryProvider = EntryProviderScope<NavKey>.() -> Unit

public class Navigator(
    startDestination: NavKey,
) {
    public val backStack: List<NavKey>
        field: SnapshotStateList<NavKey> = mutableStateListOf(startDestination)

    public fun navigate(destination: NavKey) {
        backStack.add(destination)
    }

    public fun pop() {
        backStack.removeLastOrNull()
    }
}
