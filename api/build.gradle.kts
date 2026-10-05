plugins {
    `java-library`
    `maven-publish`
}

base.archivesName = rootProject.name

dependencies {
    testImplementation("junit:junit:4.13")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:6.1.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.1.3")
}

tasks {
    test {
        useJUnitPlatform()
    }
}

publishing {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()
                from(components["java"])
            }
        }
    }

    repositories {
        maven {
            name = "vanutp"
            url = uri("https://maven.vanutp.dev/main")
            credentials {
                username = System.getenv("REGISTRY_USERNAME")
                password = System.getenv("REGISTRY_TOKEN")
            }
        }
    }
}
