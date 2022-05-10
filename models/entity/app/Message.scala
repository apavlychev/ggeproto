package ru.ggeproto.models.entity

import play.api.libs.json.{Json, Reads, Writes}

case class Message(info: String, attempts: Int)

object Message {
    implicit val writer: Writes[Message] = Json.writes[Message]
}
