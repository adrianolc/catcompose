import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.example.catcompose.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("hilt") {
            id = libs.plugins.catcompose.hilt.get().pluginId
            implementationClass = "HiltPlugin"
        }
        register("compose") {
            id = libs.plugins.catcompose.compose.get().pluginId
            implementationClass = "ComposePlugin"
        }
        register("android-library") {
            id = libs.plugins.catcompose.android.library.get().pluginId
            implementationClass = "AndroidLibraryPlugin"
        }
        register("feature") {
            id = libs.plugins.catcompose.feature.get().pluginId
            implementationClass = "FeaturePlugin"
        }
        register("lint") {
            id = libs.plugins.catcompose.lint.get().pluginId
            implementationClass = "LintPlugin"
        }
    }
}
