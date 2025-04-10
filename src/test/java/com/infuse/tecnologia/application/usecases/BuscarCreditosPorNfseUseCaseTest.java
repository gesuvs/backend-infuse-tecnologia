package com.infuse.tecnologia.application.usecases;

import com.infuse.tecnologia.domain.entities.Credito;
import com.infuse.tecnologia.domain.repositories.CreditoRepository;
import com.infuse.tecnologia.infrastructure.messaging.CreditoEventPublisher;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class BuscarCreditosPorNfseUseCaseTest {


    @Test
    public void deveRetornarCreditoQuandoNumeroValido() {

        // Arrange
        CreditoRepository repository = mock(CreditoRepository.class);
        CreditoEventPublisher eventPublisher = mock(CreditoEventPublisher.class);

        BuscarCreditoPorNumeroUseCase useCase = new BuscarCreditoPorNumeroUseCase(repository, eventPublisher);

        Credito credito = new Credito.Builder()
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

        when(repository.findByNumeroCredito("123456")).thenReturn(Optional.of(credito));

        // Act
        Optional<Credito> resultado = useCase.execute("123456");

        // Assert
        assertTrue(resultado.isPresent());
        assertEquals("123456", resultado.get().getNumeroCredito());
        verify(eventPublisher, times(1)).publishConsultaEvent(any());

    }


}
