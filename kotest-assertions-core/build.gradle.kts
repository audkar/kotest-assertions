plugins {
  `kotest-multiplatform`
  `maven-publish`
}

kotlin {
  sourceSets {

    commonMain {
      dependencies {
        implementation(project(":kotest-common"))
        // this is api because we want to expose `shouldBe` etc
        api(project(":kotest-assertions-shared"))
      }
    }

    commonTest {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
      }
    }

    val jsTest by getting {
      dependencies {
        implementation(kotlin("test-js"))
      }
    }

    val jvmTest by getting {
      dependencies {
        implementation(kotlin("test-junit5"))
        implementation("org.junit.jupiter:junit-jupiter:${Versions.junit5}")
      }
    }
  }
}

apply(from = "../gradle/publishing-setup.gradle.kts")
