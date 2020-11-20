package com.github.maikoncanuto.quotes.services;

import com.github.maikoncanuto.quotes.core.exceptions.QuoteBacenIntegrationException;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class MoedaServiceTest {

    @Inject
    MoedaService moedaService;

    @Test
    public void testRetornoFindAllMoedas() throws QuoteBacenIntegrationException {
        final var moedas = moedaService.findAll();

        assertNotNull(moedas);
        assertNotNull(moedas.get(0));
        assertNotNull(moedas.get(0).getSimbolo());
        assertNotNull(moedas.get(0).getTipoMoeda());
        assertNotNull(moedas.get(0).getNomeFormatado());

        assertEquals("AUD", moedas.get(0).getSimbolo());
        assertEquals("B", moedas.get(0).getTipoMoeda());
        assertEquals("Dólar australiano", moedas.get(0).getNomeFormatado());
    }

}
