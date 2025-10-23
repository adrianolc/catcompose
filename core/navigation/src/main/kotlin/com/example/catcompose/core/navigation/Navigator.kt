package com.example.catcompose.core.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack

public typealias EntryProvider = EntryProviderScope<NavKey>.() -> Unit

public class Navigator(
    startDestination: NavKey,
) {
    private val _backStack = rememberNavBackStack(startDestination)
    public val backStack: List<NavKey> = _backStack

    public fun navigate(destination: NavKey) {
        _backStack.add(destination)
    }

    public fun pop() {
        _backStack.removeLastOrNull()
    }
}
