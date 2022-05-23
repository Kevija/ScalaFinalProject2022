package com.github.Kevija

import java.util.Random
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.{readInt, readLine}

/**
 * Object for holding NumberGuessingGame code
 * @author Anita Berziņa and Evija Kvante
 * @version 1.0.0
 */

object NumberGuessingGame extends App {

  val saveDst = "src/resources/NumberGuessingGame/scores.csv"
  val smallest = 0
  val biggest = 100
  println("****************************************************")
  println("****** Hello! Welcome to Number Guessing Game! *****")
  println("*****************************************************")
  println("Please enter your name: ")
  val playerName = readLine()
  var movesArray: ArrayBuffer[Int] = ArrayBuffer()
  var numberOfMoves = 0
  val tryCount = 7

  println(s"Lets start the game, $playerName! ❤ ")

  /** Main method for checking the number */

  def yourTry(): Unit = {
    val numberToGuess = new Random().nextInt(biggest)
    var guessedNumber = -1

    println("Please, guess a number between "+smallest+" and "+biggest+"")

    while (numberOfMoves<tryCount & guessedNumber != numberToGuess) {
      print("What is your number guess?: ")
      guessedNumber = readInt()

      /** Added IF case for numbers which are outside our range (0-100) */

     numberOfMoves=numberOfMoves+1
      if (guessedNumber> biggest || guessedNumber<smallest) println(s"Inappropriate input. Number should be between $smallest and $biggest. ")
      else {
      if (guessedNumber > numberToGuess) println("Too large! ➖ ")
      else if (guessedNumber < numberToGuess) println("Too small! ➕ ")
      else {

        /** Appears the text when the number is guessed */

        println(s"Fantastic, $playerName! 👏 It is correct! You solved this game in $numberOfMoves moves")
        println("********************************************************************")
        return
      }}
    }

    /** Appears the text, when game is lost */

    println(s"Sorry, $playerName, you didn't guess the correct number! ☹ Maybe next time!")
    println("***************************************************************")
  }
    yourTry()

  /** Saves the results of game */

  NumberGuessingUtil.saveGameResult(saveDst,playerName,numberOfMoves)

  /** Functionalities for future improvements:
   *  offer to play again
     save game results in database */


}
