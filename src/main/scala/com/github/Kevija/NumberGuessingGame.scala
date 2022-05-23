package com.github.Kevija

import java.util.Random
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.{readInt, readLine}

/**
 * object for holding NumberGuessingGame code
 * @author Anita Kaminska and Evija Kvante
 * @version 1.0.0
 */

object NumberGuessingGame extends App {

  val saveDst = "src/resources/NumberGuessingGame/scores.csv"
  //val db = new NumGuessGameDB("src/resources/NumberGuessingGame/NumGuessGame.db")
  var smallest = 0;
  var biggest = 100;
  println("Hello! Welcome to Number Guessing Game!")
  println("Please enter your name: ")
  val playerName = readLine()
  var movesArray: ArrayBuffer[Int] = ArrayBuffer()
  var numberOfMoves = 0;
  val tryCount = 7;

  println(s"Lets start the game, $playerName! :)")

  //main method for checking the number
  def yourTry(): Unit = {
    val numberToGuess = new Random().nextInt(biggest)
    var guessedNumber = -1

    println("Please, guess a number between "+smallest+" and "+biggest+"")

    while (numberOfMoves<tryCount & guessedNumber != numberToGuess) {
      print("What is your number guess?: ")
      guessedNumber = readInt()

      //added IF case for numbers which are outside our range (0-100)
     numberOfMoves=numberOfMoves+1
      if (guessedNumber> biggest || guessedNumber<smallest) println(s"Inappropriate input. Number should be between $smallest and $biggest. ")
      else {
      if (guessedNumber > numberToGuess) println("Too large!")
      else if (guessedNumber < numberToGuess) println("Too small!")
      else {
    // text that appears when guess a correct number
        println(s"Fantastic, $playerName! :) It is correct! You solved this game in $numberOfMoves moves")
        return

      }}
    }
    // text that appears losing the game
    println(s"Sorry, $playerName! :( Maybe next time!")
  }
    yourTry()

  //saves game results
  NumberGuessingUtil.saveGameResult(saveDst,playerName,numberOfMoves)

  /** functionalities for future improvements
  *TODO offer to play again
   */
}
