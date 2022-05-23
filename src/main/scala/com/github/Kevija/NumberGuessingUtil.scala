package com.github.Kevija

import java.io.FileWriter
import java.nio.file.{Files, Paths}
import java.time.format.DateTimeFormatter
import java.time.{ZoneOffset, ZonedDateTime}
import java.util.Calendar

object NumberGuessingUtil {

  /** Saves the text
   * @param dstPath The destination line
   * @param text The text
   * @param append The append
   * @param verbose The verbose
   * @see See [[https://docs.scala-lang.org/style/scaladoc.html]] for more
   * information
   * @see See [[https://alvinalexander.com/scala/scaladoc-syntax-tags-wiki-formatting-examples]] for more
   * information
   */

  def saveText(dstPath: String, text: String, append:Boolean=false, verbose:Boolean=false):Unit = {
    if (verbose) println(s"Saving ${text.length} characters to $dstPath")
    val fw = new FileWriter(dstPath, append)
    if (append) fw.write("\n")
    fw.write(text)
    fw.close()
  }

  /** Saves the lines
   * @param dstPath The destination path
   * @param lines The lines
   * @param append The append
   * @param lineEnd The end line
   */

  def saveLines(dstPath: String, lines: Array[String], append:Boolean=false, lineEnd:String="\n"):Unit = {
    saveText(dstPath, lines.mkString(lineEnd), append)
  }

  /** Saves the results of game
   * @param dst The destination of results
   * @param playerName The player name
   * @param numberOfMoves The number of moves
   */

  def saveGameResult(dst: String, playerName: String, numberOfMoves: Int ): Unit = {
    if(! Files.exists(Paths.get(dst))){
      println("Saving header since no file exists")
      val header = "Player Name, Number of Moves, Date"
      saveText(dst, header)
    } else {
      println(s"Need to save player name: $playerName and count of moves: $numberOfMoves")
      val now = Calendar.getInstance().getTime
      println(s"Today is $now")
      val uctNow = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT)
      val row = s"$playerName, $numberOfMoves,$uctNow"
        saveText(dst, row, append = true)
      }
  }


}
