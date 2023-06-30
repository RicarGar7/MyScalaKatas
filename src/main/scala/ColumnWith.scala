package org.example

class NoneColumnWithException extends Exception("El valor de ColumnWidth no puede ser None")
class InvalidColumnWithException extends Exception("El valor de ColumnWidth no puede ser negativo")
class ColumnWith {var value: Int = 0}
object ColumnWith {
  def apply(value: Option[Int]): ColumnWith = {
    val integer = value.getOrElse(throw new NoneColumnWithException)
    if (integer < 0) {
      throw new InvalidColumnWithException
    }

    val columnWith = new ColumnWith
    columnWith.value = integer
    columnWith
  }

}