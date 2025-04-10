package com.infuse.tecnologia.infrastructure.messaging;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.ActiveProfiles;

import java.time.Duration;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = {"consulta.credito"})
@ActiveProfiles("test")
public class CreditoKafkaIntegrationTest {

    private static final String TOPIC = "consulta.credito";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private EmbeddedKafkaBroker embeddedKafka;

    @Test
    void devePublicarEventoKafka() {
        String mensagemEsperada = "{\"evento\":\"consulta\"}";

        // Publica
        kafkaTemplate.send(TOPIC, mensagemEsperada);

        // Consome
        Map<String, Object> props = KafkaTestUtils.consumerProps("testGroup", "true", embeddedKafka);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        Consumer<String, String> consumer = new DefaultKafkaConsumerFactory<>(
                props, new StringDeserializer(), new StringDeserializer()
        ).createConsumer();

        embeddedKafka.consumeFromAnEmbeddedTopic(consumer, TOPIC);

        ConsumerRecord<String, String> record = KafkaTestUtils.getSingleRecord(consumer, TOPIC, 60000);

        assertThat(record).isNotNull();
        assertThat(record.value()).isEqualTo(mensagemEsperada);
    }
}
