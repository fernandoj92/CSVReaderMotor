package core

import scala.collection.mutable.ListBuffer

/**
  * Created by Fer on 05/07/2016.
  */
object Reader {

  def showLines(filePath: String, firstLines: Int): Unit ={
    val bufferedSource = io.Source.fromFile(filePath)

    var cont = 0
    for (line <- bufferedSource.getLines()) {
      cont = cont + 1
      if (cont <= firstLines) {
        val dividedLine = line.split(",").map(column => column.trim())
        var s =""
        for(section <- dividedLine.indices)
          s+= "["+section+"] " + dividedLine(section)
        println(s)
      }
    }

    bufferedSource.close()
  }

  def filterFile(columns: List[Int], firstLines:Int, newFileName: String): Unit ={

  }


  def mergeFiles(filePaths: List[String], columnsPerFile: List[List[Int]], numberOfLines: Int, newFileName: String): Unit ={
    // Creamos una lista que contiene X listbuffers

    val observations = (for (i <- 1 to numberOfLines) yield ListBuffer.empty[Double]).toList

    for(fileNumber <- 0 to filePaths.size){
      // Opens the file.
      val bufferedSource = io.Source.fromFile(filePaths(fileNumber))

      // Almacenamos cada una de las lineas tras el header
      var lines = bufferedSource.getLines().drop(1).toList
      val diff = lines.size - numberOfLines
      if(diff > 0)
        lines = lines.drop(diff)

      //line: String
      for(i<-0 to lines.size) {
        // observation: Seq[Double]
        val observation = lines(i).split(",").map(column => column.trim().toDouble)
        for (columnNumber <- columnsPerFile(fileNumber)) {
          observations(i) += observation(columnNumber)
        }
      }

    }
  }

}
