package org.example

@main
def main(): Unit = {
  val dependency = DependencyImpl()
  val kata = new Kata(dependency)

  val result = kata.getValue

  println(s"result: $result")
}
