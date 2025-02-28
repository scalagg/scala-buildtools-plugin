import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    `maven-publish`
    kotlin("jvm") version "1.9.20"
    kotlin("kapt") version "1.9.20"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("org.ajoberstar.grgit") version "4.1.1"
}

var currentBranch: String = grgit.branch.current().name

allprojects {
    group = "gg.scala.buildtools"
    version = "0.0.6${
        if (currentBranch == "develop") "-dev" else ""
    }"

    repositories {
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://papermc.io/repo/repository/maven-public/")
        maven("https://repo.glaremasters.me/repository/concuncan/")
        maven("https://repo.dmulloy2.net/repository/public/")
        configureScalaRepository()
    }
}

dependencies {
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("lib"))

    kapt("gg.scala.commons:bukkit:4.0.1")
    compileOnly("gg.scala.commons:bukkit:4.0.1")

    compileOnly("gg.scala.store:spigot:0.1.8")
    compileOnly("gg.scala.spigot:server:1.1.0")

    compileOnly("com.grinderwolf:slimeworldmanager-plugin:2.2.1")
    compileOnly("gg.scala.cloudsync:spigot:1.0.1")
}

kotlin {
    jvmToolchain(jdkVersion = 17)
}

tasks.withType<ShadowJar> {
    archiveClassifier.set("")
    exclude(
        "**/*.kotlin_metadata",
        "**/*.kotlin_builtins",
        "META-INF/"
    )

    archiveFileName.set(
        "ScBuildTools.jar"
    )
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
    options.fork()
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.javaParameters = true
    kotlinOptions.jvmTarget = "17"
}

publishing {
    repositories.configureScalaRepository(
        dev = false
    )

    publications {
        register(
            name = "mavenJava",
            type = MavenPublication::class,
            configurationAction = shadow::component
        )
    }
}

tasks.getByName("build")
    .dependsOn(
        "shadowJar",
        "publishMavenJavaPublicationToScalaRepository"
    )

fun RepositoryHandler.configureScalaRepository(dev: Boolean = false)
{
    maven("${property("artifactory_contextUrl")}/gradle-${if (dev) "dev" else "release"}") {
        name = "scala"
        credentials {
            username = property("artifactory_user").toString()
            password = property("artifactory_password").toString()
        }
    }
}