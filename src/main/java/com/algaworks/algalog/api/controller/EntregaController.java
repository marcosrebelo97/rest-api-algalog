package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.dto.DestinatarioDTO;
import com.algaworks.algalog.api.dto.EntregaDTO;
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
                    EntregaDTO entregaDTO = new EntregaDTO();
                    entregaDTO.setId(entrega.getId());
                    entregaDTO.setNomeCliente(entrega.getCliente().getNome());
                    entregaDTO.setDestinatario(new DestinatarioDTO());
                    entregaDTO.getDestinatario().setNome(entrega.getDestinatario().getNome());
                    entregaDTO.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
                    entregaDTO.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
                    entregaDTO.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
                    entregaDTO.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
                    entregaDTO.setTaxa(entrega.getTaxa());
                    entregaDTO.setStatus(entrega.getStatus());
                    entregaDTO.setDataPedido(entrega.getDataPedido());
                    entregaDTO.setDataFinalizacao(entrega.getDataFinalizacao());

                    return ResponseEntity.ok(entregaDTO);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
