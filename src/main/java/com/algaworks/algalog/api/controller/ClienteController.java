package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping(value = "/clientes")
    public List<Cliente> listar(){
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Marcos");
        cliente1.setTelefone("99987841");
        cliente1.setEmail("marcosrebelo9@gmail.com");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Rita");
        cliente2.setTelefone("517841471");
        cliente2.setEmail("rita@gmail.com");
        
        return Arrays.asList(cliente1, cliente2);
    }
}
