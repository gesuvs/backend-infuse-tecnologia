package com.infuse.tecnologia.infrastructure.persistence.adapters;

import com.infuse.tecnologia.domain.entities.Credito;
import com.infuse.tecnologia.infrastructure.persistence.entities.CreditoJpaEntity;
import com.infuse.tecnologia.infrastructure.persistence.repositories.CreditoJpaRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreditoRepositoryImplTest {

    @Test
    public void deveBuscarCreditoPorNumero() {
        CreditoJpaRepository jpaRepository = mock(CreditoJpaRepository.class);
        CreditoRepositoryImpl repository = new CreditoRepositoryImpl(jpaRepository);

        CreditoJpaEntity entity = new CreditoJpaEntity.Builder()
                .numeroCredito("123456")
                .numeroNfse("7891011")
                .dataConstituicao(LocalDate.of(2024, 2, 25))
                .valorIssqn(new BigDecimal("1500.75"))
                .tipoCredito("ISSQN")
                .simplesNacional(true)
                .aliquota(new BigDecimal("5.0"))
                .valorFaturado(new BigDecimal("30000.00"))
                .valorDeducao(new BigDecimal("5000.00"))
                .baseCalculo(new BigDecimal("25000.00"))
                .build();

        when(jpaRepository.findByNumeroCredito("123456")).thenReturn(Optional.of(entity));

        Optional<Credito> resultado = repository.findByNumeroCredito("123456");

        assertTrue(resultado.isPresent());
        assertEquals("123456", resultado.get().getNumeroCredito());
    }

    @Test
    void deveRetornarListaVazia_QuandoNaoExistirCreditoParaNumeroNfse() {

        CreditoJpaRepository jpaRepository = mock(CreditoJpaRepository.class);

        // given
        String numeroNfse = "0000000";
        when(jpaRepository.findByNumeroNfse(numeroNfse)).thenReturn(Collections.emptyList());

        // when
        List<CreditoJpaEntity> creditos = jpaRepository.findByNumeroNfse(numeroNfse);

        // then
        assertNotNull(creditos);
        assertTrue(creditos.isEmpty());
    }

}
