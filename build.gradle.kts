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
    version = "6.0.7-19"
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.tabooproject.org/repository/releases") }
}

dependencies {
    val kotlinVersion = "1.6.10"
    implementation(kotlin("stdlib"))
    taboo("io.github:fast-classpath-scanner:3.1.13")
    implementation("org.jetbrains.kotlin:kotlin-main-kts:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-scripting-common:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-scripting-jvm:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-scripting-jvm-host:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    compileOnly("ink.ptms:nms-all:1.0.0")
    compileOnly("ink.ptms.core:v11800:11800:api")
    compileOnly("ink.ptms.core:v11800:11800:mapped")
    compileOnly("ink.ptms.core:v11800:11800:universal")
}