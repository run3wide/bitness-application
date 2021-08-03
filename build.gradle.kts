import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack

val ktorVersion = "1.6.1"
val serializationVersion = "1.2.2"
val xChangeVersion = "5.0.9"
val kotlinWrappersVersion = "0.0.1-pre.223-kotlin-1.5.21"

plugins {
    kotlin("multiplatform") version "1.5.21"
    id("org.springframework.boot") version "2.5.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.spring") version "1.5.21"
    kotlin("plugin.serialization") version "1.5.20"
    id("org.jetbrains.kotlin.plugin.noarg") version "1.5.21"
    application
}

group = "com.run3wide"
version = "0.0.1"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
    maven { url = uri("https://kotlin.bintray.com/kotlin-js-wrappers/") }
}

dependencies {
    implementation(project.dependencies.enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:2020.0.3"))
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
        withJava()
    }
    js(LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.springframework.boot:spring-boot-starter-web")
                implementation("org.springdoc:springdoc-openapi-ui:1.5.9")
                implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
                implementation("org.springframework.boot:spring-boot-starter-webflux")
                implementation("org.knowm.xchange:xchange-core:$xChangeVersion")
                implementation("org.knowm.xchange:xchange-gemini:$xChangeVersion")
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                implementation(project.dependencies.enforcedPlatform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:$kotlinWrappersVersion"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-styled")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")

                implementation("io.ktor:ktor-client-js:$ktorVersion")
                implementation("io.ktor:ktor-client-json-js:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization-js:$ktorVersion")
            }
        }
        val jsTest by getting
    }
}

application {
    mainClassName = "com.run3wide.bitness.BitnessApplicationKt"
}

noArg {
    annotation("com.run3wide.bitness.configuration.DefaultConstructor")
}

tasks.getByName<KotlinWebpack>("jsBrowserProductionWebpack") {
    outputFileName = "bitness.js"
}

tasks.getByName<Jar>("jvmJar") {
    dependsOn(tasks.getByName("jsBrowserProductionWebpack"))
    val jsBrowserProductionWebpack = tasks.getByName<KotlinWebpack>("jsBrowserProductionWebpack")
    from(File(jsBrowserProductionWebpack.destinationDirectory, jsBrowserProductionWebpack.outputFileName))
}

tasks.getByName<JavaExec>("run") {
    dependsOn(tasks.getByName<Jar>("jvmJar"))
    classpath(tasks.getByName<Jar>("jvmJar"))
}
