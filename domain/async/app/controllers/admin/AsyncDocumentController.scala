package ru.ggeproto.domain.async.controllers.admin

import play.api.mvc._

import javax.inject._
import scala.concurrent.ExecutionContext
import play.api.Configuration

@Singleton
class AsyncDocumentController @Inject()(cc: ControllerComponents, config: Configuration)(implicit exec: ExecutionContext) extends AbstractController(cc) {

    def document = Action {
        val mainHost = config.get[String]("main.host")
        Ok(views.html.admin.asyncDocument(mainHost))
    }
}
