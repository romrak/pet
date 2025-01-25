package cz.romanrakus.collector.coordinator.port.driven

import cz.romanrakus.collector.coordinator.Event

interface Producer {
    fun onEvent(event: Event)
}