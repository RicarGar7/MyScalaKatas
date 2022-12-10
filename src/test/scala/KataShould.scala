package org.example

class KataShould extends munit.FunSuite {
  test("work with manual mock") {
    val dependency = DependencyImpl()
    val kata = new Kata(dependency)

    val result = kata.getValue

    assertEquals(result, 0)
  }
}
