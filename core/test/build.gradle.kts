plugins {
    alias(libs.plugins.catcompose.android.library)
}

android {
    namespace = "com.example.catcompose.core.test"
}

dependencies {
    api(libs.junit)
    api(libs.kotlinx.coroutines.test)
    api(libs.turbine.test)
    api(libs.kotest)
    api(libs.mockk)
}