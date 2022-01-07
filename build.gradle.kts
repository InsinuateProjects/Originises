plugins {
    kotlin("jvm") version "1.6.10"
    id("io.izzel.taboolib") version "1.34"
}

taboolib {
    install("common")
    install("common-5")
    install(
        "module-configuration",
        "module-chat",
        "module-lang",
        "module-kether",
        "module-effect",
        "module-database",
        "module-nms", // bukkit
        "module-nms-util",
        "module-ui",
        "module-ai",
        "module-porticus", // bungee
    )
    install("expansion-player-database", "expansion-command-helper")
    install(
        "platform-bukkit",
        "platform-bungee"
    )
    relocate(name.toLowerCase(), group.toString().toLowerCase())

    classifier = null
    version = "6.0.7-15"
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.tabooproject.org/repository/releases") }
}

dependencies {
    implementation(kotlin("stdlib"))
}