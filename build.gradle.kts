plugins {
    id("java")
}

group = "dev.illusion"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val manifoldVersion = "2026.1.6"

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    //Manifold
    implementation("systems.manifold:manifold-rt:$manifoldVersion")
    implementation("systems.manifold:manifold-ext-rt:$manifoldVersion")
    annotationProcessor("systems.manifold:manifold-ext:$manifoldVersion")
    annotationProcessor("systems.manifold:manifold:$manifoldVersion")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.addAll(listOf(
        "-Xplugin:Manifold",
        "-implicit:none",
        "-XprintProcessorInfo",
        "-XprintRounds",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
        "--add-exports", "java.base/jdk.internal.access=ALL-UNNAMED"
    ))

    options.forkOptions.jvmArgs = listOf(
        "-Xmx4g",
        "-XX:MaxMetaspaceSize=512m",
        "-XX:+UseParallelGC"
    )

    options.isVerbose = true // enable this when debugging smth

    options.isIncremental = false
    options.incrementalAfterFailure = false

    options.isFork = true
}


tasks.test {
    useJUnitPlatform()
}