package com.github.maikoncanuto.quotes.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RespostaTipoCotacaoDolarAberturaOuIntermediarioDTO implements BaseDTO {

    @JsonProperty("@odata.context")
    private String dataContext;

    private List<TipoCotacaoDolarAberturaOuIntermediarioDTO> value;

    public String getDataContext() {
        return dataContext;
    }

    public void setDataContext(String dataContext) {
        this.dataContext = dataContext;
    }

    public List<TipoCotacaoDolarAberturaOuIntermediarioDTO> getValue() {
        return value;
    }

    public void setValue(List<TipoCotacaoDolarAberturaOuIntermediarioDTO> value) {
        this.value = value;
    }
}
