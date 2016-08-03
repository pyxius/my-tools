package com.pyxius.mytools.mail

import java.util.Properties
import javax.mail.{Authenticator, PasswordAuthentication, Session}

case class Mail(from: String, to: String, subject: String, body: String)

object Mail {
  def apply(subject: String, body: String): Mail =
    new Mail(from = "admin@pyxius.com", to = "satyaprakash23@gmail.com", subject, body)
}


object EmailSender {

  def sendEMail(mail: Mail): Unit = {
    import org.apache.commons.mail._

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
    email.addTo(mail.to)
    email.setFrom(mail.from)
    email.setSubject(mail.subject)
    email.setMsg(mail.body)
    email.send()
  }
}
