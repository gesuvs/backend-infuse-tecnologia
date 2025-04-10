package com.infuse.tecnologia.application.events;

import java.time.LocalDateTime;

public class CreditoConsultadoEvent {

    private final String tipoConsulta;
    private final String valorConsulta;
    private final LocalDateTime timestamp;

    public CreditoConsultadoEvent(String tipoConsulta, String valorConsulta) {
        this.tipoConsulta = tipoConsulta;
        this.valorConsulta = valorConsulta;
        this.timestamp = LocalDateTime.now();
    }

    public String toJson() {
        return String.format("{\"tipoConsulta\": \"%s\", \"valorConsulta\": \"%s\", \"timestamp\": \"%s\"}",
                tipoConsulta, valorConsulta, timestamp);
    }

}
