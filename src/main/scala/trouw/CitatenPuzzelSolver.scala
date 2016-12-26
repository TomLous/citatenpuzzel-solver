package trouw

import scala.io.{BufferedSource, Source}

/**
  * Created by Tom Lous on 26/12/16.
  * Copyright © 2016 Datlinq B.V..
  */
object CitatenPuzzelSolver {

  def main(args: Array[String]): Unit = {
    val nlDict = Dictionary("/nldict.txt")

    println(nlDict.words.toList)
  }


}
