
package com.tienda.controller;



//import java.util.Date;
import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizando MVC");

        var clientes = clienteService.getClientes();
        //var clientes = Arrays.asList();
        model.addAttribute("clientes", clientes);
        return "index";
    }
    
}
