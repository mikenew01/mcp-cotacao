package com.github.maikoncanuto.quotes.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.lang.String.valueOf;
import static org.hamcrest.CoreMatchers.*;


@QuarkusTest
public class CotacaoResourceTest {

    private final static String PATH_API = "/api/v1/cotacoes";

    @Test
    public void testRetornoEndpointCotacaoDolarDia() {
        given()
                .pathParam("dataCotacao", "'11-05-2020'")
                .when()
                .get(PATH_API + "/cotacao-dolar-dia/'{dataCotacao}'")
                .then()
                .statusCode(200)
                .body("code", is(valueOf(200)))
                .body("erro", nullValue())
                .body("data", notNullValue())
                .body("data.size()", is(1))
                .body("data[0].dataHoraCotacao", is("2020-11-05 13:09:31.961"));
    }

    @Test
    public void testRetornoEndpointCotacaoDolarPeriodoByDataInicialAndDataFinal() {
        given()
                .queryParam("dataInicial", "'01-01-2020'")
                .queryParam("dataFinal", "'02-01-2020'")
                .when()
                .get(PATH_API + "/cotacao-dolar-periodo")
                .then()
                .statusCode(200)
                .body("code", is(valueOf(200)))
                .body("erro", nullValue())
                .body("data", notNullValue())
                .body("data.size()", is(1))
                .body("data[0].dataHoraCotacao", is("2020-01-02 13:11:10.762"));
    }

    @Test
    public void testRetornoEndpointFindCotacaoMoedaDiaByMoedaAndDataCotacao() {
        given()
                .queryParam("dataCotacao", "'11-05-2020'")
                .queryParam("simboloMoeda", "'AUD'")
                .when()
                .get(PATH_API + "/cotacao-moeda-dia")
                .then()
                .statusCode(200)
                .body("code", is(valueOf(200)))
                .body("erro", nullValue())
                .body("data", notNullValue())
                .body("data.size()", is(1))
                .body("data[0].dataHoraCotacao", is("2020-11-05 10:09:48.908"))
                .body("data[0].tipoBoletim", is("Abertura"));
    }

    @Test
    public void testRetornoEndpointFindCotacaoMoedaPeriodoByMoedaAndDataInicialAndDataFinal() {
        given()
                .queryParam("dataInicial", "'01-01-2020'")
                .queryParam("dataFinal", "'02-01-2020'")
                .queryParam("simboloMoeda", "'AUD'")
                .when()
                .get(PATH_API + "/cotacao-moeda-periodo")
                .then()
                .statusCode(200)
                .body("code", is(valueOf(200)))
                .body("erro", nullValue())
                .body("data", notNullValue())
                .body("data.size()", is(1))
                .body("data[0].dataHoraCotacao", is("2020-01-02 10:08:18.114"))
                .body("data[0].tipoBoletim", is("Abertura"));
    }

    @Test
    public void testRetornoEndpointFindCotacaoMoedaAberturaOuIntermediarioByCodigoMoedaAndDataCotacao() {
        given()
                .queryParam("dataCotacao", "'11-05-2020'")
                .queryParam("simboloMoeda", "'AUD'")
                .when()
                .get(PATH_API + "/cotacao-moeda-abertura")
                .then()
                .statusCode(200)
                .body("code", is(valueOf(200)))
                .body("erro", nullValue())
                .body("data", notNullValue())
                .body("data.size()", is(1))
                .body("data[0].dataHoraCotacao", is("2020-11-05 13:09:31.955"))
                .body("data[0].tipoBoletim", is("Intermediário"));
    }

    @Test
    public void testRetornoEndpointFindCotacaoMoedaPeriodoFechamento() {
        given()
                .queryParam("dataInicial", "'01-01-2020'")
                .queryParam("dataFinal", "'02-01-2020'")
                .queryParam("simboloMoeda", "'AUD'")
                .when()
                .get(PATH_API + "/cotacao-moeda-periodo-fechamento")
                .then()
                .statusCode(200)
                .body("code", is(valueOf(200)))
                .body("erro", nullValue())
                .body("data", notNullValue())
                .body("data.size()", is(1))
                .body("data[0].dataHoraCotacao", is("2020-01-31 13:10:35.372"))
                .body("data[0].tipoBoletim", is("Fechamento"));
    }

}
