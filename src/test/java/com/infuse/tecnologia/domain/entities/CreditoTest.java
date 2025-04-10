package com.infuse.tecnologia.domain.entities;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditoTest {

    @Test
    public void deveCriarCreditoComDadosValidos() {
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

        assertEquals("123456", credito.getNumeroCredito());
        assertEquals("7891011", credito.getNumeroNfse());
        assertEquals(new BigDecimal("25000.00"), credito.getBaseCalculo());
    }

}
