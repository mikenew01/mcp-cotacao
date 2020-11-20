package com.github.maikoncanuto.quotes.services;


import com.github.maikoncanuto.quotes.core.annotations.Auditoria;
import com.github.maikoncanuto.quotes.domain.dtos.TipoCotacaoDolarAberturaOuIntermediarioDTO;
import com.github.maikoncanuto.quotes.domain.dtos.TipoCotacaoDolarDTO;
import com.github.maikoncanuto.quotes.domain.dtos.TipoCotacaoMoedaDTO;
import com.github.maikoncanuto.quotes.integrations.clients.BacenRestClient;
import io.quarkus.cache.CacheResult;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

import static com.github.maikoncanuto.quotes.core.config.LabelCache.*;
import static java.lang.String.format;

@Auditoria
@ApplicationScoped
public class CotacaoService {

    @Inject
    @RestClient
    BacenRestClient bacenRestClient;

    @CacheResult(cacheName = BACEN_COTACAO_DOLAR_DIA_CACHE)
    public List<TipoCotacaoDolarDTO> findCotacaoDolarDiaByDate(final String date) {
        final var cotacaoDolarDia = bacenRestClient.getCotacaoDolarDia(format("'%s'", date));
        return cotacaoDolarDia.getValue();
    }

    @CacheResult(cacheName = BACEN_COTACAO_DOLAR_PERIODO_CACHE)
    public List<TipoCotacaoDolarDTO> findCotacaoDolarPeriodoByDataInicialAndDataFinal(final String dataInicial,
                                                                                      final String dataFinal) {

        final var cotacoes = bacenRestClient.getCotacaoDolarPeriodo(dataInicial, dataFinal);
        return cotacoes.getValue();
    }

    @CacheResult(cacheName = BACEN_COTACAO_MOEDA_DIA_CACHE)
    public List<TipoCotacaoMoedaDTO> findCotacaoMoedaDiaByMoedaAndDataCotacao(final String moeda,
                                                                              final String dataCotacao) {

        final var cotacoes = bacenRestClient.getCotacaoMoedaDia(moeda, dataCotacao);
        return cotacoes.getValue();
    }

    @CacheResult(cacheName = BACEN_COTACAO_MOEDA_PERIODO_CACHE)
    public List<TipoCotacaoMoedaDTO> findCotacaoMoedaPeriodoByMoedaAndDataInicialAndDataFinal(final String moeda,
                                                                                              final String dataInicial,
                                                                                              final String dataFinal) {

        final var cotacoes = bacenRestClient.getCotacaoMoedaPeriodo(moeda, dataInicial, dataFinal);
        return cotacoes.getValue();
    }

    @CacheResult(cacheName = BACEN_COTACAO_MOEDA_ABERTURA_CACHE)
    public List<TipoCotacaoDolarAberturaOuIntermediarioDTO> findCotacaoMoedaAberturaOuIntermediarioByCodigoMoedaAndDataCotacao(final String codigoMoeda,
                                                                                                                               final String dataCotacao) {

        final var cotacoes = bacenRestClient.getCotacaoMoedaAberturaOuIntermediario(codigoMoeda, dataCotacao);
        return cotacoes.getValue();
    }

    @CacheResult(cacheName = BACEN_COTACAO_MOEDA_FECHAMENTO_CACHE)
    public List<TipoCotacaoDolarAberturaOuIntermediarioDTO> findCotacaoMoedaPeriodoFechamento(final String codigoMoeda,
                                                                                              final String dataInicialCotacao,
                                                                                              final String dataFinalCotacao) {

        final var cotacoes = bacenRestClient.getCotacaoMoedaPeriodoFechamento(codigoMoeda, dataInicialCotacao, dataFinalCotacao);
        return cotacoes.getValue();
    }


}
