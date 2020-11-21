package com.github.maikoncanuto.quotes.resources;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/moedas")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Tag(name = "Moedas", description = "Endpoints para acessar informações de moedas no sistema monetário")
public interface IMoedaResource {

    @GET
    @Timeout
    @Retry
    @Operation(
            description = "Buscar todas os tipos de moedas no sistema monetário do Bacen",
            operationId = "moedas#findAll",
            summary = "Buscar todas os tipos de moedas"
    )
    @APIResponse(name = "OK", responseCode = "200", description = "Requisição completada com sucesso")
    @APIResponse(name = "Internal Server Error", responseCode = "500", description = "Ocorreu um problema interno no servidor")
    public Response findAll();


}
