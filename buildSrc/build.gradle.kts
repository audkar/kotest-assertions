repositories {
  mavenCentral()
  gradlePluginPortal()
}

plugins {
  `kotlin-dsl`
}

kotlinDslPluginOptions {
  experimentalWarning.set(false)
}

dependencies {
  implementation(kotlin("gradle-plugin", "1.4.0"))
  implementation(gradleApi())
  implementation(localGroovy())
  implementation("com.github.ben-manes:gradle-versions-plugin:0.29.0")
}
