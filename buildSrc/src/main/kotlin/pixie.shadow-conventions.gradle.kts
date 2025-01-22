import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.gradleup.shadow")
}

val shadowJar = tasks.getByName<ShadowJar>("shadowJar") {
    archiveClassifier.set("")
    configurations = listOf(project.configurations.getByName("shadow"))
    relocate("net.bytebuddy.agent", "rip.pixie.shadow.net.bytebuddy.agent")
    relocate("org.objectweb.asm", "rip.pixie.shadow.org.objectweb.asm")
    // TODO: only include META-INF/mods.toml
    //exclude("META-INF/**")
//    exclude("META-INF/MANIFEST.MF")
}

tasks.getByName("assemble") {
    dependsOn(shadowJar)
}
