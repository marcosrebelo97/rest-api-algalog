package com.algaworks.algalog.api.mapper;

import com.algaworks.algalog.api.dto.OcorrenciaDTO;
import com.algaworks.algalog.domain.model.Ocorrencia;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {

    private ModelMapper modelMapper;

    public OcorrenciaDTO toModel(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
    }

    public List<OcorrenciaDTO> toCollection(List<Ocorrencia> ocorrencias){
        return ocorrencias.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
