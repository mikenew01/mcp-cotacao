package com.github.maikoncanuto.quotes.resources.impl;


import com.github.maikoncanuto.quotes.resources.ICotacaoResource;
import com.github.maikoncanuto.quotes.resources.config.BaseResource;
import com.github.maikoncanuto.quotes.services.CotacaoService;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;


public class CotacaoResourceImpl extends BaseResource implements ICotacaoResource {

    @Inject
    CotacaoService cotacaoService;

    @Override
    @Timed(name = "timed/cotacao-dolar-dia")
    @Counted(name = "counted/cotacao-dolar-dia")
    public Response findCotacaoDolarDiaByDate(final String dataCotacao) {
        final var cotacaoDolarDia = cotacaoService.findCotacaoDolarDiaByDate(dataCotacao);
        return toResponse(OK, cotacaoDolarDia);
    }

    @Override
    @Timed(name = "timed/cotacao-dolar-periodo")
    @Counted(name = "counted/cotacao-dolar-periodo")
    public Response findCotacaoDolarPeriodoByDataInicialAndDataFinal(final String dataInicial, final String dataFinal) {
        final var cotacaoDolarPeriodo = cotacaoService.findCotacaoDolarPeriodoByDataInicialAndDataFinal(dataInicial, dataFinal);
        return toResponse(OK, cotacaoDolarPeriodo);
    }

    @Override
    @Timed(name = "timed/cotacao-moeda-dia")
    @Counted(name = "counted/cotacao-moeda-dia")
    public Response findCotacaoMoedaDiaByMoedaAndDataCotacao(final String dataCotacao, final String simbolMoeda) {
        final var cotacaoMoedaDia = cotacaoService.findCotacaoMoedaDiaByMoedaAndDataCotacao(simbolMoeda, dataCotacao);
        return toResponse(OK, cotacaoMoedaDia);
    }

    @Override
    @Timed(name = "timed/cotacao-moeda-periodo")
    @Counted(name = "counted/cotacao-moeda-periodo")
    public Response findCotacaoMoedaPeriodoByMoedaAndDataInicialAndDataFinal(final String simboloMoeda, final String dataInicial, final String dataFinal) {
        final var cotacaoMoedaPeriodo = cotacaoService.findCotacaoMoedaPeriodoByMoedaAndDataInicialAndDataFinal(simboloMoeda, dataInicial, dataFinal);
        return toResponse(OK, cotacaoMoedaPeriodo);
    }

    @Override
    @Timed(name = "timed/cotacao-moeda-abertura")
    @Counted(name = "counted/cotacao-moeda-abertura")
    public Response findCotacaoMoedaAberturaOuIntermediarioByCodigoMoedaAndDataCotacao(final String simboloMoeda, final String dataCotacao) {
        final var cotacaoMoedaAbertura = cotacaoService.findCotacaoMoedaAberturaOuIntermediarioByCodigoMoedaAndDataCotacao(simboloMoeda, dataCotacao);
        return toResponse(OK, cotacaoMoedaAbertura);
    }

    @Override
    @Timed(name = "timed/cotacao-moeda-periodo-fechamento")
    @Counted(name = "counted/cotacao-moeda-periodo-fechamento")
    public Response findCotacaoMoedaPeriodoFechamento(final String simboloMoeda, final String dataInicial, final String dataFinal) {
        final var cotacaoMoedaPeriodoFechamento = cotacaoService.findCotacaoMoedaPeriodoFechamento(simboloMoeda, dataInicial, dataFinal);
        return toResponse(OK, cotacaoMoedaPeriodoFechamento);
    }

}
