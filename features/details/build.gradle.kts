plugins {
    alias(libs.plugins.catcompose.feature)
    alias(libs.plugins.catcompose.compose)
}

android {
    namespace = "com.example.catcompose.features.details"
}

dependencies {
    implementation(libs.coil.compose)
    implementation(libs.coil.network)

    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)

    implementation(projects.core.network)
}