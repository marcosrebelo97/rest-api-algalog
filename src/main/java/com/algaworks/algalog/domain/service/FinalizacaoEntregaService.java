package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    @Autowired
    private BuscaEntregaService buscaEntregaService;

    @Autowired
    private EntregaRepository entregaRepository;

    @Transactional
    public void finalizar(Long id){
        Entrega entrega = buscaEntregaService.buscar(id);
        entrega.finalizar();
        entregaRepository.save(entrega);
    }
}
