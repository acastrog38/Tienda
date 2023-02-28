
package com.tienda.controller;



//import java.util.Date;
import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author acast
 */
@Slf4j
@Controller

public class IndexController {
    
    @Autowired
    ClienteDao clienteDao;
    
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizando MVC");
//        String mensaje = "Estamos en semana 4, saludos!";
//        //String fecha = new Date().toString();
//        model.addAttribute("MensajeSaludo", mensaje);
//        //model.addAttribute("fecha", fecha);
//        
//        Cliente cliente = new Cliente("Alejandro", "Castro Garcia", "acastrog38@gmail.com", "85796443");
//        Cliente cliente2 = new Cliente("Fracisco", "Gamboa Araya", "faraya@gmail.com", "87946521");
//        //model.addAttribute("cliente", cliente);
//        
//        List<Cliente> clientes = Arrays.asList(cliente, cliente2);
//        
        var clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
    
}