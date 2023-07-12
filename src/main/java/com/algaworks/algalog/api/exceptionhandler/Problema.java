package com.algaworks.algalog.api.exceptionhandler;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Problema {
    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
}
