plugins {
    alias(libs.plugins.catcompose.android.library)
}

android {
    namespace = "com.example.catcompose.core.test"
}

dependencies {
    implementation(libs.junit)
    implementation(libs.kotlinx.coroutines.test)
}