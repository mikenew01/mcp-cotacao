package com.github.maikoncanuto.quotes.resources;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/cotacoes")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Tag(name = "Cotações", description = "Endpoints para acessar informações das cotações de moedas no sistema monetário")
public interface ICotacaoResource {

    @GET
    @Path("cotacao-dolar-dia/{dataCotacao}")
    @Timeout
    @Retry
    @Operation(
            description = "Buscar informação da cotação do dolar para a data informada",
            operationId = "idCotacaoDolarDia",
            summary = "Buscar informação da cotação por data"
    )
    @APIResponse(name = "OK", responseCode = "200", description = "Requisição completada com sucesso")
    @APIResponse(name = "Internal Server Error", responseCode = "500", description = "Ocorreu um problema interno no servidor")
    public Response findCotacaoDolarDiaByDate(@PathParam("dataCotacao") @NotNull final String dataCotacao);

    @GET
    @Path("cotacao-dolar-periodo")
    @Timeout
    @Retry
    @Operation(
            description = "Buscar informação da cotação do dolar com data inicial e data final",
            operationId = "idCotacaoDolarPeriodo",
            summary = "Buscar informação da cotação por período"
    )
    @APIResponse(name = "OK", responseCode = "200", description = "Requisição completada com sucesso")
    @APIResponse(name = "Internal Server Error", responseCode = "500", description = "Ocorreu um problema interno no servidor")
    public Response findCotacaoDolarPeriodoByDataInicialAndDataFinal(@QueryParam("dataInicial") @NotNull final String dataInicial,
                                                                     @QueryParam("dataFinal") @NotNull final String dataFinal);

    @GET
    @Path("cotacao-moeda-dia")
    @Timeout
    @Retry
    @Operation(
            description = "Buscar informação da cotação para moeda e data informados",
            operationId = "idCotacaoMoedaDiaDataCotacao",
            summary = "Buscar informação da cotação para moeda por data"
    )
    @APIResponse(name = "OK", responseCode = "200", description = "Requisição completada com sucesso")
    @APIResponse(name = "Internal Server Error", responseCode = "500", description = "Ocorreu um problema interno no servidor")
    public Response findCotacaoMoedaDiaByMoedaAndDataCotacao(@QueryParam("dataCotacao") @NotNull final String dataCotacao,
                                                             @QueryParam("simboloMoeda") @NotNull final String simbolMoeda);

    @GET
    @Path("cotacao-moeda-periodo")
    @Timeout
    @Retry
    @Operation(
            description = "Buscar informação da cotação para moeda pelo período informado",
            operationId = "idCotacaoMoedaPorPeriodo",
            summary = "Buscar informação da cotação para moeda por período"
    )
    @APIResponse(name = "OK", responseCode = "200", description = "Requisição completada com sucesso")
    @APIResponse(name = "Internal Server Error", responseCode = "500", description = "Ocorreu um problema interno no servidor")
    public Response findCotacaoMoedaPeriodoByMoedaAndDataInicialAndDataFinal(@QueryParam("simboloMoeda") @NotNull final String simboloMoeda,
                                                                             @QueryParam("dataInicial") @NotNull final String dataInicial,
                                                                             @QueryParam("dataFinal") @NotNull final String dataFinal);

    @GET
    @Path("cotacao-moeda-abertura")
    @Timeout
    @Retry
    @Operation(
            description = "Buscar informação da abertura de cotação para moeda na data informada",
            operationId = "idAberturaCotacaoMoeda",
            summary = "Buscar informação da abertura de cotação para moeda por data"
    )
    @APIResponse(name = "OK", responseCode = "200", description = "Requisição completada com sucesso")
    @APIResponse(name = "Internal Server Error", responseCode = "500", description = "Ocorreu um problema interno no servidor")
    public Response findCotacaoMoedaAberturaOuIntermediarioByCodigoMoedaAndDataCotacao(@QueryParam("simboloMoeda") @NotNull final String simboloMoeda,
                                                                                       @QueryParam("dataCotacao") @NotNull final String dataCotacao);

    @GET
    @Path("cotacao-moeda-periodo-fechamento")
    @Timeout
    @Retry
    @Operation(
            description = "Buscar informação de fechamento da cotação para moeda no período informado",
            operationId = "idFechamentoCotacao",
            summary = "Buscar informação do fechamento de cotação para moeda por período"
    )
    @APIResponse(name = "OK", responseCode = "200", description = "Requisição completada com sucesso")
    @APIResponse(name = "Internal Server Error", responseCode = "500", description = "Ocorreu um problema interno no servidor")
    public Response findCotacaoMoedaPeriodoFechamento(@QueryParam("simboloMoeda") @NotNull final String simboloMoeda,
                                                      @QueryParam("dataInicial") @NotNull final String dataInicial,
                                                      @QueryParam("dataFinal") @NotNull final String dataFinal);
}
