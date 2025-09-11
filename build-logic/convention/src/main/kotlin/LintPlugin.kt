import com.example.catcompose.InstallHooksTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class LintPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.register("installHooks", InstallHooksTask::class.java)
    }
}