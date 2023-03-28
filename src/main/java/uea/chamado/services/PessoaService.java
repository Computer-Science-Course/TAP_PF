package uea.chamado.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.chamado.models.Pessoa;
import uea.chamado.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa buscarPorCodigo(Long codigo) {
		Pessoa Pessoa = pessoaRepository.findById(codigo).orElseThrow();
		return Pessoa;
	}
	
	public Pessoa criar(Pessoa Pessoa) {
		return pessoaRepository.save(Pessoa);
	}

	public void excluir(Long codigo) {
		pessoaRepository.findById(codigo).orElseThrow();
		pessoaRepository.deleteById(codigo);

	}

	public Pessoa atualizar(Long codigo, Pessoa Pessoa) {
		Pessoa PessoaSalva = pessoaRepository.findById(codigo).orElseThrow();
		BeanUtils.copyProperties(Pessoa, PessoaSalva, "codigo");
		return pessoaRepository.save(PessoaSalva);
	}
}

