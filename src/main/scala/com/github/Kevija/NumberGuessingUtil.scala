package com.github.Kevija

import com.github.Kevija.NumberGuessingGame.{movesArray, playerName}

import java.io.FileWriter
import java.nio.file.{Files, Paths}
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.time.{ZoneOffset, ZonedDateTime}
import java.util.Calendar

object NumberGuessingUtil {

  //saves the text
  def saveText(dstPath: String, text: String, append:Boolean=false, verbose:Boolean=false):Unit = {
    //    import java.io.{PrintWriter, File} //explicit import
    if (verbose) println(s"Saving ${text.length} characters to $dstPath")
    //so writing to file can be done either by overwriting the whole file (the default)
    //or by appending to the end of the file
    val fw = new FileWriter(dstPath, append) //so by default old dstPath will be overWritten
    //    val pw = new PrintWriter(new File(dstPath))
    if (append) fw.write("\n") //think about appending custom header
    fw.write(text)
    fw.close() //when writing it is especially important to close as early as possible
  }

  //saves the lines
  def saveLines(dstPath: String, lines: Array[String], append:Boolean=false, lineEnd:String="\n"):Unit = {
    saveText(dstPath, lines.mkString(lineEnd), append)
  }

  //gets the moves
  def getMoves: Array[Int] = movesArray.toArray
  //def printMoves(): Array[Int] = {
  //  for ((move, index) <- moves.Array.zipWithIndex)
  //    movesArray.toArray
  //}

  // saves the results of game
  def saveGameResult(dst: String, playerName: String, numberOfMoves: Int ) = {
    if(! Files.exists(Paths.get(dst))){
      println("Saving header since no file exists")
      val header = "Player Name, Number of Moves, Date "
      saveText(dst, header)
    } else {
      println(s"Need to save name $playerName and $numberOfMoves")
      val now = Calendar.getInstance().getTime()
      println(s"Today is $now")
      val uctNow = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME)
      val row = s"$playerName, $numberOfMoves,$uctNow"
      saveText(dst,row,true)
    }
  }

  //saves the game scores
  def saveGameScore(folder: String = "src/resources/NumberGuessingGame", prefix: String = "game", suffix: String= ".csv"): Unit = {
    println("Saving game score!")
    val now = Calendar.getInstance().getTime
    val minuteFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss")
    val currentTimeAsString = minuteFormat.format(now)
    val dst = folder + "/" + prefix + "_" + currentTimeAsString + suffix
    println("Need to save the score!")
    val moveRows = for ((move, index) <- movesArray.zipWithIndex) yield {
      val row = s"$playerName, $move"
      row
    }

    saveLines(dst, moveRows.toArray)
  }
}
