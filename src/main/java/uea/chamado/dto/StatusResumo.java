package uea.chamado.dto;

import java.io.Serializable;

import uea.chamado.models.StatusOrdemServico;

public class StatusResumo implements Serializable {

	private static final long serialVersionUID = 1L;

	private StatusOrdemServico status;

	public StatusResumo() {
	}

	public StatusResumo(StatusOrdemServico status) {
		super();
		this.status = status;
	}

	public StatusOrdemServico getStatus() {
		return status;
	}

	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}

}
