package org.example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class WordWrapParametersShould extends AnyFlatSpec with should.Matchers {
  "WordWrapParameters" should "should not instantiate with None values" in {
    assertThrows[NoneColumnWithException] {
      WordWrapParameters(Text(Some("Hola")), ColumnWith(None))
    }
  }

  "WordWrapParameters" should "should not instantiate with negative integer values" in {
    assertThrows[InvalidColumnWithException] {
      WordWrapParameters(Text(Some("Hola")), ColumnWith(Some(-1)))
    }
  }

  "WordWrapParameters" should "should instantiate a None Text to empty" in {
      WordWrapParameters(Text(None), ColumnWith(Some(1)))
  }

}
