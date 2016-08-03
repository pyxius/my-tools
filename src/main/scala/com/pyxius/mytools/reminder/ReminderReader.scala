package com.pyxius.mytools.reminder

import java.io.File
import java.util.Date

import com.pyxius.mytools.mail.EmailSender
import com.pyxius.mytools.mail.{EmailSender, NotifyMail}

import scala.io.Source


case class Reminder(startDate: Date, endDate: Date, subject: String, message: String)

object Reminder {
  def parse(str: String): Reminder = {
    val Array(startDate, endDate, subject, message, _*) = str.split('|')
    Reminder(new Date(startDate), new Date(endDate), subject, message)
  }
}


object ReminderReader {
  def parseFile(file: File) = {
    for (line <- Source.fromFile(file).getLines()) {
      val reminder = Reminder.parse(line)
      if (isValid(reminder)) {
        EmailSender.sendEMail(NotifyMail(reminder.subject, reminder.message))
      }
    }
  }

  def isValid(reminder: Reminder): Boolean = {
    true;  //TODO Add reminder validation code
  }

}



