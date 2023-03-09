package br.com.ada.locatecar.controller;

import br.com.ada.locatecar.model.entities.Cliente;
import br.com.ada.locatecar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente/add")
    public String criarCliente(@ModelAttribute("cliente") Cliente cliente){
        this.clienteService.createCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes")
    public String clientes(Model model){
        List<Cliente> clientes = this.clienteService.listarTodos();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/cliente/add")
    public String addCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("add", Boolean.TRUE);
        return "cliente-add";
    }

    @GetMapping("/cliente/{clienteId}/edit")
    public String mostrarEdicaoCliente(Model model, @PathVariable("clienteId") Long clienteId) {
        Optional<Cliente> clienteBuscado = this.clienteService.buscarClientePorId(clienteId);
        clienteBuscado.ifPresent(cliente -> model.addAttribute("cliente", cliente));
        model.addAttribute("add", Boolean.FALSE);
        return "cliente-add";
    }

    @PutMapping("/cliente/{clienteId}/edit")
    public String editarCliente(@ModelAttribute("cliente") Cliente cliente,
                                @PathVariable("clienteId") Long clienteId) {
        cliente.setId(clienteId);
        this.clienteService.createCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/cliente/{clienteId}/delete")
    public String deletarCliente(@PathVariable("clienteId") Long clienteId) {
        this.clienteService.removerClientePorId(clienteId);
        return "redirect:/clientes";
    }

}
