package com.github.maikoncanuto.quotes.domain.enums;

public enum MessageEnum {

    INTERCEPTOR_METODO_EXECUTADO("Método [%s] com parametros [%s] executado"),
    INTERCEPTOR_METODO__FIM_EXECUTADO("Fim do Método [%s]"),
    INTERCEPTOR_METODO_PROBLEMA("Problema na camada de serviço, método [%s] com parametros [%s] e erro: %s");

    private final String value;

    MessageEnum(final String param) {
        this.value = param;
    }

    public String get() {
        return value;
    }

}
