plugins {
    kotlin("jvm") version "1.7.20"
    id("com.diffplug.spotless") version ("6.11.0")
    id("com.github.johnrengelman.shadow") version ("7.1.1")
    id("net.minecrell.plugin-yml.bukkit") version "0.2.1"
}

group = "com.github.onlyafter"
version = "1.0-SNAPSHOT"

allprojects {

    apply(plugin = "kotlin")
    apply(plugin = "com.diffplug.spotless")
    apply(plugin = "com.github.johnrengelman.shadow")
    apply(plugin = "net.minecrell.plugin-yml.bukkit")

    repositories {
        mavenCentral()
        mavenLocal()

        maven(url = "https://jitpack.io")
        maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven(url = "https://papermc.io/repo/repository/maven-public/")
    }

    dependencies {
        implementation("com.warrenstrange:googleauth:1.5.0")
        implementation(kotlin("stdlib", version = "1.7.20"))
    }

    tasks {
        compileKotlin {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

}