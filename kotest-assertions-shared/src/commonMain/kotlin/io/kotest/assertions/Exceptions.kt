package io.kotest.assertions

/**
 * Use this object to create exceptions on a target platform.
 * This will create the most appropriate exception type, such as org.opentest4j.AssertionFailedError on
 * platforms that support it, and defaulting to the basic kotlin AssertionError in the degenerative case.
 */
object Exceptions {
   fun createAssertionError(message: String): AssertionError = AssertionError(message)
}
