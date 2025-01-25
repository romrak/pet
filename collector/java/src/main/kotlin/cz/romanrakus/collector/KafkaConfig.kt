package cz.romanrakus.collector

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfig {
    @Bean
    fun topicEvents() =
        TopicBuilder.name("events")
            .partitions(1000)
            .compact()
            .build()
}