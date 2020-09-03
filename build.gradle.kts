import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile

buildscript {
  repositories {
    mavenCentral()
  }
  dependencies {
    classpath(kotlin("gradle-plugin", Versions.kotlin))
  }
}

plugins {
  `dependencies-check`
}

allprojects {
  group = "io.kotest.assertions"
  version = "4.2.6"

  repositories {
    mavenCentral()
  }

  tasks {
    withType<KotlinJvmCompile> {
      kotlinOptions.jvmTarget = "1.8"
    }
    withType<Test>().all {
      useJUnitPlatform()
      filter {
        isFailOnNoMatchingTests = true
      }
    }
    withType<AbstractTestTask>().all {
      testLogging {
        showExceptions = true
        events = setOf(
          TestLogEvent.STARTED,
          TestLogEvent.SKIPPED,
          TestLogEvent.FAILED,
          TestLogEvent.PASSED,
          TestLogEvent.STANDARD_OUT,
          TestLogEvent.STANDARD_ERROR
        )
        exceptionFormat = TestExceptionFormat.FULL
      }
    }
  }
}

tasks.wrapper {
  gradleVersion = "6.6.1"
  distributionType = Wrapper.DistributionType.ALL
}
