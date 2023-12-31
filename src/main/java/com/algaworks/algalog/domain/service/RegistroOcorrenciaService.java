package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    @Autowired
    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long id, String descricao){
        Entrega entrega = buscaEntregaService.buscar(id);
        return entrega.adicionarOcorrencia(descricao);
    }
}
