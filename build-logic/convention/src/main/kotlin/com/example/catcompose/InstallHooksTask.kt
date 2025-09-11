package com.example.catcompose

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jetbrains.kotlin.com.google.common.io.Resources
import java.io.File

abstract class InstallHooksTask : DefaultTask() {
    private val hooks = listOf("pre-commit")

    @TaskAction
    fun installHooks() {
        val hooksDir = project.rootDir.resolve(".git/hooks")
        if (!hooksDir.exists()) {
            hooksDir.mkdirs()
        }

        hooks.forEach { hook ->
            val hookFile = File(hooksDir, hook)
            hookFile.writeText(
                Resources.getResource("hooks/$hook").readText()
            )
            hookFile.setExecutable(true)
        }
    }
}