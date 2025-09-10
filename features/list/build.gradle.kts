plugins {
    alias(libs.plugins.catcompose.feature)
    alias(libs.plugins.catcompose.compose)
}

android {
    namespace = "com.example.catcompose.features.list"
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.bundles.coil)
    implementation(libs.shimmer)

    implementation(projects.core.network)
}
