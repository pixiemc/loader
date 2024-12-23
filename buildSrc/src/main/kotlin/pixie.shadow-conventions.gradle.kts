import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.gradleup.shadow")
}

val shadowJar = tasks.getByName<ShadowJar>("shadowJar") {
    archiveClassifier.set("")
    configurations = listOf(project.configurations.getByName("shadow"))
    relocate("net.bytebuddy.agent", "rip.pixie.shadow.net.bytebuddy.agent")
    exclude("META-INF/**")
}

tasks.getByName("assemble") {
    dependsOn(shadowJar)
}
