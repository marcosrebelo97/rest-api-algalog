package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Transactional
    public Ocorrencia registrar(Long id, String descricao){
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new NegocioException("Entrega não encontrada!"));

        return entrega.adicionarOcorrencia(descricao);
    }
}
