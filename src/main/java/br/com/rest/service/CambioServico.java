package br.com.rest.service;

import br.com.rest.client.pojo.ResponseBcc;
import br.com.rest.client.pojo.ValueItem;
import br.com.rest.client.service.ExchangeService;
import br.com.rest.pojo.Cotacao;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
@ApplicationScoped
public class CambioServico {
    @Inject
    @RestClient
    ExchangeService exchangeService;

    public Optional<Cotacao> obterCotacao(String data){
        Boolean obteveDoBanco = true;

        if(obteveDoBanco){
            ResponseBcc retorno =  exchangeService.obterCotacao(tratarData(data),"json");
            if(retorno != null && !retorno.getValue().isEmpty()){
                ValueItem valueItem = retorno.getValue().get(0);
                return Optional.of(Cotacao.builder().cotacaoCompra(valueItem.getCotacaoCompra()).cotacaoVenda(valueItem.getCotacaoVenda()).dataHoraCotacao(valueItem.getDataHoraCotacao()).build());
            }
        }
        return Optional.empty();
    }

    private String tratarData(String data) {
        String dataParse = "'"+data+"'";
        return dataParse;
    }
}
