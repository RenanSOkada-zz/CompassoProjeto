package com.compasso.productRest.config.validacao;

public class ErroDeFormularioDto {

	private String campo;
	private String mensagemErro;

	public ErroDeFormularioDto(String campo, String mensagemErro) {
		this.campo = campo;
		this.mensagemErro = mensagemErro;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

}
