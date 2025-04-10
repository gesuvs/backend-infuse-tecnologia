package com.infuse.tecnologia.infrastructure.messaging;

import com.infuse.tecnologia.application.events.CreditoConsultadoEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CreditoEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "consulta-credito";

    public CreditoEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishConsultaEvent(CreditoConsultadoEvent event) {
        kafkaTemplate.send(TOPIC, event.toJson());
    }


}
