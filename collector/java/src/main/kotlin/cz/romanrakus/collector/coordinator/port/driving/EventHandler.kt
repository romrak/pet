package cz.romanrakus.collector.coordinator.port.driving

import cz.romanrakus.collector.coordinator.Event

interface EventHandler {
    fun onEvent(event: Event)
}