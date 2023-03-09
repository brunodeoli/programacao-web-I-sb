package br.com.ada.locatecar.repository;

import br.com.ada.locatecar.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface LocateCarRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByDocumentoContaining(String cadastro);
}
