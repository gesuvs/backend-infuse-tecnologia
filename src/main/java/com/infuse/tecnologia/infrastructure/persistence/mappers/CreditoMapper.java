package com.infuse.tecnologia.infrastructure.persistence.mappers;

import com.infuse.tecnologia.domain.entities.Credito;
import com.infuse.tecnologia.infrastructure.persistence.entities.CreditoJpaEntity;

public class CreditoMapper {

    public Credito toDomain(CreditoJpaEntity entity) {
        return new Credito
                .Builder()
                .numeroCredito(entity.getNumeroCredito())
                .numeroNfse(entity.getNumeroNfse())
                .dataConstituicao(entity.getDataConstituicao())
                .valorIssqn(entity.getValorIssqn())
                .tipoCredito(entity.getTipoCredito())
                .simplesNacional(entity.isSimplesNacional())
                .aliquota(entity.getAliquota())
                .valorFaturado(entity.getValorFaturado())
                .valorDeducao(entity.getValorDeducao())
                .baseCalculo(entity.getBaseCalculo())
                .build();
    }
}
