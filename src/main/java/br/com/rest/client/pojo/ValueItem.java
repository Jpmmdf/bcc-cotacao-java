package br.com.rest.client.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ValueItem{

	@JsonProperty("cotacaoCompra")
	private String cotacaoCompra;

	@JsonProperty("cotacaoVenda")
	private String cotacaoVenda;

	@JsonProperty("dataHoraCotacao")
	private String dataHoraCotacao;

}