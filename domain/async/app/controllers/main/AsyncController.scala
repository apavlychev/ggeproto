package ru.ggeproto.domain.async
package controllers.main

import play.api.mvc._
import ru.ggeproto.domain.async.services.AsyncService
import javax.inject._
import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future, Promise}
import play.api.libs.json._
import ru.ggeproto.models.entity.Message

/**
 * This controller creates an `Action` that demonstrates how to write
 * simple asynchronous code in a controller. It uses a timer to
 * asynchronously delay sending a response for 1 second.
 *
 * @param cc standard controller components
 * @param actorSystem We need the `ActorSystem`'s `Scheduler` to
 * run code after a delay.
 * @param exec We need an `ExecutionContext` to execute our
 * asynchronous code.  When rendering content, you should use Play's
 * default execution context, which is dependency injected.  If you are
 * using blocking operations, such as database or network access, then you should
 * use a different custom execution context that has a thread pool configured for
 * a blocking API.
 */
@Singleton
class AsyncController @Inject()(cc: ControllerComponents, asyncService: AsyncService)(implicit exec: ExecutionContext) extends AbstractController(cc) {

    /**
     * Creates an Action that returns a plain text message after a delay
     * of 1 second.
     *
     * The configuration in the `routes` file means that this method
     * will be called when the application receives a `GET` request with
     * a path of `/message`.
     */
    def message = Action.async {
        asyncService.getMessage(1.second).map { msg: Message => Ok(Json.toJson(msg)) }
    }
}