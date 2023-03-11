
package com.tienda.service;

import com.tienda.domain.Cliente;
import java.util.List;


public interface ClienteService {
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Cliente cliente);
    
    public void save(Cliente cliente); //Tanto para insertar como modificar
    
    public void delete(Cliente cliente);
    
}
