package com.restfeel.config

import com.codahale.metrics.ConsoleReporter
import com.codahale.metrics.MetricRegistry
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

/**
 * Created by jack on 2017/3/29.
 */
@Configuration
@EnableMetrics
class MetricsConfig : MetricsConfigurerAdapter() {
    override fun configureReporters(metricRegistry: MetricRegistry?) {
        ConsoleReporter.forRegistry(metricRegistry).build().start(1, TimeUnit.HOURS)
    }
}
