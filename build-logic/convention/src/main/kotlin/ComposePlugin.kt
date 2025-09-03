import com.example.catcompose.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class ComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "org.jetbrains.kotlin.plugin.compose")

            dependencies {
                val bom = libs.findLibrary("androidx-compose-bom").get()
                "implementation"(platform(bom))

                "implementation"(libs.findLibrary("androidx-compose-ui").get())
                "implementation"(libs.findLibrary("androidx-compose-material3").get())
                "implementation"(libs.findLibrary("androidx-compose-foundation").get())
                "implementation"(libs.findLibrary("androidx-lifecycle-runtimeCompose").get())
                "implementation"(libs.findLibrary("androidx-hilt-navigation-compose").get())
                "implementation"(libs.findLibrary("androidx-navigation-compose").get())
            }
        }
    }
}
