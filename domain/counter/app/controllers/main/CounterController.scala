package ru.ggeproto.domain.counter
package controllers.main

import play.api.libs.json.Json
import play.api.mvc._
import ru.ggeproto.domain.api.counter.services.CounterService
import ru.ggeproto.models.entity.Message

import javax.inject._

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class creates an
 * `Action` that shows an incrementing count to users. The [[CounterService]]
 * object is injected by the Guice dependency injection system.
 */
@Singleton
class CounterController @Inject()(cc: ControllerComponents,
                                  counter: CounterService) extends AbstractController(cc) {

    /**
     * Create an action that responds with the [[CounterService]]'s current
     * count. The result is plain text. This `Action` is mapped to
     * `GET /count` requests by an entry in the `routes` config file.
     */
    def count = Action {
        counter.nextCount()
        Ok(Json.toJson(counter.displayCount().asInstanceOf[Message]))
    }
}
