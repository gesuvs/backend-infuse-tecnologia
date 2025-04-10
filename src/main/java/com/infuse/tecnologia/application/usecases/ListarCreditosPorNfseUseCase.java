package com.infuse.tecnologia.application.usecases;

import com.infuse.tecnologia.application.events.CreditoConsultadoEvent;
import com.infuse.tecnologia.domain.entities.Credito;
import com.infuse.tecnologia.domain.repositories.CreditoRepository;
import com.infuse.tecnologia.infrastructure.messaging.CreditoEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarCreditosPorNfseUseCase {

    private final CreditoRepository repository;
    private final CreditoEventPublisher eventPublisher;


    public ListarCreditosPorNfseUseCase(
            CreditoRepository repository,
            CreditoEventPublisher eventPublisher) {

        this.repository = repository;
        this.eventPublisher = eventPublisher;

    }

    public List<Credito> execute(String numeroNfse) {
        eventPublisher.publishConsultaEvent(new CreditoConsultadoEvent("POR_NUMERO_NFSE", numeroNfse));

        return repository.findByNumeroNfse(numeroNfse);
    }
}
