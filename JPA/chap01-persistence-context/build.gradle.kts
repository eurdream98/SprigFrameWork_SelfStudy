plugins {
    id("java")
}

group = "com.ohgiraffers"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation 'org.hibernate:hibernate-entitymanager:5.6.15.Final';
    implementation 'com.mysql:mysql-connector-j:8.0.33';

}

tasks.test {
    useJUnitPlatform()
}