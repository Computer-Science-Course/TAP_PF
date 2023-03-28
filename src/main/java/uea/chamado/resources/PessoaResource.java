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
import uea.chamado.models.Pessoa;
import uea.chamado.services.PessoaService;


@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService PessoaService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listar(){
		List<Pessoa> Pessoas = PessoaService.listar();
		return ResponseEntity.ok().body(Pessoas);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Pessoa> buscarPorCodigo(@PathVariable Long codigo){
		Pessoa Pessoa = PessoaService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(Pessoa);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa Pessoa){
		Pessoa PessoaSalva = PessoaService.criar(Pessoa);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(PessoaSalva.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(PessoaSalva);
	}
	
	@PutMapping(value="/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo,@Valid @RequestBody Pessoa Pessoa){
		Pessoa PessoaSalva = PessoaService.atualizar(codigo, Pessoa);
		return ResponseEntity.ok().body(PessoaSalva);
	}
	
	@DeleteMapping(value="/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo){
		PessoaService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}
}

