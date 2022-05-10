package ru.ggeproto.domain.counter.controllers.admin

import play.api.mvc._

import javax.inject._
import scala.concurrent.ExecutionContext
import play.api.Configuration

@Singleton
class CounterDocumentController @Inject()(cc: ControllerComponents, config: Configuration)(implicit exec: ExecutionContext) extends AbstractController(cc) {

    def document = Action { implicit rc =>
        val mainHost = config.get[String]("main.host")
        Ok(views.html.admin.counterDocument(mainHost))
    }
}
