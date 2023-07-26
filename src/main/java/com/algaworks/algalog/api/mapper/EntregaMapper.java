package com.algaworks.algalog.api.mapper;

import com.algaworks.algalog.api.dto.EntregaDTO;
import com.algaworks.algalog.domain.model.input.EntregaInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.algaworks.algalog.domain.model.Entrega;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaMapper {
    private ModelMapper modelMapper;

    public EntregaDTO toModel(Entrega entrega){
        return modelMapper.map(entrega, EntregaDTO.class);
    }

    public List<EntregaDTO> toCollectionModel(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Entrega toEntity (EntregaInput entregaInput){
        return modelMapper.map(entregaInput, Entrega.class);
    }
}
