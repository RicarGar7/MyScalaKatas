package org.example

import scala.util.Try

case class WordWrapParameters(text: Text, columnWidth: ColumnWith)

object WordWrap {
  def apply(params: WordWrapParameters): String = {
    val text = params.text.value.trim
    val columnWidth = params.columnWidth.value
    wrapText(text, columnWidth)
  }

  private def wrapText(text: String, columnWidth: Int): String = text.length match {
    case len if len <= columnWidth && !text.contains(' ') => text
    case _ =>
      val (current, rest) = splitTextAtWidth(text, columnWidth)
      current + (if (rest.isEmpty) "" else "\n" + wrapText(rest.trim, columnWidth))
  }

  private def splitTextAtWidth(text: String, columnWidth: Int): (String, String) = {
    val splitPosition = if (text.length <= columnWidth) text.length else text.lastIndexOf(' ', columnWidth)
    (text.substring(0, splitPosition), text.substring(splitPosition))
  }
}
