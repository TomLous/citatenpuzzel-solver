package trouw

import scala.annotation.tailrec
import scala.collection.immutable.Iterable
import scala.io.Source

/**
  * Created by Tom Lous on 26/12/16.
  * Copyright © 2016 Datlinq B.V..
  */
case class Dictionary(words:List[String]) {

//  lazy val filteredWordSets = (charArr:Array[Char]) => {
//
//
//    words.map(word => {
//
//
//    })
//  }

  def checkAll(charList:List[Char]):Map[String, List[Char]] = {
    words.map(word => Dictionary.checkWord(word,charList))
      .filter(_._1.isDefined)
      .map(t => t._1.get ->  t._2).toMap
  }


  def checkAllRecursive(charList:List[Char]):List[List[String]] = {


    def rec(charList:List[Char], words: List[String]):List[List[String]] = charList match {
      case Nil => List(words)
      case _ => {
        val options: Map[String, List[Char]] = checkAll(charList)
        if (options.size == 0) Nil
        else {
          options.flatMap {
            case (word, remainingCharsList) => rec(remainingCharsList, word :: words)
          }.toList
        }
      }

    }

    rec(charList, Nil)
  }



}

object Dictionary{

//  def apply(words: Iterator[String]): Dictionary = new Dictionary(words)

  def apply(fileName:String): Dictionary = {
    val words = loadDict(fileName)
    new Dictionary(words)
  }

  private def loadDict(fileName:String):List[String] = {
    val resource = getClass.getResource(fileName)

    Source
      .fromURL(resource)
      .getLines()
      .toList
  }

  def checkWord(word:String, charArr:List[Char]):(Option[String], List[Char])  = {
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

    if(found) (Some(word), remaining)
    else (None,  charArr)
  }

}
