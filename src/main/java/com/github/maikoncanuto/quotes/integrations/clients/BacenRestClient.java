package com.github.maikoncanuto.quotes.integrations.clients;

import com.github.maikoncanuto.quotes.domain.dtos.RespostaTipoCotacaoDolarAberturaOuIntermediarioDTO;
import com.github.maikoncanuto.quotes.domain.dtos.RespostaTipoCotacaoDolarDTO;
import com.github.maikoncanuto.quotes.domain.dtos.RespostaTipoCotacaoMoedaDTO;
import com.github.maikoncanuto.quotes.domain.dtos.RespostaTipoMoedaDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("v1/odata")
@RegisterRestClient
@Produces(APPLICATION_JSON)
public interface BacenRestClient {

    @GET
    @Path("/Moedas")
    RespostaTipoMoedaDTO getMoedas();

    @GET
    @Path("/CotacaoDolarDia(dataCotacao=@dataCotacao)")
    RespostaTipoCotacaoDolarDTO getCotacaoDolarDia(@QueryParam("@dataCotacao") String dataCotacao);

    @GET
    @Path("/CotacaoDolarPeriodo(dataInicial=@dataInicial,dataFinalCotacao=@dataFinalCotacao)")
    RespostaTipoCotacaoDolarDTO getCotacaoDolarPeriodo(@QueryParam("@dataInicial") String dataInicial,
                                                       @QueryParam("dataFinalCotacao") String dataFinalCotacao);

    @GET
    @Path("/CotacaoMoedaDia(moeda=@moeda,dataCotacao=@dataCotacao)")
    RespostaTipoCotacaoMoedaDTO getCotacaoMoedaDia(@QueryParam("@moeda") String moeda,
                                                   @QueryParam("@dataCotacao") String dataCotacao);


    @GET
    @Path("/CotacaoMoedaPeriodo(moeda=@moeda,dataInicial=@dataInicial,dataFinalCotacao=@dataFinalCotacao)")
    RespostaTipoCotacaoMoedaDTO getCotacaoMoedaPeriodo(@QueryParam("@moeda") String moeda,
                                                       @QueryParam("@dataInicial") String dataInicial,
                                                       @QueryParam("@dataFinalCotacao") String dataFinalCotacao);

    @GET
    @Path("/CotacaoMoedaAberturaOuIntermediario(codigoMoeda=@codigoMoeda,dataCotacao=@dataCotacao)")
    RespostaTipoCotacaoDolarAberturaOuIntermediarioDTO getCotacaoMoedaAberturaOuIntermediario(@QueryParam("@codigoMoeda") String codigoMoeda,
                                                                                              @QueryParam("@dataCotacao") String dataCotacao);

    @GET
    @Path("/CotacaoMoedaPeriodoFechamento(codigoMoeda=@codigoMoeda,dataInicialCotacao=@dataInicialCotacao,dataFinalCotacao=@dataFinalCotacao)")
    RespostaTipoCotacaoDolarAberturaOuIntermediarioDTO getCotacaoMoedaPeriodoFechamento(@QueryParam("@codigoMoeda") String codigoMoeda,
                                                                                        @QueryParam("@dataInicialCotacao") String dataInicialCotacao,
                                                                                        @QueryParam("@dataFinalCotacao") String dataFinalCotacao);

}
