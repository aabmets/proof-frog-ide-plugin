import org.jetbrains.intellij.platform.gradle.TestFrameworkType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.1.20"
    id("org.jetbrains.intellij.platform") version "2.5.0"
}

group = "io.github.aabmets"
version = "1.0.0"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        clion("2025.1")
        testFramework(TestFrameworkType.Platform)
    }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "251"
        }
    }
    pluginVerification  {
        ides {
            recommended()
        }
    }
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions.jvmTarget.set(JvmTarget.JVM_21)
    }

    signPlugin {
        certificateChainFile.set(file("$rootDir/.exclude/chain.crt"))
        privateKeyFile.set(file("$rootDir/.exclude/private.pem"))
        password.set(providers.environmentVariable("PRIVATE_KEY_PASSWORD"))
    }

    verifyPluginSignature {
        certificateChainFile.set(file("$rootDir/.exclude/chain.crt"))
    }

    publishPlugin {
        token.set(providers.environmentVariable("PUBLISH_TOKEN"))
    }
}

sourceSets {
    main {
        java {
            srcDirs("src/main/gen")
        }
    }
}