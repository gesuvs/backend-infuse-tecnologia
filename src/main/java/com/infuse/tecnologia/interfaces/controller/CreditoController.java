package com.infuse.tecnologia.interfaces.controller;

import com.infuse.tecnologia.application.usecases.BuscarCreditoPorNumeroUseCase;
import com.infuse.tecnologia.application.usecases.ListarCreditosPorNfseUseCase;
import com.infuse.tecnologia.domain.entities.Credito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    private final ListarCreditosPorNfseUseCase listarUseCase;
    private final BuscarCreditoPorNumeroUseCase buscarUseCase;

    public CreditoController(ListarCreditosPorNfseUseCase listarUseCase,
                             BuscarCreditoPorNumeroUseCase buscarUseCase) {
        this.listarUseCase = listarUseCase;
        this.buscarUseCase = buscarUseCase;
    }

    @GetMapping("/{numeroNfse}")
    public List<Credito> getByNfse(@PathVariable String numeroNfse) {
        return listarUseCase.execute(numeroNfse);
    }

    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<Credito> getByCredito(@PathVariable String numeroCredito) {
        return buscarUseCase.execute(numeroCredito)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
