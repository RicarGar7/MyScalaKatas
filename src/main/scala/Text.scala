package org.example

class Text {
  var value: String = ""
}

object Text {
  def apply(value: Option[String]): Text = {
    val text = new Text
    text.value = value.getOrElse({
      ""
    })

    text
  }
}