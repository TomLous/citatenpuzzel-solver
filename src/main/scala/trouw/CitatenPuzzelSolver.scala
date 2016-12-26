package trouw

import scala.io.{BufferedSource, Source}

/**
  * Created by Tom Lous on 26/12/16.
  * Copyright © 2016 Datlinq B.V..
  */
object CitatenPuzzelSolver {

  def main(args: Array[String]): Unit = {
    val nlDict = Dictionary("/nldict.txt")

    val choices = "dteosenegodaatntsdrnllrheoweknbouniestsrkedwieekeddeeseztnrkziennavnieenteleradzrdhneaaesvdaegalidtk".toCharArray

    val knownSolution = "onz_best_karakt_rt__i_____w_____en__l_v_______e____e___________a_e__t_________e__e__________h____e__".toCharArray

    // sanity check
    require(choices.length == knownSolution.length)
    require(choices.length == 100)




    println(nlDict.words.length)
  }


}
