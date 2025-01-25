package cz.romanrakus.collector.coordinator.adapter.kafka

import cz.romanrakus.collector.coordinator.Event
import cz.romanrakus.collector.coordinator.port.driven.Producer

class KafkaProducer : Producer {
    override fun onEvent(event: Event) {
        TODO("Not yet implemented")
    }
}