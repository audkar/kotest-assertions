import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.Family.*

plugins {
  `kotest-multiplatform`
  `maven-publish`
}

kotlin {
  targets.withType<KotlinNativeTarget>().filter {it.konanTarget.family == LINUX }
}

apply(from = "../gradle/publishing-setup.gradle.kts")
