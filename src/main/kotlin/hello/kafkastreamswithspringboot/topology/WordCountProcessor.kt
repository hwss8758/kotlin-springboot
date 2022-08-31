package hello.kafkastreamswithspringboot.topology

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class WordCountProcessor {

    @Autowired
    fun buildPipeline(builder: StreamsBuilder) {
        val messageStream = builder.stream("input-topic", Consumed.with(STRING_SERDE, STRING_SERDE))

        val wordCounts = messageStream
            .mapValues { _, value -> value.lowercase() }
            .flatMapValues { _, value -> value.split("\\W+") }
            .groupBy { _, value -> value }
            .count()

        wordCounts.toStream().to("output-topic")

    }

    companion object {
        private val STRING_SERDE = Serdes.String()
    }
}