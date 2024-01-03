plugins {
    id("java")
    id ("org.springframework.boot") version "3.2.1"
    id ("io.spring.dependency-management") version "1.1.4"
    id("com.netflix.dgs.codegen") version "6.1.0"
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

dependencyManagement {
    imports {
        mavenBom("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:8.0.0")
    }
}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation(platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:8.0.0"))
    implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:3.0.0")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}

tasks.generateJava {
    packageName = "com.theophiluskibet.graphql" // The package name to use to generate sources
    generateClient = true // Enable generating the type safe query API
}
