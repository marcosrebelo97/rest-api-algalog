package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.dto.OcorrenciaDTO;
import com.algaworks.algalog.api.dto.input.OcorrenciaInput;
import com.algaworks.algalog.api.mapper.OcorrenciaMapper;
import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.service.BuscaEntregaService;
import com.algaworks.algalog.domain.service.RegistroOcorrenciaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/entregas/{id}/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private BuscaEntregaService buscaEntregaService;

    @Autowired
    private RegistroOcorrenciaService registroOcorrenciaService;

    @Autowired
    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDTO registrar(@PathVariable Long id,
                                   @Valid @RequestBody OcorrenciaInput ocorrenciaInput){
        Ocorrencia ocorrenciaRegistrada =
                registroOcorrenciaService.registrar(id, ocorrenciaInput.getDescricao());
        return ocorrenciaMapper.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaDTO> listar(@PathVariable Long id){
        Entrega entrega = buscaEntregaService.buscar(id);
        return ocorrenciaMapper.toCollection(entrega.getOcorrencias());
    }
}
