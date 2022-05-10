package ru.ggeproto.domain.async
package services

import akka.actor.ActorSystem
import com.google.inject.Inject
import ru.ggeproto.domain.api.counter.services.CounterService
import ru.ggeproto.models.entity.Message
import scala.concurrent.{Future, Promise}
import scala.concurrent.duration.FiniteDuration

trait AsyncService {
    def getMessage(delayTime: FiniteDuration): Future[Message]
}


class AsyncServiceImpl @Inject()(actorSystem: ActorSystem, counterService: CounterService) extends AsyncService {
    def getMessage(delayTime: FiniteDuration): Future[Message] = {
        val promise: Promise[Message] = Promise[Message]()
        actorSystem.scheduler.scheduleOnce(delayTime) {
            promise.success(Message(s"Hi with delay $delayTime !", counterService.nextCount()))
        }(actorSystem.dispatcher) // run scheduled tasks using the actor system's dispatcher

        promise.future
    }
}
