package com.rowlandoti.lines

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test
import kotlin.test.assertNotNull

class CodeLineCounterPluginTest  {

    @Test
    fun greeterPluginAddsGreetingTaskToProject() {
        val project: Project = ProjectBuilder.builder().build()
        project.pluginManager.apply("com.rowlandoti.lines")
        assertNotNull(project.tasks.getByName("readCodeLines"))
    }
}