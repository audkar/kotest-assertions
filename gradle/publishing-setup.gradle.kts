import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.repositories.PasswordCredentials
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.tasks.AbstractPublishToMaven
import org.gradle.kotlin.dsl.credentials
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

//TODO convert to plugin and move to buildSrc once gradle kts supports KT 1.4

//class KotestPublishingPlugin : Plugin<Project> {
//  override fun apply(project: Project) {
project.extensions.getByType<PublishingExtension>().apply {
  repositories {
        maven {
          name = "github"
          url = project.uri("https://maven.pkg.github.com/audkar/kotest-assertions")
          credentials(PasswordCredentials::class)
        }
  }
  publications.withType<MavenPublication>().forEach {
    it.apply {
      pom {
        name.set("Kotest")
        description.set("Kotlin Test Framework")
        url.set("https://github.com/audkar/kotest-assertions")
        scm {
          url.set("https://github.com/audkar/kotest-assertions.git")
        }
      }
    }
  }
}
project.extensions.getByType<KotlinMultiplatformExtension>().apply {
  project.configure(
    listOf(targets["metadata"], jvm(), js(), wasm32()) + targets.withType<KotlinNativeTarget>()
      .filter { it.konanTarget.family == org.jetbrains.kotlin.konan.target.Family.LINUX }) {
    mavenPublication {
      val targetPublication = this@mavenPublication
      project.tasks.withType<AbstractPublishToMaven>()
        .matching {
          it.publication == targetPublication ||
              it.identityPath.name?.contains("publishKotlinMultiplatformPublication") == true
        }
        .forEach {
          it.onlyIf { project.findProperty("isLinuxHost") == "true" }
        }
    }
  }
}
//  }
//}
