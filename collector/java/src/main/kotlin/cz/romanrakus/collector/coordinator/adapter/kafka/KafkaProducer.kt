package cz.romanrakus.collector.coordinator.adapter.kafka

import cz.romanrakus.collector.coordinator.Coordinator
import cz.romanrakus.collector.coordinator.Event
import cz.romanrakus.collector.coordinator.port.driven.Producer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducer(private val kafkaTemplate: KafkaTemplate<String, String>) : Producer {
    var logger: Logger = LoggerFactory.getLogger(Coordinator::class.java)

    override fun onEvent(event: Event) {
        val future = kafkaTemplate.send(
            "events",
            event.payload.getOrDefault("email", "UNKNOWN") as String,
            mapEvent(event)
        )
        future.whenComplete { result: Any?, ex: Throwable? ->
            if (ex == null) {
                logger.debug("Event {} was sent successfully: {}", event, result)
            } else {
                logger.error("Error sending event: $event", ex)
            }
        }

    }

    private fun mapEvent(event: Event): String {
        return event.toString()
    }
}