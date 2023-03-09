package br.com.ada.locatecar.service;

import br.com.ada.locatecar.model.entities.Cliente;
import br.com.ada.locatecar.repository.LocateCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private LocateCarRepository clienteRepository;

    public void createCliente(Cliente cliente) {
        this.clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return this.clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return this.clienteRepository.findById(id);
    }

    public Optional<Cliente> buscarClientePorCadastro(String cadastro) {
        return this.clienteRepository.findByDocumentoContaining(cadastro);
    }

    public void removerClientePorId(Long id) {
        this.clienteRepository.deleteById(id);
    }
}
