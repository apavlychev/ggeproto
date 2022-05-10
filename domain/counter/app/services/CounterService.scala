package ru.ggeproto.domain.counter
package services

import com.google.inject.Inject
import ru.ggeproto.domain.api.counter.services.CounterService
import ru.ggeproto.domain.counter.bootstrap.CounterModule
import ru.ggeproto.domain.counter.repositories.CounterRepository
import ru.ggeproto.models.entity.Message
/**
 * This class is a concrete implementation of the [[CounterService]] trait.
 * It is configured for Guice dependency injection in the [[CounterModule]]
 * class.
 *
 * This class has a `Singleton` annotation because we need to make
 * sure we only use one counter per application. Without this
 * annotation we would get a new instance every time a [[CounterService]] is
 * injected.
 */
class CounterServiceImpl @Inject()(repository: CounterRepository) extends CounterService {
    def nextCount(): Int = repository.getAndIncrement()

    def displayCount(): Message = Message("Increment and get count", repository.get())
}