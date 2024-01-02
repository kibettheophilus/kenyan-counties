plugins {
    id("java")
    id ("org.springframework.boot") version "3.2.1"
    id ("io.spring.dependency-management") version "1.1.4"
}

group = "com.theophiluskibet"
version = "0.0.1-SNAPSHOT"
//
//java {
//    sourceCompatibility = "17"
//}

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-web")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}
