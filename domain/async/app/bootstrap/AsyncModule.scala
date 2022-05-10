package ru.ggeproto.domain.async
package bootstrap

import com.google.inject.AbstractModule
import ru.ggeproto.domain.async.services.AsyncService
import ru.ggeproto.domain.async.services.AsyncServiceImpl

class AsyncModule extends AbstractModule {

    override def configure() = {
        bind(classOf[AsyncService]).to(classOf[AsyncServiceImpl])
    }
}
