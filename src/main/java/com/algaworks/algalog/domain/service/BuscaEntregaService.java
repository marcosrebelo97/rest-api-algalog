package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public Entrega buscar(Long id){
        return entregaRepository.findById(id)
                .orElseThrow(() -> new NegocioException("Entrega não encontrada!"));

    }
}
