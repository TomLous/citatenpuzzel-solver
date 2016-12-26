package trouw

import scala.annotation.tailrec
import scala.io.Source

/**
  * Created by Tom Lous on 26/12/16.
  * Copyright © 2016 Datlinq B.V..
  */
case class Dictionary(words:Iterator[String]) {

//  lazy val filteredWordSets = (charArr:Array[Char]) => {
//
//
//    words.map(word => {
//
//
//    })
//  }







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

  def checkWord(word:String, charArr:List[Char]):(Boolean, List[Char])  = {
    val wordArr = word.toCharArray.toList

    @tailrec
    def checkChars(wordArr:List[Char], charArr:List[Char]):(Boolean, List[Char]) = {
      wordArr match {
        case Nil => (true, charArr)
        case ch :: tail => {
          val pos = charArr.indexOf(ch)
          if (pos < 0) (false, charArr)
          else checkChars(tail, charArr.take(pos) ++ charArr.drop(pos + 1))
        }
      }
    }

    val (found, remaining) =  checkChars(wordArr, charArr)

    if(found) (true, remaining)
    else (false, charArr)
  }

}
