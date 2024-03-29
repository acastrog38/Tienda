
package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.dao.CreditoDao;
import com.tienda.domain.Cliente;
import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    ClienteDao clienteDao;
    
    @Autowired
    CreditoDao creditoDao;
    
    
    @Override
    @Transactional(readOnly = true)  //Para manejar de lectura
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
    
    
    @Override
    @Transactional
    public void save(Cliente cliente) { //Metodo abarca 2 escenarios, si existe, y si no existe
        Credito credito = cliente.getCredito();
        credito  = creditoDao.save(credito);
        
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }
    
    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }

    @Override
    public List<Cliente> getClienteCorreo(String correo) {
        return (List<Cliente>)clienteDao.findByCorreo(correo);
    }

    @Override
    public List<Cliente> getClienteNombreApellidos(String nombre, String apellidos) {
        return (List<Cliente>)clienteDao.findByNombreOrApellidos(nombre, apellidos);
    }
    
}
