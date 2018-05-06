package kirk.internal

import kirk.api.Result
import kirk.api.Status
import kirk.internal.reporting.writeToString

internal class FailFastAssertionResultHandler : AssertionResultHandler {
  override fun report(result: Result) {
    result.writeToString().let(::println)
    if (result.status == Status.Failed) {
      throw AssertionFailed(result)
    }
  }
}