package com.github.Kevija

import java.util.Random
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.{readInt, readLine}


object NumberGuessingGame extends App {
  val saveDst = "src/resources/NumberGuessingGame/scores.csv"
  val db = new NumGuessGameDB("src/resources/NumberGuessingGame/NumGuessGame.db")
  var smallest = 0;
  var biggest = 100;
  println("Hello! Welcome to Number Guessing Game!")
  println("Please enter your name: ")
  val playerName = readLine()
  var movesArray: ArrayBuffer[Int] = ArrayBuffer()

  println(s"Lets start the game $playerName! :)")

  def yourTry(): Unit = {
    val numberToGuess = new Random().nextInt(biggest)
    var guessedNumber = -1

    println("Please, guess a number between "+smallest+" and "+biggest+"")

    while (guessedNumber != numberToGuess) {
      print("What is your number guess?: ")
      guessedNumber = readInt()
      //TODO add IF for numbers which are outside our range (0-100)
      if (guessedNumber > numberToGuess) println("Too large!")
      else if (guessedNumber < numberToGuess) println("Too small!")
      else {
        println("Fantastic! It is correct!")
        return

      }
    }
    println("Sorry! You lose!")
  }
    yourTry()
  NumberGuessingUtil.saveGameResult(saveDst,playerName,3) //FIXME numberOfMoves needs to be defined

}
