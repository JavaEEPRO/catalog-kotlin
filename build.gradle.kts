import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.1.BUILD-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	war
	kotlin("jvm") version "1.3.50"
	kotlin("plugin.spring") version "1.3.50"
	kotlin("plugin.jpa") version "1.3.50"
}

group = "si.inspirited"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly by configurations.creating
configurations {
	runtimeClasspath {
		extendsFrom(developmentOnly)
	}
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
	maven { url = uri("https://repo.fusesource.com/nexus/content/repositories/releases-3rd-party/") }
}

dependencies {

	implementation("org.springframework.boot.experimental:spring-boot-actuator-autoconfigure-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot.experimental:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-mail")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	implementation("javax.interceptor:javax.interceptor-api:1.2.2")

	implementation("javax.xml.bind:jaxb-api:2.2.11")
	implementation("javax.el:javax.el-api:3.0.1-b06")
	implementation("org.glassfish:javax.el:3.0.1-b11")
	implementation("org.javassist:javassist:3.26.0-GA")
	implementation("org.jboss.aerogear:aerogear-otp-java:1.0.0")
	implementation("org.passay:passay:1.0")
	implementation("com.google.guava:guava:28.1-jre")

	implementation("com.google.common:google-collect:1.0")

	implementation("com.github.ua-parser:uap-java:1.4.3")
	implementation("com.maxmind.geoip2:geoip2:2.12.0")
	implementation("io.rest-assured:rest-assured:4.1.2")

	implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:2.4.1")

	implementation("org.springframework.boot:spring-boot-starter-mustache")

	testImplementation(platform("org.springframework.boot:spring-boot-dependencies:2.1.9.RELEASE"))
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
	testImplementation("org.assertj:assertj-core:3.13.2")
	testImplementation("io.mockk:mockk:1.9")


	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("io.r2dbc:r2dbc-h2")
	runtimeOnly("io.r2dbc:r2dbc-postgresql")
	runtimeOnly("org.hsqldb:hsqldb")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("org.springframework.boot.experimental:spring-boot-test-autoconfigure-r2dbc")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.security:spring-security-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.boot.experimental:spring-boot-bom-r2dbc:0.1.0.BUILD-SNAPSHOT")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
