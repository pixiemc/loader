plugins {
    id("pixie.java-conventions")
    id("pixie.shadow-conventions")
}

dependencies {
    shadow(project(":common"))
    implementation(project(":forge-hacks"))
    implementation("net.minecraft:launchwrapper:1.12")

    compileOnly("cpw.mods:modlauncher:8.1.3")
    compileOnly("net.sf.jopt-simple:jopt-simple:5.0.4")
    compileOnly("org.jetbrains:annotations:21.0.1")
}

tasks.processResources {
    inputs.property("version", project.version)
    filteringCharset = "UTF-8"

    filesMatching("mcmod.info") {
        expand("version" to project.version)
    }
}

//tasks.shadowJar {
//    manifest {
//        attributes(mapOf(
//            "TweakClass" to "rip.pixie.forge.EssentialTweaker",
//            "TweakOrder" to "0"
//        ))
//    }
//}