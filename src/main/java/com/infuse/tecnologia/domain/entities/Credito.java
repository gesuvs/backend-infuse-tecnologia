package com.infuse.tecnologia.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Credito {
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

    private Credito(Builder builder) {
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

        public Builder numeroCredito(String numeroCredito) {
            this.numeroCredito = numeroCredito;
            return this;
        }

        public Builder numeroNfse(String numeroNfse) {
            this.numeroNfse = numeroNfse;
            return this;
        }

        public Builder dataConstituicao(LocalDate dataConstituicao) {
            this.dataConstituicao = dataConstituicao;
            return this;
        }

        public Builder valorIssqn(BigDecimal valorIssqn) {
            this.valorIssqn = valorIssqn;
            return this;
        }

        public Builder tipoCredito(String tipoCredito) {
            this.tipoCredito = tipoCredito;
            return this;
        }

        public Builder simplesNacional(boolean simplesNacional) {
            this.simplesNacional = simplesNacional;
            return this;
        }

        public Builder aliquota(BigDecimal aliquota) {
            this.aliquota = aliquota;
            return this;
        }

        public Builder valorFaturado(BigDecimal valorFaturado) {
            this.valorFaturado = valorFaturado;
            return this;
        }

        public Builder valorDeducao(BigDecimal valorDeducao) {
            this.valorDeducao = valorDeducao;
            return this;
        }

        public Builder baseCalculo(BigDecimal baseCalculo) {
            this.baseCalculo = baseCalculo;
            return this;
        }

        public Credito build() {
            return new Credito(this);
        }
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
