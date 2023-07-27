package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.dto.EntregaDTO;
import com.algaworks.algalog.api.mapper.EntregaMapper;
import com.algaworks.algalog.api.dto.input.EntregaInput;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.EntregaService;
import com.algaworks.algalog.domain.model.Entrega;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private EntregaService entregaService;

    private EntregaMapper entregaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDTO solicitarEntrega(@Valid @RequestBody EntregaInput entregaInput){
        Entrega novaEntrega = entregaMapper.toEntity(entregaInput);
        Entrega entregaSolicitada = entregaService.solicitar(novaEntrega);
        return entregaMapper.toModel(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaDTO> listarEntregas(){
        return entregaMapper.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping(value = "/{entregaId}")
    public ResponseEntity<EntregaDTO> buscarEntrega(@PathVariable Long id){
        return entregaRepository.findById(id)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
}
