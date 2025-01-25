package cz.romanrakus.collector.coordinator

import cz.romanrakus.collector.coordinator.port.driven.Producer
import cz.romanrakus.collector.coordinator.port.driving.EventHandler
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class Coordinator(val producer: Producer) : EventHandler {

    var logger: Logger = LoggerFactory.getLogger(Coordinator::class.java)


    override fun onEvent(event: Event) {
        logger.debug("Received event: {}", event)
        producer.onEvent(event)
        logger.debug("Sent event: {}", event)
    }
}