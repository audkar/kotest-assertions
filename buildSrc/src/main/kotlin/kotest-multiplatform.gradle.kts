plugins {
  id("kotlin-multiplatform")
}

kotlin {
  targets {
    jvm()
    js {
      browser {
        testTask {
          useMocha()
        }
      }
      nodejs {
        testTask {
          useMocha()
        }
      }
    }

    linuxX64()
    linuxArm64()
    linuxArm32Hfp()
    linuxMips32()
    linuxMipsel32()

    mingwX64()

    macosX64()
    tvos()
    watchos()
    iosX64()
    iosArm64()
    iosArm32()

    wasm32()
  }

  sourceSets.all {
    languageSettings.apply {
      progressiveMode = true
      useExperimentalAnnotation("kotlin.RequiresOptIn")
    }
  }
}
