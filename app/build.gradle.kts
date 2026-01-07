plugins {
    alias(libs.plugins.catcompose.android.application)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.catcompose.hilt)
    alias(libs.plugins.catcompose.lint)
}

android {
    namespace = "com.example.catcompose"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.catcompose"

        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.splashscreen)

    implementation(libs.androidx.activity.compose)
    implementation(libs.bundles.navigation3)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)

    // modules dependencies
    implementation(projects.core.network)
    implementation(projects.core.designsystem)
    implementation(projects.core.navigation)
    implementation(projects.features.list)
    implementation(projects.features.details)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
