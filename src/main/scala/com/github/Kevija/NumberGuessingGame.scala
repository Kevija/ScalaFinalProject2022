package com.github.Kevija

import scala.io.StdIn.{readInt, readLine}
import scala.util.Random

object NumberGuessingGame extends App {

  println("Hello! Welcome to Number Guessing Game!")
  println("Please enter your name: ")
  val playerName = readLine()

  println(s"Lets start the game $playerName! :)")

  def yourTry(): Unit = {
    val numberToGuess = new Random().nextInt(100)
    var guessedNumber = -1

    println("Please, guess a number from 0 to 100")

    while (guessedNumber != numberToGuess) {
      print("Your is your number guess?: ")
      guessedNumber = readInt()
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
}
