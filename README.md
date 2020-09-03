### Kotest assertion artifacts for all platforms

- This is a hard fork of ⏩ [Kotest](https://github.com/kotest/kotest) ⏪ assertions.
- Single purpose - have assertions library prebuilt for all platforms.
- Probably will never get updates. Use upstream Kotest 👌 if it supports all your required platforms.

#### Add to project

Adding custom gradle repository (Requires gradle >=6.6)

`gradle.build.kts`
```kotlin
repositories {
  exclusiveContent {
    forRepository {
      maven {
        url = uri("https://maven.pkg.github.com/audkar/kotest-assertions")
      }
    }
    filter {
      includeGroup("io.kotest.assertions")
    }
  }
}
```
Add dependency to test sourceSet

`gradle.build.kts`
```kotlin
implementation("io.kotest:kotest-assertions-core:4.2.6")
```
