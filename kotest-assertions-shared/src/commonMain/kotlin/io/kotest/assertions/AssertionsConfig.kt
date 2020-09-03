package io.kotest.assertions

object AssertionsConfig {
   val showDataClassDiff: Boolean
      get() = true

   val largeStringDiffMinSize: Int
      get() = 50

   val multiLineDiff: String
      get() = ""

   val maxErrorsOutput: Int
      get() =  10
}
