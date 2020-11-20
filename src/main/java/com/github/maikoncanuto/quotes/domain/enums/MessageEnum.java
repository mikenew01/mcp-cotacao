package com.github.maikoncanuto.quotes.domain.enums;

public enum MessageEnum {

    PROBLEMA_INTEGRACAO_MOEDAS_BACEN("Problema com a integração do serviço de moedas do Bacen."),
    PROBLEMA_INTEGRACAO_COTACOES_BACEN("Problema com a integração do serviço de cotações do Bacen."),
    INTERCEPTOR_METODO_EXECUTADO("Método [%s] com parametros [%s] executado"),
    INTERCEPTOR_METODO_PROBLEMA("Problema na camada de serviço, método [%s] com parametros [%s] e erro: %s");

    private final String value;

    MessageEnum(final String param) {
        this.value = param;
    }

    public String get() {
        return value;
    }

}
