package br.com.rest.client.service;

import br.com.rest.client.pojo.ResponseBcc;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


@Path("/odata")
@RegisterRestClient(configKey="cotacao-api")
public interface ExchangeService {

    @GET
    @Path("CotacaoDolarDia(dataCotacao=@dataCotacao)")
    ResponseBcc obterCotacao(@QueryParam("@dataCotacao") String dataCotacao, @QueryParam("format") String formato);
}
