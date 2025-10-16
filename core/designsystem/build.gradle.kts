plugins {
    alias(libs.plugins.catcompose.android.library)
    alias(libs.plugins.catcompose.compose)
}

android {
    namespace = "com.example.catcompose.core.designsystem"
}

dependencies {
    implementation(libs.material)
    implementation(libs.androidx.splashscreen)
}