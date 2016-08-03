package com.pyxius.mytools.mail

import java.util.Properties
import javax.mail.{Authenticator, PasswordAuthentication, Session}

import org.apache.commons.mail.SimpleEmail

case class NotifyMail(from: String, to: String, subject: String, body: String)

object NotifyMail {
  def apply(subject: String, body: String): NotifyMail =
    new NotifyMail(from = "admin@pyxius.com", to = "satyaprakash23@gmail.com", subject, body)
}


object EmailSender {

  def sendEMail(notifyMail: NotifyMail) = {
    import org.apache.commons._

    val properties = new Properties()
    properties.put("mail.smtp.host", "smtp.gmail.com")
    properties.put("mail.smtp.port", "25")
    properties.put("mail.smtp.auth", "true")
    properties.put("mail.smtp.starttls.enable", "true")

    val auth = new Authenticator() {
      override def getPasswordAuthentication = new PasswordAuthentication("username", "password")
    }

    val session = Session.getDefaultInstance(properties, auth)

    val email = new SimpleEmail()
    email.setMailSession(session)
    email.addTo(notifyMail.to)
    email.setFrom(notifyMail.from)
    email.setSubject(notifyMail.subject)
    email.setMsg(notifyMail.body)
    email.send()
  }
}
