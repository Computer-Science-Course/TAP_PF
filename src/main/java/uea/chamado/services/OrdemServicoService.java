package uea.chamado.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.chamado.dto.ResumoOrdemDto;
import uea.chamado.dto.StatusResumo;
import uea.chamado.models.OrdemServico;
import uea.chamado.repositories.OrdemServicoRepository;
import uea.chamado.repositories.PessoaRepository;
import uea.chamado.repositories.filters.OrdemFilter;
import uea.chamado.services.exceptions.PessoaNotFoundException;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<ResumoOrdemDto> filtrar(OrdemFilter ordemFilter) {

		return null;
	}
	
	public List<ResumoOrdemDto> resumir(OrdemFilter ordemFilter) {
		return ordemServicoRepository.filtrar(ordemFilter);
	}

	public List<OrdemServico> listar() {
		return ordemServicoRepository.findAll();
	}
	
	public OrdemServico buscarPorCodigo(Long codigo) {
		OrdemServico OrdemServico = ordemServicoRepository.findById(codigo).orElseThrow();
		return OrdemServico;
	}
	
	public OrdemServico criar(OrdemServico ordemServico) {
		pessoaRepository.findById(ordemServico.getPessoa().getCodigo()).orElseThrow(
				() -> new PessoaNotFoundException()
		);
		return ordemServicoRepository.save(ordemServico);
	}

	public void excluir(Long codigo) {
		ordemServicoRepository.deleteById(codigo);

	}

	public OrdemServico atualizar(Long codigo, OrdemServico ordemServico) {
		OrdemServico ordemServicoSalva = ordemServicoRepository.findById(codigo).orElseThrow();
		pessoaRepository.findById(ordemServico.getPessoa().getCodigo()).orElseThrow(
				() -> new PessoaNotFoundException()
		);
		BeanUtils.copyProperties(ordemServico, ordemServicoSalva, "codigo");
		return ordemServicoRepository.save(ordemServicoSalva);
	}
	
	public OrdemServico atualizarStatus(Long codigo, StatusResumo status) {
		OrdemServico ordemServicoSalva = ordemServicoRepository.findById(codigo).orElseThrow();
		ordemServicoSalva.setStatus(status.getStatus());
		return ordemServicoRepository.save(ordemServicoSalva);
	}
}

