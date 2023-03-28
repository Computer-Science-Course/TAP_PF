package uea.chamado.dto;

import java.time.LocalDateTime;

import uea.chamado.models.StatusOrdemServico;

public class ResumoOrdemDto {

	private String descricao;
	private StatusOrdemServico status;
	private LocalDateTime dataSolicitacao;
	private LocalDateTime dataFinalizado;
	private String servicoRealizado;

	public ResumoOrdemDto() {

	}

	public ResumoOrdemDto(String descricao, StatusOrdemServico status, LocalDateTime dataSolicitacao,
			LocalDateTime dataFinalizado, String servicoRealizado) {
		super();
		this.descricao = descricao;
		this.status = status;
		this.dataSolicitacao = dataSolicitacao;
		this.dataFinalizado = dataFinalizado;
		this.servicoRealizado = servicoRealizado;
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
	
	

}
