plugins {
    application
}

dependencies {
    compileOnly("com.beust:jcommander:1.48")
    implementation(project(":api"))
}

application {
    mainClass = "net.ellerton.japng.PngInfo"
}

