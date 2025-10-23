plugins {
    alias(libs.plugins.catcompose.android.library)
    alias(libs.plugins.catcompose.hilt)
}

android {
    namespace = "com.example.catcompose.core.navigation"
}

dependencies {
    implementation(libs.nav3.runtime)
}
