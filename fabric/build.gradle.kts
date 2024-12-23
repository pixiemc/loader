plugins {
    id("pixie.java-conventions")
    id("pixie.shadow-conventions")
}

val fabricLoaderVersion = project.property("fabric_loader_version")

dependencies {
    shadow(project(":common")) {
        exclude(group = "org.ow2.asm")
    }
    implementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
}

tasks.processResources {
    inputs.property("version", project.version)
    inputs.property("loader_version", fabricLoaderVersion)
    filteringCharset = "UTF-8"

    filesMatching("fabric.mod.json") {
        expand("version" to project.version,
            "loader_version" to fabricLoaderVersion
        )
    }
}
