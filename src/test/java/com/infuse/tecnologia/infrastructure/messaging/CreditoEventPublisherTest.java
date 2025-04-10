package com.infuse.tecnologia.infrastructure.messaging;

import com.infuse.tecnologia.application.events.CreditoConsultadoEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreditoEventPublisherTest {

    private KafkaTemplate<String, String> kafkaTemplate;
    private CreditoEventPublisher publisher;

    @BeforeEach
    void setUp() {
        kafkaTemplate = Mockito.mock(KafkaTemplate.class);
        publisher = new CreditoEventPublisher(kafkaTemplate);
    }

    @Test
    public void devePublicarEventoDeConsulta() {
        // Arrange
        CreditoConsultadoEvent event = new CreditoConsultadoEvent("POR_NUMERO_NFSE", "7891011");

        // Act
        publisher.publishConsultaEvent(event);

        // Assert
        verify(kafkaTemplate, times(1)).send("consulta-credito", event.toJson());
    }


}
