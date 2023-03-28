package uea.chamado.repositories.ordem;

import java.util.List;

import uea.chamado.dto.ResumoOrdemDto;
import uea.chamado.repositories.filters.OrdemFilter;

public interface OrdemRepositoryQuery {
	public List<ResumoOrdemDto> filtrar(
			OrdemFilter ordemFilter);
}
