package com.infuse.tecnologia.infrastructure.persistence.repositories;

import com.infuse.tecnologia.infrastructure.persistence.entities.CreditoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditoJpaRepository extends JpaRepository<CreditoJpaEntity, Long> {

    List<CreditoJpaEntity> findByNumeroNfse(String numeroNfse);

    Optional<CreditoJpaEntity> findByNumeroCredito(String numeroCredito);

}
