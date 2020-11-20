package com.github.maikoncanuto.quotes.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RespostaTipoCotacaoMoedaDTO extends BaseDTO {

    @JsonProperty("@odata.context")
    private String dataContext;

    private List<TipoCotacaoMoedaDTO> value;

    public String getDataContext() {
        return dataContext;
    }

    public void setDataContext(String dataContext) {
        this.dataContext = dataContext;
    }

    public List<TipoCotacaoMoedaDTO> getValue() {
        return value;
    }

    public void setValue(List<TipoCotacaoMoedaDTO> value) {
        this.value = value;
    }
}
