plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly("org.projectlombok:lombok:1.18.30")

    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
    implementation("com.fasterxml.jackson.core:jackson-core:2.16.0-rc1")

    // https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-json-org
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-json-org:2.16.0-rc1")


}

tasks.test {
    useJUnitPlatform()
}