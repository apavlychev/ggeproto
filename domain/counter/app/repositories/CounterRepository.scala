package ru.ggeproto.domain.counter
package repositories

import com.google.inject.Inject
import java.util.concurrent.atomic.AtomicInteger

trait CounterRepository {
    def getAndIncrement(): Int

    def get(): Int

    def increment(): Unit
}

class MemoryCounterRepository @Inject()() extends CounterRepository {
    private lazy val atomicCounter = new AtomicInteger()

    def getAndIncrement(): Int = atomicCounter.getAndIncrement()

    def get(): Int = atomicCounter.get()

    def increment(): Unit = atomicCounter.incrementAndGet()
}
