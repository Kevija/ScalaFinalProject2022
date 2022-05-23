package com.github.Kevija

import java.sql.DriverManager

class NumGuessGameDB (val dbPath: String) {

  // connects the database
    val url = s"jdbc:sqlite:$dbPath"
    val conn = DriverManager.getConnection(url)
    println(s"Opened database at ${conn.getMetaData.getURL}")
  }

