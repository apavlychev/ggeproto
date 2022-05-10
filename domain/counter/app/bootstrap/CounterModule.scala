package ru.ggeproto.domain.counter
package bootstrap

import services.CounterServiceImpl
import com.google.inject.AbstractModule
import ru.ggeproto.domain.api.counter.services.CounterService
import ru.ggeproto.domain.counter.repositories.{CounterRepository, MemoryCounterRepository}

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.

 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
class CounterModule extends AbstractModule {

    override def configure() = {
        bind(classOf[CounterRepository]).to(classOf[MemoryCounterRepository]).asEagerSingleton()
        bind(classOf[CounterService]).to(classOf[CounterServiceImpl])
    }
}