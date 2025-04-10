package com.infuse.tecnologia.infrastructure.persistence.entities;

import com.infuse.tecnologia.domain.entities.Credito;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "credito")
public class CreditoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCredito;
    private String numeroNfse;
    private LocalDate dataConstituicao;
    private BigDecimal valorIssqn;
    private String tipoCredito;
    private boolean simplesNacional;
    private BigDecimal aliquota;
    private BigDecimal valorFaturado;
    private BigDecimal valorDeducao;
    private BigDecimal baseCalculo;

    private CreditoJpaEntity(CreditoJpaEntity.Builder builder) {
        this.numeroCredito = builder.numeroCredito;
        this.numeroNfse = builder.numeroNfse;
        this.dataConstituicao = builder.dataConstituicao;
        this.valorIssqn = builder.valorIssqn;
        this.tipoCredito = builder.tipoCredito;
        this.simplesNacional = builder.simplesNacional;
        this.aliquota = builder.aliquota;
        this.valorFaturado = builder.valorFaturado;
        this.valorDeducao = builder.valorDeducao;
        this.baseCalculo = builder.baseCalculo;
    }

    public CreditoJpaEntity() {

    }


    public static class Builder {
        private String numeroCredito;
        private String numeroNfse;
        private LocalDate dataConstituicao;
        private BigDecimal valorIssqn;
        private String tipoCredito;
        private boolean simplesNacional;
        private BigDecimal aliquota;
        private BigDecimal valorFaturado;
        private BigDecimal valorDeducao;
        private BigDecimal baseCalculo;

        public CreditoJpaEntity.Builder numeroCredito(String numeroCredito) {
            this.numeroCredito = numeroCredito;
            return this;
        }

        public CreditoJpaEntity.Builder numeroNfse(String numeroNfse) {
            this.numeroNfse = numeroNfse;
            return this;
        }

        public CreditoJpaEntity.Builder dataConstituicao(LocalDate dataConstituicao) {
            this.dataConstituicao = dataConstituicao;
            return this;
        }

        public CreditoJpaEntity.Builder valorIssqn(BigDecimal valorIssqn) {
            this.valorIssqn = valorIssqn;
            return this;
        }

        public CreditoJpaEntity.Builder tipoCredito(String tipoCredito) {
            this.tipoCredito = tipoCredito;
            return this;
        }

        public CreditoJpaEntity.Builder simplesNacional(boolean simplesNacional) {
            this.simplesNacional = simplesNacional;
            return this;
        }

        public CreditoJpaEntity.Builder aliquota(BigDecimal aliquota) {
            this.aliquota = aliquota;
            return this;
        }

        public CreditoJpaEntity.Builder valorFaturado(BigDecimal valorFaturado) {
            this.valorFaturado = valorFaturado;
            return this;
        }

        public CreditoJpaEntity.Builder valorDeducao(BigDecimal valorDeducao) {
            this.valorDeducao = valorDeducao;
            return this;
        }

        public CreditoJpaEntity.Builder baseCalculo(BigDecimal baseCalculo) {
            this.baseCalculo = baseCalculo;
            return this;
        }

        public CreditoJpaEntity build() {
            return new CreditoJpaEntity(this);
        }
    }


    public Long getId() {
        return id;
    }

    public String getNumeroCredito() {
        return numeroCredito;
    }

    public String getNumeroNfse() {
        return numeroNfse;
    }

    public LocalDate getDataConstituicao() {
        return dataConstituicao;
    }

    public BigDecimal getValorIssqn() {
        return valorIssqn;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public boolean isSimplesNacional() {
        return simplesNacional;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public BigDecimal getValorFaturado() {
        return valorFaturado;
    }

    public BigDecimal getValorDeducao() {
        return valorDeducao;
    }

    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }
}
