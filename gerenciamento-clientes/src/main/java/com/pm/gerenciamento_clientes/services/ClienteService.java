package com.pm.gerenciamento_clientes.services;

import com.pm.gerenciamento_clientes.models.ClienteModel;
import com.pm.gerenciamento_clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> findAll(){ return clienteRepository.findAll();}
    public Optional<ClienteModel> findById(Long id) {
        return clienteRepository.findById(id);
    }
    public ClienteModel criarCliente(ClienteModel cliente) { return clienteRepository.save(cliente); }
    public ClienteModel atualizarCliente(ClienteModel cliente, Long id) {
        ClienteModel clienteAtualizado = clienteRepository.findById(id).get();
        clienteAtualizado.setNome(cliente.getNome());
        return clienteRepository.save(clienteAtualizado);
    }
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
