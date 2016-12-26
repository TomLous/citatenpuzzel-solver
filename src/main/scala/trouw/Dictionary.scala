package trouw

import scala.io.Source

/**
  * Created by Tom Lous on 26/12/16.
  * Copyright © 2016 Datlinq B.V..
  */
case class Dictionary(words:Iterator[String]) {

}

object Dictionary{

//  def apply(words: Iterator[String]): Dictionary = new Dictionary(words)

  def apply(fileName:String): Dictionary = {
    val words = loadDict(fileName)
    new Dictionary(words)
  }

  private def loadDict(fileName:String):Iterator[String] = {
    val resource = getClass.getResource(fileName)

    Source
      .fromURL(resource)
      .getLines()
  }

}
