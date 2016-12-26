package trouw

import scala.io.{BufferedSource, Source}

/**
  * Created by Tom Lous on 26/12/16.
  * Copyright © 2016 Datlinq B.V..
  */
object CitatenPuzzelSolver {

  def main(args: Array[String]): Unit = {
    val nlWords = loadDict("nldict.txt")

    println(nlWords.toList)
  }

  def loadDict(fileName:String):Iterator[String] = {
    Source
      .fromURL(
        getClass
          .getClassLoader
          .getResource(fileName)
      )
      .getLines()
  }

}
