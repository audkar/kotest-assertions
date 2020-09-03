package io.kotest

import io.kotest.assertions.shouldFail
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class BasicTest {

  @Test
  fun assertionsWorks() {
    shouldFail {
      1 shouldBe 2
    }
  }

}
