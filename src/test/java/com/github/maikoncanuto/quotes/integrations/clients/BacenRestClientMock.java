package com.github.maikoncanuto.quotes.integrations.clients;

import com.github.maikoncanuto.quotes.domain.dtos.*;
import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

import static java.util.Collections.singletonList;

@Mock
@RestClient
@ApplicationScoped
public class BacenRestClientMock implements BacenRestClient {

    @Override
    public RespostaTipoMoedaDTO getMoedas() {
        final var resposta = new RespostaTipoMoedaDTO();
        final var tipoMoeda = new TipoMoedaDTO();

        tipoMoeda.setNomeFormatado("Dólar australiano");
        tipoMoeda.setSimbolo("AUD");
        tipoMoeda.setTipoMoeda("B");

        resposta.setValue(singletonList(tipoMoeda));
        resposta.setDataContext("https://was-p.bcnet.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata$metadata#Moedas");

        return resposta;
    }

    @Override
    public RespostaTipoCotacaoDolarDTO getCotacaoDolarDia(final String dataCotacao) {
        final var resposta = new RespostaTipoCotacaoDolarDTO();
        final var tipoCotacaoDolar = new TipoCotacaoDolarDTO();

        tipoCotacaoDolar.setCotacaoCompra(5D);
        tipoCotacaoDolar.setCotacaoVenda(6D);
        tipoCotacaoDolar.setDataHoraCotacao("2020-11-05 13:09:31.961");

        resposta.setValue(singletonList(tipoCotacaoDolar));
        resposta.setDataContext("https://was-p.bcnet.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata$metadata#_CotacaoDolarDia");

        return resposta;
    }

    @Override
    public RespostaTipoCotacaoDolarDTO getCotacaoDolarPeriodo(final String dataInicial, final String dataFinalCotacao) {
        final var resposta = new RespostaTipoCotacaoDolarDTO();
        final var tipoCotacaoDolar = new TipoCotacaoDolarDTO();

        tipoCotacaoDolar.setCotacaoVenda(4D);
        tipoCotacaoDolar.setCotacaoCompra(4D);
        tipoCotacaoDolar.setDataHoraCotacao("2020-01-02 13:11:10.762");

        resposta.setValue(singletonList(tipoCotacaoDolar));
        resposta.setDataContext("https://was-p.bcnet.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata$metadata#_CotacaoDolarPeriodo");

        return resposta;
    }

    @Override
    public RespostaTipoCotacaoMoedaDTO getCotacaoMoedaDia(final String moeda, final String dataCotacao) {
        final var resposta = new RespostaTipoCotacaoMoedaDTO();
        final var tipoCotacaoMoeda = new TipoCotacaoMoedaDTO();

        tipoCotacaoMoeda.setCotacaoCompra(4D);
        tipoCotacaoMoeda.setCotacaoVenda(4D);
        tipoCotacaoMoeda.setParidadeCompra(0D);
        tipoCotacaoMoeda.setParidadeVenda(0D);
        tipoCotacaoMoeda.setDataHoraCotacao("2020-11-05 10:09:48.908");
        tipoCotacaoMoeda.setTipoBoletim("Abertura");

        resposta.setValue(singletonList(tipoCotacaoMoeda));
        resposta.setDataContext("https://was-p.bcnet.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata$metadata#_CotacaoMoedaDia");

        return resposta;
    }

    @Override
    public RespostaTipoCotacaoMoedaDTO getCotacaoMoedaPeriodo(final String moeda, final String dataInicial, final String dataFinalCotacao) {
        final var resposta = new RespostaTipoCotacaoMoedaDTO();
        final var tipoCotacaoMoeda = new TipoCotacaoMoedaDTO();

        tipoCotacaoMoeda.setTipoBoletim("Abertura");
        tipoCotacaoMoeda.setDataHoraCotacao("2020-01-02 10:08:18.114");
        tipoCotacaoMoeda.setParidadeVenda(6D);
        tipoCotacaoMoeda.setParidadeCompra(7D);
        tipoCotacaoMoeda.setCotacaoVenda(8D);
        tipoCotacaoMoeda.setCotacaoCompra(9D);

        resposta.setValue(singletonList(tipoCotacaoMoeda));
        resposta.setDataContext("https://was-p.bcnet.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata$metadata#_CotacaoMoedaPeriodo");

        return resposta;
    }

    @Override
    public RespostaTipoCotacaoDolarAberturaOuIntermediarioDTO getCotacaoMoedaAberturaOuIntermediario(final String codigoMoeda, final String dataCotacao) {
        final var resposta = new RespostaTipoCotacaoDolarAberturaOuIntermediarioDTO();
        final var tipoCotacaoDolarAbertura = new TipoCotacaoDolarAberturaOuIntermediarioDTO();

        tipoCotacaoDolarAbertura.setCotacaoCompra(10D);
        tipoCotacaoDolarAbertura.setCotacaoVenda(1D);
        tipoCotacaoDolarAbertura.setDataHoraCotacao("2020-11-05 13:09:31.955");
        tipoCotacaoDolarAbertura.setTipoBoletim("Intermediário");

        resposta.setValue(singletonList(tipoCotacaoDolarAbertura));
        resposta.setDataContext("https://was-p.bcnet.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata$metadata#_CotacaoMoedaAberturaOuIntermediario");

        return resposta;
    }

    @Override
    public RespostaTipoCotacaoDolarAberturaOuIntermediarioDTO getCotacaoMoedaPeriodoFechamento(final String codigoMoeda, final String dataInicialCotacao, final String dataFinalCotacao) {
        final var resposta = new RespostaTipoCotacaoDolarAberturaOuIntermediarioDTO();
        final var tipoCotacaoDolarFechamento = new TipoCotacaoDolarAberturaOuIntermediarioDTO();

        tipoCotacaoDolarFechamento.setCotacaoCompra(2D);
        tipoCotacaoDolarFechamento.setCotacaoVenda(2D);
        tipoCotacaoDolarFechamento.setDataHoraCotacao("2020-01-31 13:10:35.372");
        tipoCotacaoDolarFechamento.setTipoBoletim("Fechamento");

        resposta.setValue(singletonList(tipoCotacaoDolarFechamento));
        resposta.setDataContext("https://was-p.bcnet.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata$metadata#_CotacaoMoedaPeriodoFechamento");

        return resposta;
    }
}
