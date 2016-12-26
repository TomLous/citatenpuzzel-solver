package trouw

import org.scalatest.{FunSuite, Matchers, WordSpec}

/**
  * Created by Tom Lous on 26/12/16.
  * Copyright © 2016 Datlinq B.V..
  */
class DictionaryTest extends WordSpec with Matchers {

  "Dictionary" should {
    val nlDict = Dictionary("/nldict.txt")



    "Check all rec" in {
      assert(
        nlDict.checkAllRecursive("toenonzemopeen".toCharArray.toList).size == 4
      )

    }
    "Check all" in {
      assert(
        nlDict.checkAll("toenonzemopeenmopjewas".toCharArray.toList).size == 211
      )

    }

    "Check words" in {
      assert(
        Dictionary.checkWord("open", "open".toCharArray.toList) == (Some("open"), Nil)
      )
      assert(
        Dictionary.checkWord("neop", "open".toCharArray.toList) == (Some("neop"), Nil)
      )
      assert(
        Dictionary.checkWord("neop", "heropening".toCharArray.toList) == (Some("neop"), "hreing".toCharArray.toList)
      )
      assert(
        Dictionary.checkWord("neop", "heropeig".toCharArray.toList) == (None, "heropeig".toCharArray.toList)
      )
    }


  }

}
