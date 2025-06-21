package com.exemplo.produtos.repository;

import com.exemplo.produtos.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClienteRepository {
    
    private final List<Cliente> clientes = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    public Cliente save(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId(idGenerator.getAndIncrement());
        }
        clientes.add(cliente);
        return cliente;
    }
    
    public List<Cliente> findAll() {
        return new ArrayList<>(clientes);
    }
}
