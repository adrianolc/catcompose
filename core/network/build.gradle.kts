plugins {
    alias(libs.plugins.catcompose.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.catcompose.hilt)
}

android {
    namespace = "com.example.catcompose.core.network"

    defaultConfig {
        buildConfigField("String", "API_KEY", "\"live_LULEx6XMwa5EZvrwoS1dfa7mhyxQV2f9dEMwZqmjWM6PUDbC58nEyJ0WTNq1ge8d\"")
        buildConfigField("String", "BASE_URL", "\"https://api.thecatapi.com\"")
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
}
