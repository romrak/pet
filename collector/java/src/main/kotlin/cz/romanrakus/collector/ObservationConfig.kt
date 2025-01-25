package cz.romanrakus.collector

import io.micrometer.observation.ObservationRegistry
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.web.filter.ServerHttpObservationFilter


@Configuration
class ObservationConfig {
    @Bean
    fun observationFilter(observationRegistry: ObservationRegistry): FilterRegistrationBean<ServerHttpObservationFilter> {
        val registrationBean: FilterRegistrationBean<ServerHttpObservationFilter> =
            FilterRegistrationBean<ServerHttpObservationFilter>()
        registrationBean.filter = ServerHttpObservationFilter(observationRegistry)
        registrationBean.order = Ordered.HIGHEST_PRECEDENCE
        return registrationBean
    }
}