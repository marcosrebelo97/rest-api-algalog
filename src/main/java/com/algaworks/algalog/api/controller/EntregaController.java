package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.dto.DestinatarioDTO;
import com.algaworks.algalog.api.dto.EntregaDTO;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.EntregaService;
import com.algaworks.algalog.domain.model.Entrega;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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

    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitarEntrega(@Valid @RequestBody Entrega entrega){

        return entregaService.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> listar(){
        return entregaRepository.findAll();
    }

    @GetMapping(value = "/{entregaId}")
    public ResponseEntity<EntregaDTO> buscar(@PathVariable Long id){
        return entregaRepository.findById(id)
                .map(entrega -> {
                    EntregaDTO entregaDTO = modelMapper.map(entrega, EntregaDTO.class);

                    return ResponseEntity.ok(entregaDTO);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
