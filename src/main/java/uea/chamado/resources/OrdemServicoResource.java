package uea.chamado.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import uea.chamado.dto.ResumoOrdemDto;
import uea.chamado.dto.StatusResumo;
import uea.chamado.models.OrdemServico;
import uea.chamado.repositories.filters.OrdemFilter;
import uea.chamado.services.OrdemServicoService;

@RestController
@RequestMapping("/ordens")
public class OrdemServicoResource {

	@Autowired
	private OrdemServicoService OrdemServicoService;

	@GetMapping
	public ResponseEntity<List<ResumoOrdemDto>> listar(OrdemFilter ordemFilter) {
		List<ResumoOrdemDto> OrdemServicos = OrdemServicoService.resumir(ordemFilter);
		return ResponseEntity.ok().body(OrdemServicos);
	}

	@GetMapping(value = "/{codigo}")
	public ResponseEntity<OrdemServico> buscarPorCodigo(@PathVariable Long codigo) {
		OrdemServico OrdemServico = OrdemServicoService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(OrdemServico);
	}

	@PostMapping
	public ResponseEntity<OrdemServico> criar(@Valid @RequestBody OrdemServico OrdemServico) {
		OrdemServico OrdemServicoSalva = OrdemServicoService.criar(OrdemServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(OrdemServicoSalva.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(OrdemServicoSalva);
	}

	@PutMapping(value = "/{codigo}")
	public ResponseEntity<OrdemServico> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody OrdemServico OrdemServico) {
		OrdemServico OrdemServicoSalva = OrdemServicoService.atualizar(codigo, OrdemServico);
		return ResponseEntity.ok().body(OrdemServicoSalva);
	}
	
	@PutMapping(value = "/status/{codigo}")
	public ResponseEntity<OrdemServico> atualizarStatus(@PathVariable Long codigo,
			@Valid @RequestBody StatusResumo status) {
		OrdemServico OrdemServicoSalva = OrdemServicoService.atualizarStatus(codigo, status);
		return ResponseEntity.ok().body(OrdemServicoSalva);
	}

	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo) {
		OrdemServicoService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}
}
