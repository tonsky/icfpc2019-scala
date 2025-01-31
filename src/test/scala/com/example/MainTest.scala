package com.example

import java.nio.file.Paths

import org.scalatest.FunSuite


class MainTest extends FunSuite {

  test("run0") {
    Main.main(Array[String]())
  }

  test("run") {
    Main.main(Array[String](getDescFiles.head))
  }

  test("run1 interactive") {
    Main.main(Array[String]("--threads=1", "--interactive", getDescFiles.head))
  }

  test("run interactive all") {
    Main.main(Array[String]("--interactive") ++ getDescFiles)
  }

  test("run8") {
    Main.main(Array[String]("--threads=8", getDescFiles.head))
  }

  test("run8 all") {
    Main.main(Array[String]("--threads=8") ++ getDescFiles)
  }

  test("run all") {
    Main.main(getDescFiles)
  }

  def getDescFiles: Array[String] = {
    val projectDir = new java.io.File(".").getAbsolutePath
    Paths.get(projectDir, "problems").toFile.listFiles.filter(_.isFile).filter(_.getName.endsWith(".desc")).map(_.getAbsolutePath)
  }
}