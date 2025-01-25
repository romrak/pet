package cz.romanrakus.collector.coordinator.adapter.webhook

import cz.romanrakus.collector.coordinator.Event
import cz.romanrakus.collector.coordinator.port.driving.EventHandler
import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
class Webhook(
    private val eventHandler: EventHandler,
) {

    @PostMapping("/events")
    fun handle(@RequestBody payload: Map<String, Any>, request: HttpServletRequest) {
        val cookies = request.cookies?.associate { it.name to it.value } ?: emptyMap()
        val headers = request.headerNames.asSequence().associateWith { request.getHeader(it) }
        eventHandler.onEvent(Event(
            timestamp = Instant.now(),
            payload = payload,
            headers = headers,
            cookies = cookies
        ))
    }
}