package com.github.maikoncanuto.quotes.domain.dtos;

public class TipoCotacaoMoedaDTO extends BaseDTO {

    private Double paridadeCompra;
    private Double paridadeVenda;
    private Double cotacaoCompra;
    private Double cotacaoVenda;
    private String dataHoraCotacao;
    private String tipoBoletim;

    public Double getParidadeCompra() {
        return paridadeCompra;
    }

    public void setParidadeCompra(Double paridadeCompra) {
        this.paridadeCompra = paridadeCompra;
    }

    public Double getParidadeVenda() {
        return paridadeVenda;
    }

    public void setParidadeVenda(Double paridadeVenda) {
        this.paridadeVenda = paridadeVenda;
    }

    public Double getCotacaoCompra() {
        return cotacaoCompra;
    }

    public void setCotacaoCompra(Double cotacaoCompra) {
        this.cotacaoCompra = cotacaoCompra;
    }

    public Double getCotacaoVenda() {
        return cotacaoVenda;
    }

    public void setCotacaoVenda(Double cotacaoVenda) {
        this.cotacaoVenda = cotacaoVenda;
    }

    public String getDataHoraCotacao() {
        return dataHoraCotacao;
    }

    public void setDataHoraCotacao(String dataHoraCotacao) {
        this.dataHoraCotacao = dataHoraCotacao;
    }

    public String getTipoBoletim() {
        return tipoBoletim;
    }

    public void setTipoBoletim(String tipoBoletim) {
        this.tipoBoletim = tipoBoletim;
    }
}
