package trouw

import org.scalatest.{FunSuite, Matchers, WordSpec}

/**
  * Created by Tom Lous on 26/12/16.
  * Copyright © 2016 Datlinq B.V..
  */
class DictionaryTest extends WordSpec with Matchers {

  "Dictionary" should {
    val nlDict = Dictionary("/nldict.txt")

    "Check words" in {
      assert(
        Dictionary.checkWord("open", "open".toCharArray.toList) == (true, Nil)
      )
      assert(
        Dictionary.checkWord("neop", "open".toCharArray.toList) == (true, Nil)
      )
      assert(
        Dictionary.checkWord("neop", "heropening".toCharArray.toList) == (true, "hreing".toCharArray.toList)
      )
      assert(
        Dictionary.checkWord("neop", "heropeig".toCharArray.toList) == (false, "heropeig".toCharArray.toList)
      )
    }
  }

}
