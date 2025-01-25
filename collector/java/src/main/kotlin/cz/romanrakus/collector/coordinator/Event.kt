package cz.romanrakus.collector.coordinator

import java.time.Instant

data class Event(
    val timestamp: Instant,
    val payload: Map<String, Any>,
    val headers: Map<String, String>,
    val cookies: Map<String, String>
)