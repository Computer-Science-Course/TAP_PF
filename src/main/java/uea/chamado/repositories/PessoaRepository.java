package uea.chamado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.chamado.models.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
}

