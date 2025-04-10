package com.infuse.tecnologia.application.usecases;

import com.infuse.tecnologia.application.events.CreditoConsultadoEvent;
import com.infuse.tecnologia.domain.entities.Credito;
import com.infuse.tecnologia.domain.repositories.CreditoRepository;
import com.infuse.tecnologia.infrastructure.messaging.CreditoEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarCreditoPorNumeroUseCase {

    private final CreditoRepository repository;
    private final CreditoEventPublisher eventPublisher;

    public BuscarCreditoPorNumeroUseCase(
            CreditoRepository repository,
            CreditoEventPublisher eventPublisher) {

        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public Optional<Credito> execute(String numeroCredito) {
        eventPublisher.publishConsultaEvent(new CreditoConsultadoEvent("POR_NUMERO_CREDITO", numeroCredito));
        return repository.findByNumeroCredito(numeroCredito);
    }

}
