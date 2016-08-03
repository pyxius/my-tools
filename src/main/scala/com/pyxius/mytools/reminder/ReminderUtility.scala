package com.pyxius.mytools.reminder

import java.io.{File, IOException}

object ReminderUtility {

  def main(args: Array[String]) {
    args foreach { x =>
      if(x.nonEmpty) {
        sendReminders(x)
      }else{
        println("Usage: ReminderUtility <reminderFileLocation>")
      }
    }
  }

  def sendReminders(fileLocation: String) = {
    try {
      ReminderReader.parseFile(new File(fileLocation))
    }catch{
      case ioe:IOException => {
        println(s"Invalid reminder file location $fileLocation, ${ioe.getMessage}")
      }
    }
  }

}
