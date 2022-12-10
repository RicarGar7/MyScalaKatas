package org.example

import collection.mutable.Stack
import org.scalatest._
import flatspec._
import matchers._

class KataShould extends AnyFlatSpec with should.Matchers {
  it should "work with manual mocking" in {
    val dependency = DependencyImpl()
    val kata = new Kata(dependency)

    val result = kata.getValue

    result should be (0)
  }
}
