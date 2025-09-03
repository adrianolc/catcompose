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
    }
}
