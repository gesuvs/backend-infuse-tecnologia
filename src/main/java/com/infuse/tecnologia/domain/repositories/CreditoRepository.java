package com.infuse.tecnologia.domain.repositories;

import com.infuse.tecnologia.domain.entities.Credito;

import java.util.List;
import java.util.Optional;

public interface CreditoRepository {

    List<Credito> findByNumeroNfse(String numeroNfse);

    Optional<Credito> findByNumeroCredito(String numeroCredito);

}
