package org.example

import collection.mutable.Stack
import org.scalatest.*
import flatspec.*
import matchers.*

class WordWrapShould extends AnyFlatSpec with should.Matchers {
  "WordWrap" should "handle rare input parameters" in {
    assertWrap(
      input = WordWrapParameters(Text(None), ColumnWith(Some(1))),
      output = ""
    )
    assertWrap(
      input = WordWrapParameters(Text(Some("")), ColumnWith(Some(1))),
      output = ""
    )
  }
  "WordWrap" should "wrap text without any spaces" in {
    assertWrap(
      input = WordWrapParameters(Text(Some("Hello")), ColumnWith(Some(5))),
      output = "Hello"
    )
    assertWrap(
      input = WordWrapParameters(Text(Some("Hell")), ColumnWith(Some(2))),
      output = "He\nll"
    )
    assertWrap(
      input = WordWrapParameters(Text(Some("Hello")), ColumnWith(Some(1))),
      output = "H\ne\nl\nl\no"
    )
  }
  "WordWrap" should "wrap text with spaces" in {
    assertWrap(
      input = WordWrapParameters(Text(Some("hello world")), ColumnWith(Some(5))),
      output = "hello\nworld"
    )
  }
  "WordWrap" should "wrap text with spaces not breaking words" in {
    assertWrap(
      input = WordWrapParameters(Text(Some("x xx")), ColumnWith(Some(3))),
      output = "x\nxx"
    )
    assertWrap(
      input = WordWrapParameters(Text(Some("x x")), ColumnWith(Some(2))),
      output = "x\nx"
    )
    assertWrap(
      input = WordWrapParameters(Text(Some("x xxx")), ColumnWith(Some(3))),
      output = "x\nxxx"
    )
    assertWrap(
      input = WordWrapParameters(Text(Some("x xxxxxx")), ColumnWith(Some(3))),
      output = "x\nxxx\nxxx"
    )
  }
  "WordWrap" should "handle edge cases" in {
      assertWrap(
          input = WordWrapParameters(Text(Some("x x x")), ColumnWith(Some(3))),
      output = "x x\nx"
      )
    }


  private def assertWrap(input: WordWrapParameters, output: String) = {
    WordWrap(input) should be(output)
  }
}

