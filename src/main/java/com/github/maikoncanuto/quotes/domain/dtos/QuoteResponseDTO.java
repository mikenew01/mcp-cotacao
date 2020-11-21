package com.github.maikoncanuto.quotes.domain.dtos;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static org.eclipse.microprofile.openapi.annotations.enums.SchemaType.OBJECT;
import static org.eclipse.microprofile.openapi.annotations.enums.SchemaType.STRING;

public class QuoteResponseDTO implements BaseDTO {

    @Schema(description = "Código da resposta da requisição", name = "code", example = "200", type = STRING)
    private String code;

    @Schema(description = "Objeto de retorno da requisição", name = "data", type = OBJECT)
    private Object data;

    @Schema(description = "Informação do erro causado na aplicação ou requisição", name = "erro", example = "Ocorreu um problema no serviço", type = STRING)
    private String erro;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
