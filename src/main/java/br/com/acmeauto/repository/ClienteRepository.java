package br.com.acmeauto.repository;

import br.com.acmeauto.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query("SELECT c FROM Cliente c WHERE c.cpf = ?1")
    public Optional<Cliente> findClienteByCpf(String cpf);
}