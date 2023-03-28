package uea.chamado.repositories.ordem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import uea.chamado.dto.ResumoOrdemDto;
import uea.chamado.models.OrdemServico;
import uea.chamado.repositories.filters.OrdemFilter;

public class OrdemRepositoryQueryImpl implements OrdemRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<ResumoOrdemDto> filtrar(OrdemFilter ordemFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();

		CriteriaQuery<ResumoOrdemDto> criteria = builder.createQuery(ResumoOrdemDto.class);
		Root<OrdemServico> root = criteria.from(OrdemServico.class);

		criteria.select(builder.construct(ResumoOrdemDto.class, root.get("descricao"), root.get("status"),
				root.get("dataSolicitacao"), root.get("dataFinalizado"), root.get("servicoRealizado")));

		Predicate[] predicates = criarRestricoes(ordemFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		List<ResumoOrdemDto> returnList = manager.createQuery(criteria).getResultList();

		return returnList;
	}

	private Predicate[] criarRestricoes(OrdemFilter ordemFilter, CriteriaBuilder builder, Root<OrdemServico> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!ObjectUtils.isEmpty(ordemFilter.getStatus())) {
			predicates.add(builder.like(builder.lower(root.get("status")),
					"%" + ordemFilter.getStatus().toLowerCase() + "%"));
		}
		if (!ObjectUtils.isEmpty(ordemFilter.getDescricao())) {
			predicates.add(builder.like(builder.lower(root.get("descricao")),
					"%" + ordemFilter.getDescricao().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
