package com.infuse.tecnologia.infrastructure.persistence.adapters;

import com.infuse.tecnologia.domain.entities.Credito;
import com.infuse.tecnologia.domain.repositories.CreditoRepository;
import com.infuse.tecnologia.infrastructure.persistence.entities.CreditoJpaEntity;
import com.infuse.tecnologia.infrastructure.persistence.mappers.CreditoMapper;
import com.infuse.tecnologia.infrastructure.persistence.repositories.CreditoJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CreditoRepositoryImpl implements CreditoRepository {

    private final CreditoJpaRepository jpaRepository;

    public CreditoRepositoryImpl(CreditoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    @Override
    public List<Credito> findByNumeroNfse(String numeroNfse) {
        return jpaRepository.findByNumeroNfse(numeroNfse)
                .stream()
                .map(creditoJpaEntity -> new CreditoMapper()
                        .toDomain(creditoJpaEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Credito> findByNumeroCredito(String numeroCredito) {
        return jpaRepository.findByNumeroCredito(numeroCredito)
                .map(creditoJpaEntity -> new CreditoMapper()
                        .toDomain(creditoJpaEntity));
    }

}
