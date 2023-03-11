
package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    ClienteDao clienteDao;
    
    @Transactional(readOnly = true) //Para manejar de lectura
    @Override
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();
    }
    
    
    @Override
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }
    
}
