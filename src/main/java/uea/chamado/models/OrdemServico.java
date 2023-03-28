package uea.chamado.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class OrdemServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotBlank(message = "Você deve informar a descricao.")
	private String descricao;

	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusOrdemServico status;

	@NotNull
	private LocalDateTime dataSolicitacao;

	private LocalDateTime dataFinalizado;

	@NotBlank(message = "Você deve informar o servico realizado.")
	private String servicoRealizado;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_pessoa")
	private Pessoa pessoa;

	public OrdemServico() {
	}

	public OrdemServico(Long codigo, String descricao, @NotNull StatusOrdemServico status,
			@NotNull LocalDateTime dataSolicitacao, LocalDateTime dataFinalizado, String servicoRealizado,
			Pessoa pessoa) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.status = status;
		this.dataSolicitacao = dataSolicitacao;
		this.dataFinalizado = dataFinalizado;
		this.servicoRealizado = servicoRealizado;
		this.pessoa = pessoa;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusOrdemServico getStatus() {
		return status;
	}

	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}

	public LocalDateTime getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public LocalDateTime getDataFinalizado() {
		return dataFinalizado;
	}

	public void setDataFinalizado(LocalDateTime dataFinalizado) {
		this.dataFinalizado = dataFinalizado;
	}

	public String getServicoRealizado() {
		return servicoRealizado;
	}

	public void setServicoRealizado(String servicoRealizado) {
		this.servicoRealizado = servicoRealizado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
