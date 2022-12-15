package br.com.rest.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cotacao {


    private String cotacaoCompra;
    private String cotacaoVenda;
    private String dataHoraCotacao;
}
