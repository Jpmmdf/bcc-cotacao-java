package br.com.rest.resource;

import br.com.rest.pojo.Error;
import br.com.rest.service.CambioServico;
import br.com.rest.util.DateUtil;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/exchange")
public class ExchangeResource {


    @Inject
    CambioServico cambioServico;

    @GET
    @Path("/{dataCotacao}")
    public Response obterCotacao(@PathParam String dataCotacao){
        if(!DateUtil.isValid(dataCotacao)){
            return cambioServico.obterCotacao(dataCotacao).map((response) -> Response.ok(response).build()).orElseGet(()-> Response.status(Response.Status.NOT_FOUND).entity(Error.builder().code(Response.Status.NOT_FOUND.getStatusCode()).title("Erro").detail("Não foi possivel recuperar a cotação da data informada").build()).build());
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(Error.builder().code(Response.Status.BAD_REQUEST.getStatusCode()).title("Data invalida").detail("Enviar data no formato dd-MM-yyyy").build()).build();
    }
}
