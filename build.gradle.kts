plugins {
    java
}

group = "net.ellerton.japng"
version = "0.6.0"

subprojects {
    apply {
        plugin("java")
    }

    group = rootProject.group
    version = rootProject.version

    repositories {
        mavenCentral()
    }

    java {
        withSourcesJar()
    }

    tasks.withType<JavaCompile>().configureEach {
        options.release = 17
    }
}


