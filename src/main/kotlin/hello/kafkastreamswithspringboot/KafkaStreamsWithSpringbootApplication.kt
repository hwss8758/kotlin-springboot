package hello.kafkastreamswithspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaStreamsWithSpringbootApplication

fun main(args: Array<String>) {
    runApplication<KafkaStreamsWithSpringbootApplication>(*args)
}
