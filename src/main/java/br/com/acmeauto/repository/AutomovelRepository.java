package br.com.acmeauto.repository;

import br.com.acmeauto.entity.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutomovelRepository extends JpaRepository<Automovel, String> {

    @Query("SELECT a FROM Automovel a WHERE a.placa = ?1")
    public Optional<Automovel> findAutomovelByPlaca(String placa);
}
