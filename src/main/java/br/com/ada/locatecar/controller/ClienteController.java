package br.com.ada.locatecar.controller;

import br.com.ada.locatecar.model.entities.Cliente;
import br.com.ada.locatecar.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente/add")
    public String criarCliente(@Valid
                                   @ModelAttribute("cliente") Cliente cliente,
                               BindingResult result,
                               Model model){
        if(result.hasErrors()){
            return addCliente(model, cliente);
        }
        this.clienteService.criarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes")
    public String clientes(Model model){
        List<Cliente> clientes = this.clienteService.listarTodos();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/cliente/add")
    public String addCliente(Model model, Cliente cliente){
        model.addAttribute("cliente", Objects.nonNull(cliente) ? cliente : new Cliente());
        model.addAttribute("add", Boolean.TRUE);
        return "cliente-add";
    }

    @GetMapping("/cliente/{clienteId}/edit")
    public String editarClienteBuscado(Model model, @PathVariable("clienteId") Long clienteId) {
        Optional<Cliente> clienteBuscado = this.clienteService.buscarClientePorId(clienteId);
        clienteBuscado.ifPresent(cliente -> model.addAttribute("cliente", cliente));
        model.addAttribute("add", Boolean.FALSE);
        return "cliente-add";
    }

    @PutMapping("/cliente/{clienteId}/edit")
    public String editarCliente(@Valid
                                    @ModelAttribute("cliente") Cliente cliente,
                                @PathVariable("clienteId") Long clienteId,
                                BindingResult result,
                                Model model) {
        if(result.hasErrors()){
            //TODO
        }

        cliente.setId(clienteId);
        this.clienteService.criarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/cliente/{clienteId}/delete")
    public String deletarCliente(@PathVariable("clienteId") Long clienteId) {
        this.clienteService.removerClientePorId(clienteId);
        return "redirect:/clientes";
    }

}
