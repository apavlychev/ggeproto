package ru.ggeproto.domain.api.counter.services

import ru.ggeproto.models.entity.Message

/**
 * This trait demonstrates how to create a component that is injected
 * into a controller. The trait represents a counter that returns a
 * incremented number each time it is called.
 */
trait CounterService {
    def nextCount(): Int

    def displayCount(): Message
}