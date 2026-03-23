package com.pm.gerenciamento_clientes.controller;

import com.pm.gerenciamento_clientes.models.ClienteModel;
import com.pm.gerenciamento_clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll() {
        List<ClienteModel> clientes = clienteService.findAll();
        return ResponseEntity.status(200).body(clientes);
    }

    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel clienteModel) {
        ClienteModel cliente = clienteService.criarCliente(clienteModel);
        return ResponseEntity.status(201).body(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClienteModel>> findById(@PathVariable Long id) {
        Optional<ClienteModel> cliente = clienteService.findById(id);
        return ResponseEntity.status(200).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable Long id, @RequestBody ClienteModel clienteModel) {
        ClienteModel cliente = clienteService.findById(id).get();
        cliente.setNome(clienteModel.getNome());
        return ResponseEntity.status(200).body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.status(204).build();
    }
}

