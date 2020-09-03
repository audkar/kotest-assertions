plugins {
  `kotest-multiplatform`
  `maven-publish`
}

kotlin {
  sourceSets {
    val commonMain by getting {
      dependencies {
        api(project(":kotest-assertions-api"))
        implementation(project(":kotest-common"))
      }
    }
  }
}

apply(from = "../gradle/publishing-setup.gradle.kts")