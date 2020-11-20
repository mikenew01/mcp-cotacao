package com.github.maikoncanuto.quotes.services;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static java.lang.Double.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CotacaoServiceTest {

    private final static String DATA_COTACAO = "'11-05-2020'";
    private final static String DATA_INICIAL = "'01-01-2020'";
    private final static String DATA_FINAL = "'02-01-2020'";
    private final static String SIMBOLO_MOEDA = "'AUD'";

    @Inject
    CotacaoService cotacaoService;

    @Test
    public void testRetornoFindCotacaoDolarDiaByDate() {

        final var cotacaoDolarDia = cotacaoService.findCotacaoDolarDiaByDate(DATA_COTACAO);

        assertNotNull(cotacaoDolarDia);

        final var cotacaoDolar = cotacaoDolarDia.get(0);

        assertNotNull(cotacaoDolarDia);
        assertNotNull(cotacaoDolar.getDataHoraCotacao());
        assertNotNull(cotacaoDolar.getCotacaoCompra());
        assertNotNull(cotacaoDolar.getCotacaoVenda());

        assertEquals(valueOf(5d), cotacaoDolar.getCotacaoCompra());
        assertEquals(valueOf(6d), cotacaoDolar.getCotacaoVenda());
        assertEquals("2020-11-05 13:09:31.961", cotacaoDolar.getDataHoraCotacao());
    }

    @Test
    public void testRetornoFindCotacaoDolarPeriodoByDataInicialAndDataFinal() {
        final var cotacaoDolarPeriodo = cotacaoService.findCotacaoDolarPeriodoByDataInicialAndDataFinal(DATA_INICIAL, DATA_FINAL);

        assertNotNull(cotacaoDolarPeriodo);

        final var cotacao = cotacaoDolarPeriodo.get(0);

        assertNotNull(cotacao);
        assertNotNull(cotacao.getDataHoraCotacao());
        assertNotNull(cotacao.getCotacaoVenda());
        assertNotNull(cotacao.getCotacaoCompra());

        assertEquals(valueOf(4d), cotacao.getCotacaoCompra());
        assertEquals(valueOf(4d), cotacao.getCotacaoVenda());
        assertEquals("2020-01-02 13:11:10.762", cotacao.getDataHoraCotacao());
    }

    @Test
    public void testRetornoFindCotacaoMoedaDiaByMoedaAndDataCotacao() {
        final var cotacaoMoedaDia = cotacaoService.findCotacaoMoedaDiaByMoedaAndDataCotacao(SIMBOLO_MOEDA, DATA_COTACAO);

        assertNotNull(cotacaoMoedaDia);

        final var cotacao = cotacaoMoedaDia.get(0);

        assertNotNull(cotacao);
        assertNotNull(cotacao.getCotacaoCompra());
        assertNotNull(cotacao.getCotacaoVenda());
        assertNotNull(cotacao.getDataHoraCotacao());
        assertNotNull(cotacao.getParidadeCompra());
        assertNotNull(cotacao.getParidadeVenda());
        assertNotNull(cotacao.getTipoBoletim());

        assertEquals(valueOf(0d), cotacao.getParidadeCompra());
        assertEquals(valueOf(0d), cotacao.getParidadeVenda());
        assertEquals(valueOf(4d), cotacao.getCotacaoVenda());
        assertEquals(valueOf(4d), cotacao.getCotacaoCompra());
        assertEquals("Abertura", cotacao.getTipoBoletim());
        assertEquals("2020-11-05 10:09:48.908", cotacao.getDataHoraCotacao());
    }


}
