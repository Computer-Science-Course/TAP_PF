package uea.chamado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.chamado.models.OrdemServico;
import uea.chamado.repositories.ordem.OrdemRepositoryQuery;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>, OrdemRepositoryQuery{
}

