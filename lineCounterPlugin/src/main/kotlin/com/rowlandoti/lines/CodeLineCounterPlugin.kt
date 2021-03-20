package com.rowlandoti.lines

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginConvention

class CodeLineCounterPlugin : Plugin<Project> {

    companion object {
        const val LOG_TAG = "CodeLineCounter"
    }

    override fun apply(project: Project) {
        val extension = project.extensions.create("logtag", LogTagPluginExtension::class.java)

        project.tasks.create("readCodeLines") { task ->
            task.doLast {
                printCodeLinesCount(extension.tag, project)
            }
        }.apply {
            group = "stat"
        }
    }

    private fun printCodeLinesCount(logTag: String, project: Project) {
        var totalCount = 0
        project.convention.getPlugin(JavaPluginConvention::class.java).sourceSets.forEach { sourceSet ->
            sourceSet.allSource.forEach { file ->
                totalCount += file.readLines().count()
            }
        }
        println("$logTag: $totalCount total lines of code found in project")
    }
}